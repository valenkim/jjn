package manager;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.TravelInfo;

public class DateManager extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Calendar startCal = Calendar.getInstance();
		Calendar endCal = Calendar.getInstance();
		
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		
		//나중에 프린트할때 month+1 해줘야함
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		try {
			
			startCal.setTime(sdf.parse(startDate));
			endCal.setTime(sdf.parse(endDate));			
			
		} catch (ParseException e) {
			
			System.out.println("이상한 문자열");
			e.printStackTrace();
			
		}
		
		TravelInfo travel = new TravelInfo();
		java.sql.Date s = new java.sql.Date(startCal.getTimeInMillis());
		java.sql.Date e = new java.sql.Date(endCal.getTimeInMillis());
<<<<<<< HEAD
		
=======
>>>>>>> refs/remotes/choose_remote_name/master
		if(travel.saveDate(s, e)) {
			response.setCharacterEncoding("utf-8");
		    System.out.println("날짜를 선택하였습니다.");
		}
		
		ServletContext context = request.getSession().getServletContext();
		RequestDispatcher rd  = context.getRequestDispatcher("/SelectToDoView.jsp");
		
		rd.forward(request, response);
	}

	private void showCalendar(Calendar cal) {
		// TODO Auto-generated method stub
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
