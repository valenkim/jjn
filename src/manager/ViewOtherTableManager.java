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
import entity.RouteInfo;

public class ViewOtherTableManager extends HttpServlet {
	DBconnection con = new DBconnection();
	RouteInfo newroute = new RouteInfo();
	
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request,HttpServletResponse response)
	        throws IOException, ServletException {    
		
		request.setCharacterEncoding("utf-8");	
		response.setCharacterEncoding("utf-8");	
		

	    ArrayList<RouteInfo> t;
		
		t = newroute.selectall();

		for(int i=0; i<t.size(); i++){
			   request.setAttribute("userid"+i, t.get(i).userid);
			   request.setAttribute("starscore"+i, t.get(i).score);
			}

			request.setAttribute("count",t.size());

	   ServletContext context = request.getSession().getServletContext();
	   RequestDispatcher rd  = context.getRequestDispatcher("/OtherRouteView.jsp");
		
		rd.forward(request, response);
	}
}
