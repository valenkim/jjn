package manager;

import gson.GsonView;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Info.Item;


public class MealManager extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		GsonView gv = new GsonView();
		
		String add = request.getParameter("add");
		Item i;
		
		i = gv.changeAddress(add);

		
		gv.distance(i.lat, i.lng, j.lat, j.lng);
		System.out.println(i.lng);
		request.setAttribute("lng",i.lng);
		request.setAttribute("lat",i.lat);
		request.setAttribute("title",i.title);
		
		
		ServletContext context = request.getSession().getServletContext();
		RequestDispatcher rd  = context.getRequestDispatcher("/SelectMealView.jsp");
		rd.forward(request, response);		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
