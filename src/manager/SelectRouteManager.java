package manager;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import db.DBconnection;
import entity.RouteInfo;

public class SelectRouteManager extends HttpServlet {
	DBconnection con = new DBconnection();
	RouteInfo newroute = new RouteInfo();
	RouteInfo nroute = new RouteInfo();
	
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request,HttpServletResponse response)
	        throws IOException, ServletException {    

		ArrayList<RouteInfo> t;
		
		t = newroute.selectall();

		for(int i=0; i<t.size(); i++){
			   request.setAttribute("userid"+i, t.get(i).userid);
			   request.setAttribute("routename"+i, t.get(i).routename);
			}

			request.setAttribute("count",t.size());

	   ServletContext context = request.getSession().getServletContext();
	   RequestDispatcher rd  = context.getRequestDispatcher("/SelectRouteInfoView.jsp");
		
		rd.forward(request, response);
	}
	
	public void doPost(HttpServletRequest request,HttpServletResponse response)
	        throws IOException, ServletException {    
		
		String routename = request.getParameter("routename").toString();
				
		ArrayList<RouteInfo> a;
		a = nroute.CallRouting(routename, "RouteStore");
		
		for(int i=0; i<a.size(); i++){
			   request.setAttribute("userid"+i, a.get(i).userid);
			   request.setAttribute("routename"+i, a.get(i).routename);
			   request.setAttribute("id"+i, a.get(i).id);
			   request.setAttribute("startTime"+i, a.get(i).startTime);
			   request.setAttribute("timecount"+i, a.get(i).timecount);
			   request.setAttribute("stat"+i, a.get(i).stat);
			   request.setAttribute("train"+i, a.get(i).train);
			   request.setAttribute("traincount"+i, a.get(i).traincount);
			   request.setAttribute("timer"+i, a.get(i).timer);
			   request.setAttribute("ctype"+i, a.get(i).ctype);
			   request.setAttribute("dest"+i, a.get(i).dest);
			   request.setAttribute("startDate"+i, a.get(i).startDate);
			   request.setAttribute("endDate"+i, a.get(i).endDate);
			   request.setAttribute("freeCount"+i, a.get(i).freeCount);
			   request.setAttribute("dateCount"+i, a.get(i).dateCount);
			   request.setAttribute("companyName"+i, a.get(i).companyName);
			   request.setAttribute("score"+i, a.get(i).score);
			}

			request.setAttribute("counti",a.size());
			
		ServletContext context = request.getSession().getServletContext();
		RequestDispatcher rd  = context.getRequestDispatcher("/DeleteRouteInfoView.jsp");
		
		rd.forward(request, response);
		
	 }
		
	}

