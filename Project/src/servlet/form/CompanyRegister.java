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
  request.setCharacterEncoding("UTF-8"); //�ѱ�ó�� : request�� �Ѿ�� ���ڵ��� Ÿ���� UTF-8�� ���ڵ������(�̷��� ����� �ѱ��� ������ �ʴ´�.).
  String type = request.getParameter("type");
  String loca1 = request.getParameter("city");
  String loca2 = request.getParameter("address");
  String event = request.getParameter("event");


  response.setContentType("text/html;charset=UTF-8");
  PrintWriter out = response.getWriter();
  out.println("<html><head><title>����ϱ�</title></head><body>");
  out.println(" ���� : "+ type+"<br>");
  out.println(" �ּ� : "+ loca1+loca2+"<br>");
  out.println(" Ư�̻��� : "+ event+"<br>");
  
  out.println("</body></html>");



 }
}
