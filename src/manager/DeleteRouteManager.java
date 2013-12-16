package manager;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import db.DBconnection;
import entity.RouteInfo;

public class DeleteRouteManager extends HttpServlet {
	DBconnection con = new DBconnection();
	RouteInfo nroute = new RouteInfo();
	
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request,HttpServletResponse response)
	        throws IOException, ServletException {    

		String routename = request.getParameter("routename").toString();
		System.out.println(routename);
		nroute.deleteRoute(routename);

	   ServletContext context = request.getSession().getServletContext();
	   RequestDispatcher rd  = context.getRequestDispatcher("/AdminUI.jsp");
		
		rd.forward(request, response);
	}

}
