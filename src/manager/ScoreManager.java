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
		
		t = newscore.selectall();

		for(int i=0; i<t.size(); i++){
			   request.setAttribute("userid"+i, t.get(i).userid);
			   request.setAttribute("starscore"+i, t.get(i).starscore);
			}

			request.setAttribute("count",t.size());

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

