package manager;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.RouteInfo;
import entity.TravelInfo;


public class SaveManager extends HttpServlet {
	private static final long serialVersionUID = 1L;
       


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RouteInfo r = new RouteInfo();
		ArrayList<TravelInfo> t  = new ArrayList<TravelInfo>();
		TravelInfo ti = new TravelInfo();
		
		t = ti.loadTravelInfo();
		System.out.println("id : "+t.get(0).userid);
		String routeName = request.getParameter("routename");
		r.saveOwnRoute(routeName, t.get(0).userid, t);		
		
			
		ti.deleteTravel();
		
		ServletContext context = request.getSession().getServletContext();
		RequestDispatcher rd  = context.getRequestDispatcher("/TravelerUI.jsp");
		rd.forward(request, response);		
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
