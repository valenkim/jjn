package manager;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.DBconnection;
import entity.TravelInfo;

public class FreeManager extends HttpServlet {

	TravelInfo ti = new TravelInfo();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
			
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try{
			if(ti.saveFreeTravel()){
				System.out.println("자유여행 성공");
			}
		}catch(Exception e){
			e.printStackTrace(); 
		}finally{
			
			ServletContext context = request.getSession().getServletContext();
			RequestDispatcher rd  = context.getRequestDispatcher("/CloseManager");
			rd.forward(request, response);		
		}
		
		
		
		
	}

}
