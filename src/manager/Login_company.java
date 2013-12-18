package manager;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.CompanyInfo;

public class Login_company extends HttpServlet {

	private static final long serialVersionUID = 1L;

	Connection con;
	PreparedStatement pstmt;
	Statement stmt;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Ŭ���̾�Ʈ�� �������� ���𰡸� ����� �� �ִ� ���ڱ�� ��½�Ʈ�� ����
		PrintWriter out = response.getWriter();
		out.print("Your send method is get");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		PrintWriter out = response.getWriter();

		
		try {
				CompanyInfo memberinfo = new CompanyInfo();
			
				String userid = request.getParameter("id").toString();
				String userpwd = request.getParameter("pass").toString();
							
				if(memberinfo.loginCompanyInfo(userid, userpwd)){
					response.setCharacterEncoding("utf-8");
					System.out.println("�α��μ���.");
					
					ServletContext context = request.getSession().getServletContext();
					RequestDispatcher rd  = context.getRequestDispatcher("/CompanyUI.jsp");
					
					rd.forward(request, response);		
					
				} else {
					System.out.println("�����߽��ϴ�.");
					ServletContext context = request.getSession().getServletContext();
					RequestDispatcher rd  = context.getRequestDispatcher("/MainUI.jsp");
					
				}
				
		}
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}



