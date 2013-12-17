package manager;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mapping.GsonView;
import mappingInfo.Item;
import entity.CompanyInfo;


public class RegistrationManager_C extends HttpServlet {

	private static final long serialVersionUID = 1L;

	Connection con;
	PreparedStatement pstmt;
	Statement stmt;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 클라이언트의 브라우져에 무언가를 출력할 수 있는 문자기반 출력스트림 생성
		PrintWriter out = response.getWriter();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {


		request.setCharacterEncoding("utf-8");	
		response.setCharacterEncoding("utf-8");	
		
		String mode = request.getParameter("mode").toString();
		System.out.print(mode);
	
		
		try {
			CompanyInfo memberinfo = new CompanyInfo();

			if (mode.equals("create") ) {
				String userid = request.getParameter("id").toString();
				String userpwd = request.getParameter("pass").toString();
				String name = request.getParameter("name").toString();
				String email = request.getParameter("email").toString();
				String tel = request.getParameter("tel").toString();
				String add = request.getParameter("address").toString();
				String type = request.getParameter("type").toString();
				String event = request.getParameter("event").toString();
				String ctype ;
		
												
				System.out.println(add);
				if((type.equals("한식"))||(type.equals("양식"))||(type.equals("중식"))||(type.equals("일식"))||(type.equals("분식"))||(type.equals("기타1"))){
					ctype = "1";
				}
				else{
					ctype = "0";
				}	
		
				
				if (memberinfo.createCompanyInfo(userid, userpwd, name, email, add, tel, event,ctype,type)) {
					response.setCharacterEncoding("utf-8");
					System.out.println("가입 정보가 저장되었습니다.");
				} else {
					System.out.println("실패했습니다.");
				}
			}

			else if (mode.equals("delete")) {
				String userid = request.getParameter("id").toString();
				
				if (memberinfo.deleteCompanyInfo(userid)) {
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



