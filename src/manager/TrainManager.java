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

public class TrainManager extends HttpServlet {

	private static final long serialVersionUID = 1L;
	DBconnection con = new DBconnection();
	Movement move= new Movement();
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	Connection conn;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try{

			TravelInfo t = new TravelInfo();
			
			t = t.selectStatCity();
			
			ArrayList<Movement> m = new ArrayList<Movement>();
			System.out.println(t.stat);
			System.out.println(t.dest);
			m = move.selectMovement(t.stat, t.dest);
			
			for(int i=0; i<m.size(); i++){
			   request.setAttribute("train"+i, m.get(i).train);		
			   request.setAttribute("trainTime"+i, m.get(i).trainTime);
			   request.setAttribute("id"+i, m.get(i).id);
			}

			request.setAttribute("count",m.size());

			ServletContext context = request.getSession().getServletContext();
			RequestDispatcher rd  = context.getRequestDispatcher("/SelectTrainView.jsp");
			
			rd.forward(request, response);
		
		 }catch(Exception e){
				  e.printStackTrace();
		 }
	}

	public void doPost(HttpServletRequest request,HttpServletResponse response)
	        throws IOException, ServletException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		TravelInfo travel = new TravelInfo();
		if(travel.saveTrain(id)) {
			response.setCharacterEncoding("utf-8");
		    System.out.println("������ �����ϼ̽��ϴ�.");
		}
		
		ServletContext context = request.getSession().getServletContext();
		RequestDispatcher rd  = context.getRequestDispatcher("/SelectToDoView.jsp");
		
		rd.forward(request, response);

	}
		


}
