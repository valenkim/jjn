package manager;

import entity.CompanyInfo;
import entity.TravelInfo;
import gson.GsonView;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

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

		ArrayList<CompanyInfo> ci = null ;
		CompanyInfo c = new CompanyInfo();
		
		int j =0;
		
		try {
			ci = c.selectCompany();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("좌표변환 성공");
		
		for(int index=0; index<ci.size(); index++){
			
			c =  gv.distance(ci.get(index).id, ci.get(index).address, ci.get(index).title, i.lat, i.lng, ci.get(index).lat, ci.get(index).lng);

			if(c != null){
				request.setAttribute("title"+j,c.title);
				request.setAttribute("address"+j,c.address);
				request.setAttribute("userId"+j, c.id);
				System.out.println(c.title);
				
				j++;
			}
			
		}
		request.setAttribute("count", j);
		
		ServletContext context = request.getSession().getServletContext();
		RequestDispatcher rd  = context.getRequestDispatcher("/SelectMealView.jsp");
		rd.forward(request, response);		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		CompanyInfo c = new CompanyInfo();
		TravelInfo t = new TravelInfo();
		
		String id = request.getParameter("userId");
		
		try {
			c = c.findMealCompany(Integer.parseInt(id));
			t.saveMeal(c);
			System.out.println("음식점을 저장했습니다.");
			

			
		} catch (SQLException e) {
			e.printStackTrace();
			
		}finally{
			
			
			
			ServletContext context = request.getSession().getServletContext();
			RequestDispatcher rd  = context.getRequestDispatcher("/SelectToDoView.jsp");
			rd.forward(request, response);		
		
		}
	}

}
