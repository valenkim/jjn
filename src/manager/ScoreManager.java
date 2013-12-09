package manager;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import db.DBconnection;
import entity.Route;
import entity.Score;

public class ScoreManager extends HttpServlet {


	DBconnection con = new DBconnection();
	Score newscore = new Score();
	
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request,HttpServletResponse response)
	        throws IOException, ServletException {    

		String userid = request.getParameter("userid").toString();
		
		ArrayList<Route> t;
		ArrayList<Route> s;
			
		t = newscore.selectallid();
	    s = newscore.selectallstarscore();

	   request.setAttribute("userid", t);
	   request.setAttribute("starscore", s);

	   ServletContext context = request.getSession().getServletContext();
	   RequestDispatcher rd  = context.getRequestDispatcher("/seeScore.jsp");
		
		rd.forward(request, response);
	}
	
	public void doPost(HttpServletRequest request,HttpServletResponse response)
	        throws IOException, ServletException {    
		
		String userid = request.getParameter("userid").toString();
		String starscore = request.getParameter("starscore").toString();
		
		Score nscore = new Score();
		
		if(nscore.saveScore(userid, starscore)) {
			response.setCharacterEncoding("utf-8");
		    System.out.println("�ð��� �����Ͽ����ϴ�.");
		}
		
		ServletContext context = request.getSession().getServletContext();
		RequestDispatcher rd  = context.getRequestDispatcher("/seeScore.jsp");
		
		rd.forward(request, response);
		
	}
	
}

