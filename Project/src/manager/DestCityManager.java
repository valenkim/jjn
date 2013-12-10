package manager;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

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
			

			String statCity = request.getParameter("statCity").toString();
			
			ArrayList<Movement> m = new ArrayList<Movement>();

			m = move.selectCity(statCity);

			for(int i=0; i<m.size(); i++){
			   request.setAttribute("city"+i, m.get(i).city);			
			}

			request.setAttribute("count",m.size());
			request.setAttribute("statCity", statCity);

			ServletContext context = request.getSession().getServletContext();
			RequestDispatcher rd  = context.getRequestDispatcher("/SelectDestCityView.jsp");
			
			rd.forward(request, response);
		
			 }catch(Exception e){
				  e.printStackTrace();
			 }
	}
	public void doGet(HttpServletRequest request,HttpServletResponse response)
	        throws IOException, ServletException {
		
		String destCity = request.getParameter("destCity").toString();
	
		System.out.println(destCity);
		
		TravelInfo travel = new TravelInfo();
		
		if(travel.saveCity("destCity", destCity)) {
			response.setCharacterEncoding("utf-8");
		    System.out.println("도착지를 선택하셨습니다.");
		}
		
		ServletContext context = request.getSession().getServletContext();
		RequestDispatcher rd  = context.getRequestDispatcher("/TrainManager");
		
		rd.forward(request, response);
		
		
	}
		

}

