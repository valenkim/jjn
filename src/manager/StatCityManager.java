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

public class StatCityManager extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	DBconnection con = new DBconnection();
	Movement move= new Movement();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try{

			ArrayList <Movement> m = new ArrayList<Movement>();
	
			m = move.selectCity("0");
			
			for(int i=0; i<m.size(); i++){
				request.setAttribute("city"+i, m.get(i).city);			
			}
			
			request.setAttribute("count",m.size());

			ServletContext context = request.getSession().getServletContext();
			RequestDispatcher rd  = context.getRequestDispatcher("/SelectStatCityView.jsp");
			
			rd.forward(request, response);
		
			 }catch(Exception e){
				  e.printStackTrace();
			 }
	}
	public void doPost(HttpServletRequest request,HttpServletResponse response)
	        throws IOException, ServletException {
		
		request.setCharacterEncoding("utf-8");	
		response.setCharacterEncoding("utf-8");	
		String statCity = request.getParameter("statCity");
		
		System.out.println(statCity);
		System.out.println(Arrays.toString(statCity.getBytes()));
		
		TravelInfo travel = new TravelInfo();
		if(travel.saveCity("statCity", statCity)) {

		    System.out.println("출발지를 선택하셨습니다.");
		}
		
		ServletContext context = request.getSession().getServletContext();
		RequestDispatcher rd  = context.getRequestDispatcher("/DestCityManager");
		
		rd.forward(request, response);
		
		
	}
		

}

