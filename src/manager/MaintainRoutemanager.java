package manager;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import db.DBconnection;
import entity.Score;
import entity.TimeTable;
import entity.TravelInfo;
import entity.Route;

public class MaintainRoutemanager extends HttpServlet {
	DBconnection con = new DBconnection();
	Route newroute = new Route();
	
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request,HttpServletResponse response)
	        throws IOException, ServletException {    

		ArrayList<Route> t;
		ArrayList<Route> s;
		
		t = newroute.selectallid();
	    s = newroute.selectallstarscore();
	   request.setAttribute("userid", t.userid);
	   request.setAttribute("starscore", s);

	   ServletContext context = request.getSession().getServletContext();
	   RequestDispatcher rd  = context.getRequestDispatcher("/maintainrouteinfoview.jsp");
		
		rd.forward(request, response);
	}
	
	public void doPost(HttpServletRequest request,HttpServletResponse response)
	        throws IOException, ServletException {    
		
		String userid = request.getParameter("userid").toString();
		String starscore = request.getParameter("starscore").toString();
		
		Route nroute = new Route();
		
		if(nroute.saveRoute(userid, starscore)) {
			response.setCharacterEncoding("utf-8");
		    System.out.println("�ð��� �����Ͽ����ϴ�.");
		}
		
		ServletContext context = request.getSession().getServletContext();
		RequestDispatcher rd  = context.getRequestDispatcher("/maintainrouteinfoview.jsp");
		
		rd.forward(request, response);
		
	 }
		
	}

