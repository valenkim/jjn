package test;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;


public class pro extends HttpServlet{
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
  request.setCharacterEncoding("UTF-8"); //�ѱ�ó�� : request�� �Ѿ�� ���ڵ��� Ÿ���� UTF-8�� ���ڵ������(�̷��� ����� �ѱ��� ������ �ʴ´�.).
  String  x = request.getParameter("x");
  String y = request.getParameter("y");

  response.setContentType("text/html;charset=UTF-8");
  PrintWriter out = response.getWriter();
  out.println("<html><head><title>��ǥ</title></head><body>");
  out.println(" x��ǥ : "+ x+"<br>");
  out.println(" y��ǥ : "+ y+"<br>");
 
  
  out.println("</body></html>");



 }
}
