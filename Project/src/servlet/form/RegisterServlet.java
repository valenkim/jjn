package servlet.form;
import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

import java.sql.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.DBconnection;

public class RegisterServlet extends HttpServlet{
 public void doGet(HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException{
  doPost(request,response);
 }
 	Connection conn = null;
	PreparedStatement pstmt = null;
	DBconnection con = new DBconnection();
	ResultSet rs= null;
 
	public void init()
	{
		try{
			Class.forName("com.mysql.jdbc.Driver");
		
			String url = "jdbc:mysql://ecdysis.krois.se:43306/kkwak";
			String id = "kkwak";
			String pwd = "software";
			
			conn = DriverManager.getConnection(url,id,pwd);
			Statement stmt=conn.createStatement();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
 
 public void doPost(HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException{
  request.setCharacterEncoding("UTF-8"); //�ѱ�ó�� : request�� �Ѿ�� ���ڵ��� Ÿ���� UTF-8�� ���ڵ������(�̷��� ����� �ѱ��� ������ �ʴ´�.).
  String id = request.getParameter("id");
  String pass = request.getParameter("pass");
  String name = request.getParameter("name");
  String email = request.getParameter("email");
  String tel = request.getParameter("tel");


  System.out.println("id : "+ id);
  //����
  response.setContentType("text/html;charset=UTF-8");
  PrintWriter out = response.getWriter();
  out.println("<html><head><title>����ϱ�</title></head><body>");
  out.println(" id : "+ id+"<br>");
  out.println(" pass : "+ pass+"<br>");
  out.println(" name : "+ name+"<br>");
  out.println(" email : "+ email+"<br>");
  out.println(" tel : "+ tel+"<br>");

  out.println("<br><a href='register_form.jsp'>ȸ������ϱ�</a>");
  out.println("</body></html>");




 }
}
