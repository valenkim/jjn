package entity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import db.DBconnection;

public class Score {
	public String userid;
	public String starscore;

	Connection conn = null;
	PreparedStatement pstmt = null;
	DBconnection con = new DBconnection();
	ResultSet rs = null;
	
public ArrayList<Route> selectallid(){
		try{
			conn = con.setDB(conn);
		
			String sql="SELECT userid From routeall";
			pstmt  = conn.prepareStatement(sql);
			rs = pstmt.executeQuery(sql);

			ArrayList <Route> m = new ArrayList<Route>();
			
		   while(rs.next()){
			   Route mm = new Route();
			   mm.userid = rs.getString("userid");
			   m.add(mm);
		   }		
		 	con.closeDB(conn, pstmt);
		 	
			return m;
	    	
		
		 }catch(Exception e){
			  e.printStackTrace();
			 
		 }
		return null;

	}

	public ArrayList<Route> selectallstarscore(){
		try{
			conn = con.setDB(conn);
		
			String sql="SELECT * From routeall";
			pstmt  = conn.prepareStatement(sql);
			rs = pstmt.executeQuery(sql);

			ArrayList <Route> m = new ArrayList<Route>();
			
		   while(rs.next()){
			   Route mm = new Route();
			   mm.starscore = rs.getString("starscore");
			   m.add(mm);
		   }		
		 	con.closeDB(conn, pstmt);
		 	
			return m;
	    	
		
		 }catch(Exception e){
			  e.printStackTrace();
			 
		 }
		return null;

	}
	
public ArrayList<Route> selectuserid(String userid){
		
		try{
			conn = con.setDB(conn);
		
			String sql="SELECT userid From routeall where userid = '"+userid+"'";
			pstmt  = conn.prepareStatement(sql);
			rs = pstmt.executeQuery(sql);
	
			ArrayList <Route> m = new ArrayList<Route>();
			
		   while(rs.next()){
			   Route mm = new Route();
			   mm.userid = rs.getString("userid");
			   m.add(mm);
		   }		
		 	con.closeDB(conn, pstmt);
		 	
			return m;
	    	
		
		 }catch(Exception e){
			  e.printStackTrace();
			 
		 }
		return null;

	}

public ArrayList<Route> selectstarscore(String userid){

		try{
			conn = con.setDB(conn);
			
			String sql = "SELECT starscore FROM routeall where userid = '"+userid+"'";
			pstmt  = conn.prepareStatement(sql);
			rs = pstmt.executeQuery(sql);
			
			ArrayList<Route> m = new ArrayList <Route>();
			
		   while(rs.next()){
			   Route mm = new Route();
			   mm.starscore = rs.getString("starscore");
			   m.add(mm);
		   }		
		   
		   rs.close();
		   con.closeDB(conn, pstmt);
		 	
			return m;
		
		 }catch(Exception e){
			  e.printStackTrace();
			  
		 }
		return null;

	}


public boolean saveScore(String userid, String starscore){
	try{
		conn = con.setDB(conn);
	 	String udsql="INSERT INTO routeall (userid, starscore) VALUE ('"+userid+"', '"+starscore+"')";
		
		System.out.println("new");
		pstmt=conn.prepareStatement(udsql);
		pstmt.executeUpdate();		
		
		con.closeDB(conn, pstmt);

	}catch(Exception e){
		  e.printStackTrace();
	}
	return false;		
	
   } 

public boolean updateScore(String userid, String starscore){
	try{
		conn = con.setDB(conn);
		
		String sql="UPDATE routeall SET starscore=? WHERE userid = ?";
		
		pstmt=conn.prepareStatement(sql);
		
		pstmt.setString(1, starscore);
		pstmt.setString(2, userid);
		pstmt.executeUpdate();
	
		con.closeDB(conn, pstmt);

		return true;
		
	}catch(Exception e){
		  e.printStackTrace();
	}		
	return false;		
	
}

public boolean deleteScore(String userid){
	try{
		conn = con.setDB(conn);
		
		String sql="delete from routeall where userid=?";
		
		pstmt=conn.prepareStatement(sql);
		
		pstmt.setString(1, userid);
		pstmt.executeUpdate();
	
		con.closeDB(conn, pstmt);

		return true;
		
	}catch(Exception e){
		  e.printStackTrace();
	}		
	return false;		
	
}

}
