package servlet.form;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;


public class CompanyRegister extends HttpServlet{
 public void doGet(HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException{
  doPost(request,response);
 }
 Connection conn;
 Statement stmt=null;
	
	public void init()
	{
		try{
			Class.forName("com.mysql.jdbc.Driver");
		
			String url = "jdbc:mysql://ecdysis.krois.se:43306/kkwak";
			String id = "kkwak";
			String pwd = "software";
			
			conn = DriverManager.getConnection(url,id,pwd);
			stmt=conn.createStatement();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
 
 public void doPost(HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException{
  request.setCharacterEncoding("UTF-8"); //한글처리 : request로 넘어온 문자들의 타입을 UTF-8로 인코딩해줘라(이렇게 해줘야 한글이 깨지지 않는다.).
  String type = request.getParameter("type");
  String loca1 = request.getParameter("city");
  String loca2 = request.getParameter("address");
  String event = request.getParameter("event");


  response.setContentType("text/html;charset=UTF-8");
  PrintWriter out = response.getWriter();
  out.println("<html><head><title>등록하기</title></head><body>");
  out.println(" 유형 : "+ type+"<br>");
  out.println(" 주소 : "+ loca1+loca2+"<br>");
  out.println(" 특이사항 : "+ event+"<br>");
  
  out.println("</body></html>");



 }
}
