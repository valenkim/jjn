package manager;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.DBconnection;
import entity.Route;

public class ViewOtherTableManager extends HttpServlet {
	DBconnection con = new DBconnection();
	Route newroute = new Route();
	
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request,HttpServletResponse response)
	        throws IOException, ServletException {    

		ArrayList<Route> t;
		ArrayList<Route> s;
		
		t = newroute.selectallid();
	    s = newroute.selectallstarscore();
	   request.setAttribute("userid", t);
	   request.setAttribute("starscore", s);

	   ServletContext context = request.getSession().getServletContext();
	   RequestDispatcher rd  = context.getRequestDispatcher("/ViewOtherRoute.jsp");
		
		rd.forward(request, response);
	}
}
