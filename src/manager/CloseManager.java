package manager;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;









import db.DBconnection;
import entity.TravelInfo;

public class CloseManager extends HttpServlet{
	
	DBconnection con = new DBconnection();
	Connection conn = null;
	PreparedStatement  pstmt = null;
	ResultSet rs = null;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		TravelInfo t = new TravelInfo();
		
		try{
			
			t.deleteTravel();
				
			
		}catch(Exception e){
			e.printStackTrace(); 
		}finally{
			
			ServletContext context = request.getSession().getServletContext();
			RequestDispatcher rd  = context.getRequestDispatcher("/TravelerUI.jsp");
			
			rd.forward(request, response);
		
		}
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		
		try{
			TravelInfo t = new TravelInfo();
			
			Date startDate = null;
			Date endDate = null;
			int id = 0;
			
			conn = con.setDB(conn);
			
			String sql = "SELECT startDate, endDate FROM Travel WHERE dateCount = 1";
			pstmt  = conn.prepareStatement(sql);
			rs = pstmt.executeQuery(sql);
			
			while(rs.next()){
				startDate = rs.getDate("startDate");
				endDate = rs.getDate("endDate");
			}
			
			if(startDate.equals(endDate)){
				System.out.println("여행 루트 완성!!");
			}
			else{
				Calendar startCal = Calendar.getInstance();
				Calendar endCal = Calendar.getInstance();
				
				 startCal.setTime(startDate);
				 startCal.add(Calendar.DAY_OF_MONTH, 1);
				 endCal.setTime(endDate);		
				 
				 
				 java.sql.Date s = new java.sql.Date(startCal.getTimeInMillis());
				 java.sql.Date e = new java.sql.Date(endCal.getTimeInMillis());
				 
				if(t.updateDate(s, e)) {
					response.setCharacterEncoding("utf-8");
				    System.out.println("갱신하였습니다.");
				}
					 
				 
			
			}
			rs.close();
			con.closeDB(conn, pstmt);
				
			
		}catch(Exception e){
			e.printStackTrace(); 
		}finally{
			
			ServletContext context = request.getSession().getServletContext();
			RequestDispatcher rd  = context.getRequestDispatcher("/SelectToDoView.jsp");
			
			rd.forward(request, response);
		
		}
		
		
	}
}

