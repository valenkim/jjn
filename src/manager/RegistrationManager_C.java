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
		// Ŭ���̾�Ʈ�� �������� ���𰡸� ����� �� �ִ� ���ڱ�� ��½�Ʈ�� ����
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
				if((type.equals("�ѽ�"))||(type.equals("���"))||(type.equals("�߽�"))||(type.equals("�Ͻ�"))||(type.equals("�н�"))||(type.equals("��Ÿ1"))){
					ctype = "1";
				}
				else{
					ctype = "0";
				}	
		
				
				if (memberinfo.createCompanyInfo(userid, userpwd, name, email, add, tel, event,ctype,type)) {
					response.setCharacterEncoding("utf-8");
					System.out.println("���� ������ ����Ǿ����ϴ�.");
				} else {
					System.out.println("�����߽��ϴ�.");
				}
			}

			else if (mode.equals("delete")) {
				String userid = request.getParameter("id").toString();
				
				if (memberinfo.deleteCompanyInfo(userid)) {
					response.setCharacterEncoding("utf-8");
					System.out.println("Ż�� ������ ����Ǿ����ϴ�.");
				} else {
					System.out.println("�����߽��ϴ�.");
				}
			}
					

		}

		catch (Exception e) {
			e.printStackTrace();
		}

	}

}



