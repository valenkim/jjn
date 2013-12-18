package manager;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import db.DBconnection;
import entity.TravelerInfo;
import entity.CompanyInfo;

public class ViewUserManager extends HttpServlet {
	DBconnection con = new DBconnection();
	TravelerInfo tra = new TravelerInfo();
	CompanyInfo com = new CompanyInfo();
	
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");	
		response.setCharacterEncoding("utf-8");	
		
		  ArrayList<TravelerInfo> t = null;
		  try {
			t = tra.selectTall();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	   for(int i=0; i<t.size(); i++){
		   request.setAttribute("userid"+i, t.get(i).userid);
		   //request.setAttribute("userpwd"+i, t.get(i).userpwd);
		   request.setAttribute("name"+i, t.get(i).name);
		   request.setAttribute("tel"+i, t.get(i).tel);
		   request.setAttribute("add"+i, t.get(i).add);
		   request.setAttribute("email"+i, t.get(i).email);
		   request.setAttribute("hate"+i, t.get(i).hate);
		 			   
		}

		request.setAttribute("counti",t.size());
		
	    ServletContext context = request.getSession().getServletContext();
	    RequestDispatcher rd  = context.getRequestDispatcher("/SelectTravelerView.jsp");
	
     	rd.forward(request, response);

		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");	
		response.setCharacterEncoding("utf-8");	
		
		ArrayList<CompanyInfo> c = null;
	
			try {
				c = com.selectCall();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
					for(int i=0; i<c.size(); i++){
					   request.setAttribute("id"+i, c.get(i).id);
					   request.setAttribute("address"+i, c.get(i).address);
					   request.setAttribute("lat"+i, c.get(i).lat);
					   request.setAttribute("lng"+i, c.get(i).lng);
					   request.setAttribute("title"+i, c.get(i).title);
					   request.setAttribute("type"+i, c.get(i).type);
					   request.setAttribute("event"+i, c.get(i).event);
					   request.setAttribute("pass"+i, c.get(i).pass);
					   request.setAttribute("email"+i, c.get(i).email);
					   request.setAttribute("tel"+i, c.get(i).tel);
					   
					}

					request.setAttribute("counti",c.size());
					
				ServletContext context = request.getSession().getServletContext();
				RequestDispatcher rd  = context.getRequestDispatcher("/SelectCompanyView.jsp");
				
				rd.forward(request, response);

		
		// TODO Auto-generated method stub
	}

}
