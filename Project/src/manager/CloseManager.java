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
		
		
		try{
			
			conn = con.setDB(conn);
			
			String sql = "Delete FROM Travel";
			pstmt  = conn.prepareStatement(sql);
			pstmt.executeUpdate(sql);
			
			sql = "INSERT INTO Travel (id) VALUE ('1')";
			pstmt=conn.prepareStatement(sql);
			pstmt.executeUpdate();		
	
			con.closeDB(conn, pstmt);
				
			
		}catch(Exception e){
			e.printStackTrace(); 
		}finally{
			
			ServletContext context = request.getSession().getServletContext();
			RequestDispatcher rd  = context.getRequestDispatcher("/SelectToDoView.jsp");
			
			rd.forward(request, response);
		
		}
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		
		try{
			TravelInfo t = new TravelInfo();
			
			Date startDate = null;
			Date endDate = null;
			
			conn = con.setDB(conn);
			
			String sql = "SELECT startDate, endDate FROM Travel WHERE id = 1";
			pstmt  = conn.prepareStatement(sql);
			rs = pstmt.executeQuery(sql);
			
			while(rs.next()){
				startDate = rs.getDate("startDate");
				endDate = rs.getDate("endDate");
			}
			
			if(startDate == endDate){
				//끝
			}
			else{
				Calendar cal = Calendar.getInstance();
				 cal.setTime(startDate);
				 cal.add(Calendar.DAY_OF_MONTH, 1);
				 System.out.println(Calendar.DAY_OF_MONTH);
				 
				 
				 java.sql.Date s = new java.sql.Date(cal.getTimeInMillis());
				 
				if(t.saveDate(s)) {
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

