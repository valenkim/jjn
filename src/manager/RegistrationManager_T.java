package manager;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.TravelerInfo;

public class RegistrationManager_T extends HttpServlet {

	private static final long serialVersionUID = 1L;

	Connection con;
	PreparedStatement pstmt;
	Statement stmt;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 클라이언트의 브라우져에 무언가를 출력할 수 있는 문자기반 출력스트림 생성
		PrintWriter out = response.getWriter();
		out.print("Your send method is get");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		PrintWriter out = response.getWriter();

		String mode = request.getParameter("mode").toString();
	
		
		try {
			
			TravelerInfo memberinfo = new TravelerInfo();

			if (mode.equals("create") ) {
				String userid = request.getParameter("id").toString();
				String userpwd = request.getParameter("pass").toString();
				String name = request.getParameter("name").toString();
				String email = request.getParameter("email").toString();
				String tel = request.getParameter("tel").toString();
				String add = request.getParameter("address").toString();
				String hate = request.getParameter("hate").toString();
				
				
				
				if (memberinfo.createTravelerInfo(userid, userpwd, name, email, add, tel, hate)) {
					response.setCharacterEncoding("utf-8");
					System.out.println("가입 정보가 저장되었습니다.");
				} else {
					System.out.println("실패했습니다.");
				}
			}

			else if (mode.equals("delete")) {
				String userid = request.getParameter("id").toString();
				
				if (memberinfo.deleteTravelerInfo(userid)) {
					response.setCharacterEncoding("utf-8");
					System.out.println("탈퇴 정보가 저장되었습니다.");
				} else {
					System.out.println("실패했습니다.");
				}
			}
					

		}

		catch (Exception e) {
			e.printStackTrace();
		}

	}

}


