package manager;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import db.DBconnection;
import entity.TimeTable;
import entity.TravelInfo;

public class TimeTableManager extends HttpServlet {

	DBconnection con = new DBconnection();
	TimeTable time = new TimeTable();
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs = null;
	
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request,HttpServletResponse response)
	        throws IOException, ServletException {    
		
		conn = con.setDB(conn);

		int rowcount = 0;
		TimeTable tt  = new TimeTable();
		 
		tt = time.selectTravelTime();
		

 		  request.setAttribute("startTime", tt.startTime);
 		  request.setAttribute("timer", tt.timer);

		request.setAttribute("count",rowcount);
		System.out.println(tt.startTime);
		System.out.println(tt.timer);
		ServletContext context = request.getSession().getServletContext();
		RequestDispatcher rd  = context.getRequestDispatcher("/TimeTableView.jsp");
		
		rd.forward(request, response);
	}
	
	public void doPost(HttpServletRequest request,HttpServletResponse response)
	        throws IOException, ServletException {    
		int t = Integer.parseInt(request.getParameter("time"));
		TravelInfo travel = new TravelInfo();
		if(travel.saveTime(2, t)) {
			response.setCharacterEncoding("utf-8");
		    System.out.println("시간은 이미 선택하셨습니다.");
		}
		
		ServletContext context = request.getSession().getServletContext();
		RequestDispatcher rd  = context.getRequestDispatcher("/SelectToDoView.jsp");
		
		rd.forward(request, response);
		
	}
	
}
