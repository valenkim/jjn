package servlet.form;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet{
	private String MemberId="java";
	private String MemberPass="servlet";
	public LoginServlet(){
		
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException{
		doPost(request,response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException{
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("");
		if(id.equals(MemberId) && pass.equals(MemberPass)){
			//����
			out.println("���̵� :"+id+"���� �α��� �ϼ̽��ϴ�.");
			out.println("��й�ȣ :"+pass+"");
		}
		else if(!id.equals(MemberId)){
			//����
			out.println("���̵� Ʋ���ϴ�.");
		}
		else if(!pass.equals(MemberPass)){
			//����
			out.println("");
			out.println("��й�ȣ�� Ʋ���ϴ�.");
		}
		out.println("<br><a href='form/login_form.html'>�α��� ������ �̵�</a>");
		out.println("");
	}
}
