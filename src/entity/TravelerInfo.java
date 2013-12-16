package entity;

import java.sql.Connection;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import db.DBconnection;


public class TravelerInfo {
        public String userid;
        public String userpwd;
        public String name;
        public String tel;
        public String add;
        public String email;
        public String hate;


        
         
        Connection conn = null;
        PreparedStatement pstmt = null;
        DBconnection con = new DBconnection();
        ResultSet rs ;
        
        public boolean  createTravelerInfo(String id, String pass,String name, String email, String address, String tel, String hate){
    		try{
    			conn = con.setDB(conn);
    			
    			String membersql="Insert into TravelerInfo (id,pass,name,email,address,tel, hate) values ('"+id+"','"+pass+"','"+name+"','"+email+"','"+address+"','"+tel+"','"+hate+"')";			
    			pstmt=conn.prepareStatement(membersql);
    			pstmt.executeUpdate();
    			
    			String membersql2="Update Travel set hate='"+hate+"' where id = 1";
    			pstmt=conn.prepareStatement(membersql2);
    			pstmt.executeUpdate();
    		
    			con.closeDB(conn, pstmt);

    			return true;
    			
    		}catch(Exception e){
    			  e.printStackTrace();
    		}		
    		return false;
        
        } 
   	 public ArrayList<TravelerInfo> selectTall() throws SQLException{
  		
  		DBconnection con = new DBconnection();
  		
  		try{
  			conn = con.setDB(conn);
  			
  			String sql = "SELECT * FROM TravelerInfo";
  			
  			pstmt  = conn.prepareStatement(sql);
  			rs = pstmt.executeQuery(sql);
  	
  			ArrayList <TravelerInfo> t = new ArrayList<TravelerInfo>();
  			
  		   while(rs.next()){
  			   TravelerInfo ti = new TravelerInfo();
  			   ti.userid = rs.getString("id");
  			   ti.userpwd = rs.getString("pass");
  			   ti.name = rs.getString("name");
  			   ti.tel = rs.getString("tel");
                 ti.add = rs.getString("address");
                 ti.email = rs.getString("email");
                 ti.hate =  rs.getString("hate");
             	t.add(ti);
  		   }		
  		 	
  		   con.closeDB(conn, pstmt);
  		 	
  			return t;
  			
  		}catch(Exception e){
  			e.printStackTrace();
  		}
  		return null;
  		
  		
  	}
        
        public boolean  deleteTravelerInfo(String id){
    		try{
    			conn = con.setDB(conn);
    			
    			String membersql="DELETE FROM TravelerInfo WHERE id='"+id+"'";    			
    			pstmt=conn.prepareStatement(membersql);
    			pstmt.executeUpdate();
    		
    			con.closeDB(conn, pstmt);

    			return true;
    			
    		}catch(Exception e){
    			  e.printStackTrace();
    		}		
    		return false;
        
        } 
        public boolean loginAdminInfo(String id, String pass){
        	try{
        		conn = con.setDB(conn);
        		String userid = "";
        		String userpwd=pass;
        		
        	
        		String sql="SELECT id From AdminInfo where id='"+id+"' and  pass='"+userpwd+"'";
        		pstmt  = conn.prepareStatement(sql);
        		rs = pstmt.executeQuery(sql);
        		
        		while(rs.next())
        			userid = rs.getString("id");
        		
        		rs.close();
        		con.closeDB(conn, pstmt);
        		
        		if(userid.equals(""))
        			return false;
        		else
        			return true;
        		
        		
        		
        		}catch(Exception e){
           			e.printStackTrace();	}
           			return false;
          				
				
        }       
        public boolean loginTravelerInfo(String id, String pass){
        	try{
        		conn = con.setDB(conn);
        		String userid = "";
        		String userpwd=pass;
        		
        	
        		String sql="SELECT id From TravelerInfo where id='"+id+"' and  pass='"+userpwd+"'";
        		pstmt  = conn.prepareStatement(sql);
        		rs = pstmt.executeQuery(sql);
        		
        		while(rs.next())
        			userid = rs.getString("id");
        		
        		rs.close();
        		con.closeDB(conn, pstmt);
        		
        		if(userid.equals(""))
        			return false;
        		else
        			return true;
        		
        		
        		
        		}catch(Exception e){
           			e.printStackTrace();	}
           			return false;
          				
				
        }
        
        public boolean UpdateTravelInfo(String id){
        	try{
        		conn = con.setDB(conn);
        		
        		String sql = "SELECT hate FROM TravelerInfo WHERE id ='"+id+"'";
        		String hate = "";
        		pstmt = conn.prepareStatement(sql);
      			rs = pstmt.executeQuery(sql);

        		while(rs.next())
        			hate = rs.getString("hate");
        		
        		rs.close();

        		String sql1="Update Travel set userid='"+id+"', hate='"+hate+"'  where id = 1";
        		
        		pstmt=conn.prepareStatement(sql1);
        		pstmt.executeUpdate(sql1);
        		
        		con.closeDB(conn, pstmt);
        		
        		return true;
        		
           	}catch(Exception e){
      		  e.printStackTrace();
        	}
        		return false;
        	
        }
     
        
}
        
        
        
        
        
        
        
        
    

