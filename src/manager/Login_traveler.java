package manager;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.TravelerInfo;

public class Login_traveler  extends HttpServlet {

	private static final long serialVersionUID = 1L;

	Connection con;
	PreparedStatement pstmt;
	Statement stmt;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		try {
				TravelerInfo memberinfo = new TravelerInfo();
			
				String id = request.getParameter("id").toString();
				String pass = request.getParameter("pass").toString();
				request.setAttribute("id",id);
							
				if(memberinfo.loginAdminInfo(id, pass)){
					response.setCharacterEncoding("utf-8");
					System.out.println("로그인성공.");
						
					if (memberinfo.UpdateTravelInfo(id)) {
						response.setCharacterEncoding("utf-8");
						System.out.println("업데이트 완료.");
						

						ServletContext context = request.getSession().getServletContext();
						RequestDispatcher rd  = context.getRequestDispatcher("/AdminUI.jsp");
						
						rd.forward(request, response);		
					} else {
						System.out.println("실패했습니다.");
					}
										
				} else {
					System.out.println("실패했습니다.");
					ServletContext context = request.getSession().getServletContext();
					RequestDispatcher rd  = context.getRequestDispatcher("/MainUI.jsp");
				}
				
		}
		catch (Exception e) {
			e.printStackTrace();
		}

	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		
		try {
				TravelerInfo memberinfo = new TravelerInfo();
			
				String id = request.getParameter("id").toString();
				String pass = request.getParameter("pass").toString();
				request.setAttribute("id",id);
							
				if(memberinfo.loginTravelerInfo(id, pass)){
					response.setCharacterEncoding("utf-8");
					System.out.println("로그인성공.");
						
					if (memberinfo.UpdateTravelInfo(id)) {
						response.setCharacterEncoding("utf-8");
						System.out.println("업데이트 완료.");
						

						ServletContext context = request.getSession().getServletContext();
						RequestDispatcher rd  = context.getRequestDispatcher("/TravelerUI.jsp");
						
						rd.forward(request, response);		
					} else {
						System.out.println("실패했습니다.");
					}
										
				} else {
					System.out.println("실패했습니다.");
				}
				
		}
		catch (Exception e) {
			e.printStackTrace();
		}

	}
	
}






