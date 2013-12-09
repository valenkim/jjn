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
			//응답
			out.println("아이디 :"+id+"님이 로그인 하셨습니다.");
			out.println("비밀번호 :"+pass+"");
		}
		else if(!id.equals(MemberId)){
			//응답
			out.println("아이디가 틀립니다.");
		}
		else if(!pass.equals(MemberPass)){
			//응답
			out.println("");
			out.println("비밀번호가 틀립니다.");
		}
		out.println("<br><a href='form/login_form.html'>로그인 페이지 이동</a>");
		out.println("");
	}
}
