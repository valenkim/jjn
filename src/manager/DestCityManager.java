package manager;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.DBconnection;
import entity.Movement;
import entity.TravelInfo;

public class DestCityManager extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	DBconnection con = new DBconnection();
	Movement move= new Movement();

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try{
			

			TravelInfo t = new TravelInfo();
			
			t  = t.selectStatCity();
			
			ArrayList<Movement> m = new ArrayList<Movement>();

			m = move.selectCity(t.stat);

			for(int i=0; i<m.size(); i++){
			   request.setAttribute("city"+i, m.get(i).city);			
			}

			request.setAttribute("count",m.size());
			request.setAttribute("statCity", t.stat);

			ServletContext context = request.getSession().getServletContext();
			RequestDispatcher rd  = context.getRequestDispatcher("/SelectDestCityView.jsp");
			
			rd.forward(request, response);
		
			 }catch(Exception e){
				  e.printStackTrace();
			 }
	}
	public void doGet(HttpServletRequest request,HttpServletResponse response)
	        throws IOException, ServletException {
		
		String destCity = request.getParameter("destCity");
	
		System.out.println(destCity);
		System.out.println(Arrays.toString(destCity.getBytes()));
		
		TravelInfo travel = new TravelInfo();
		
		if(travel.saveCity("destCity", destCity)) {
			response.setCharacterEncoding("utf-8");
		    System.out.println("�������� �����ϼ̽��ϴ�.");
		}
		
		ServletContext context = request.getSession().getServletContext();
		RequestDispatcher rd  = context.getRequestDispatcher("/TrainManager");
		
		rd.forward(request, response);
		
		
	}
		

}

