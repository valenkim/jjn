package manager;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import db.DBconnection;
import entity.TimeTable;
import entity.TravelInfo;

public class TimeManager extends HttpServlet {

	DBconnection con = new DBconnection();
	
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request,HttpServletResponse response)
	        throws IOException, ServletException {    

		TimeTable time = new TimeTable();
		ArrayList<TimeTable> t;
		TimeTable s;
			
		t = time.selectTime();
		s = time.selectTravelTime();

	   for(int  i=0; i<t.size(); i++){
		  request.setAttribute("time"+i, t.get(i).time);
	   }
	   request.setAttribute("id", s.id);
	   request.setAttribute("startTime", s.startTime);
	   request.setAttribute("timer", s.timer);
	   request.setAttribute("count",t.size());

	   ServletContext context = request.getSession().getServletContext();
	   RequestDispatcher rd  = context.getRequestDispatcher("/SelectTimeView.jsp");
		
		rd.forward(request, response);
	}
	
	public void doPost(HttpServletRequest request,HttpServletResponse response)
	        throws IOException, ServletException {    
		
		int t = Integer.parseInt(request.getParameter("time"));
		int id = Integer.parseInt(request.getParameter("id"));
		TravelInfo travel = new TravelInfo();
		
		if(travel.saveTime(id, t)) {
			response.setCharacterEncoding("utf-8");
		    System.out.println("시간을 선택하였습니다.");
		}
		
		ServletContext context = request.getSession().getServletContext();
		RequestDispatcher rd  = context.getRequestDispatcher("/SelectToDoView.jsp");
		
		rd.forward(request, response);
		
	}
	
}
