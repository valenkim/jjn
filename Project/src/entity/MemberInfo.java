package entity;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import db.DBconnection;

public class MemberInfo {
	public String id;
	public String pass;
	public String name;
	public String email;
	public String tel;
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	DBconnection con = new DBconnection();
	ResultSet rs= null;
	
	

	public boolean  createMember(String id, String pass, String name, String email, String tel){
		try{
			conn = con.setDB(conn);
			
			String udsql="INSERT INTO member(id,pass,name, email,tel) VALUES( '"+id+"','"+pass+"','"+name+"','"+email+"','"+tel+"')";
			
			pstmt=conn.prepareStatement(udsql);
			pstmt.executeUpdate();
		
			con.closeDB(conn, pstmt);

			return true;
			
		}catch(Exception e){
			  e.printStackTrace();
		}		
		return false;

	}
	public boolean deleteMember(String id, String pass, String name, String email, String tel){
		try{
			conn = con.setDB(conn);
			
			String udsql = "DELETE FROM member WHERE( id='"+id+"')";
			
			pstmt=conn.prepareStatement(udsql);
			pstmt.executeUpdate(udsql);
			
			con.closeDB(conn, pstmt);	
			
			return true;
			
		}catch(Exception e){
			  e.printStackTrace();
		}		
		return false;
		
	}
	
	
}
