package member.dto;
import java.sql.*;
import java.util.*;

public class MemberDAO {

   private Connection conn = null;
   	public MemberDAO(Connection conn) {
	     this.conn = conn;
	   }
	 
	public int insertData(MemberDTO dto ) {
	     int result = 0;
	     PreparedStatement pstmt = null;
	     String sql;
	     try {
	       sql = "INSERT INTO Member (id, pass, name,email,tel)";
	       sql += " VALUES (?, ?, ?, ?, ?)";
	       pstmt = conn.prepareStatement(sql);
	       pstmt.setString(1, dto.getId());  //userId
	       pstmt.setString(2, dto.getPass());  //userPwd
	       pstmt.setString(3, dto.getName());  //userName
	       pstmt.setString(4, dto.getEmail());
	       pstmt.setString(5, dto.getTel());
	       
	       pstmt.close();
	     	} catch (Exception e) {
	     		System.out.println(e.toString());
	     	}
	   return result;
	  }
	   
	  
	
	   public int deleteData(String Id) {
	     int result = 0;
	     PreparedStatement pstmt = null;
	     String sql;
	     try {
	       sql = "DELETE FROM member WHERE Id=?";
	    pstmt = conn.prepareStatement(sql);
	       pstmt.setString(1, Id);  //userId
	       result = pstmt.executeUpdate();
	       pstmt.close();
	     } catch (Exception e) {
	     System.out.println(e.toString());
	     }
	     return result;
	   }
	   	
	}


