package manager;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import db.DBconnection;
import entity.Score;

public class ScoreManager extends HttpServlet {


	

	DBconnection con = new DBconnection();
	Score newscore = new Score();
	
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request,HttpServletResponse response)
	        throws IOException, ServletException {    

		request.setCharacterEncoding("utf-8");	
		response.setCharacterEncoding("utf-8");	
		
	    ArrayList<Score> t;
		
		t = newscore.selectall();
        int i;
        
		for(i=0; i<t.size(); i++){
			   request.setAttribute("userid"+i, t.get(i).userid);
			   request.setAttribute("routename"+i, t.get(i).routename);
			   request.setAttribute("score"+i, t.get(i).score);
			}

			request.setAttribute("count",i);
			System.out.println(t.size());

	   ServletContext context = request.getSession().getServletContext();
	   RequestDispatcher rd  = context.getRequestDispatcher("/SeeScoreView.jsp");
		
		rd.forward(request, response);
	}
	
	public void doPost(HttpServletRequest request,HttpServletResponse response)
	        throws IOException, ServletException {    
		
		request.setCharacterEncoding("utf-8");	
		response.setCharacterEncoding("utf-8");	
		
		
		String routename = request.getParameter("routename").toString();
		String sco = request.getParameter("score").toString();
		int scor = Integer.parseInt(sco);
		
		ArrayList<Score> s;
		s = newscore.selectscore(routename);
		int score = scor + s.get(0).score;
		
		Score nscore = new Score();
		
		if(nscore.updateScore(routename, score)) {
			response.setCharacterEncoding("utf-8");
		    System.out.println("별점 기록이 완료되었습니다..");
		}
		
		ServletContext context = request.getSession().getServletContext();
		RequestDispatcher rd  = context.getRequestDispatcher("/AdminUI.jsp");
		
		rd.forward(request, response);
		
	}
	
}

