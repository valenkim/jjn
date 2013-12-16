package entity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import db.DBconnection;

public class Score {
	public String userid;
	public String routename;
	public int score;

	Connection conn = null;
	PreparedStatement pstmt = null;
	DBconnection con = new DBconnection();
	ResultSet rs = null;
	
public ArrayList<Score> selectall(){
		try{
			conn = con.setDB(conn);
		
			String sql="SELECT userid, routename, score From RouteInfo";
			pstmt  = conn.prepareStatement(sql);
			rs = pstmt.executeQuery(sql);

			ArrayList <Score> m = new ArrayList<Score>();
			
		   while(rs.next()){
			   Score mm = new Score();
			   mm.userid = rs.getString("userid");
			   mm.routename = rs.getString("routename");
			   mm.score = rs.getInt("score");
			   m.add(mm);
		   }		
		 	con.closeDB(conn, pstmt);
		 	
			return m;
	    	
		
		 }catch(Exception e){
			  e.printStackTrace();
			 
		 }
		return null;

	}

public ArrayList<RouteInfo> selectuserid(String userid){
		
		try{
			conn = con.setDB(conn);
		
			String sql="SELECT userid From routeall where userid = '"+userid+"'";
			pstmt  = conn.prepareStatement(sql);
			rs = pstmt.executeQuery(sql);
	
			ArrayList <RouteInfo> m = new ArrayList<RouteInfo>();
			
		   while(rs.next()){
			   RouteInfo mm = new RouteInfo();
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

public ArrayList<Score> selectscore(String routename){

		try{
			conn = con.setDB(conn);
			
			String sql = "SELECT score FROM RouteInfo where routename = '"+routename+"'";
			pstmt  = conn.prepareStatement(sql);
			rs = pstmt.executeQuery(sql);
			
			ArrayList<Score> m = new ArrayList <Score>();
			
		   while(rs.next()){
			   Score mm = new Score();
			   mm.score = rs.getInt("score");
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


public boolean saveScore(String routename, int score){
	try{
		conn = con.setDB(conn);
	 	String udsql="INSERT INTO RouteInfo (routename, score) VALUE ('"+userid+"', '"+score+"')";
		
		System.out.println("new");
		pstmt=conn.prepareStatement(udsql);
		pstmt.executeUpdate();		
		
		con.closeDB(conn, pstmt);

	}catch(Exception e){
		  e.printStackTrace();
	}
	return false;		
	
   } 

public boolean updateScore(String routename, int score){
	try{
		conn = con.setDB(conn);
		
		String sql="UPDATE RouteInfo SET score=? WHERE routename = ?";
		
		pstmt=conn.prepareStatement(sql);
		
		pstmt.setInt(1, score);
		pstmt.setString(2, routename);
		pstmt.executeUpdate();
	
		con.closeDB(conn, pstmt);

		return true;
		
	}catch(Exception e){
		  e.printStackTrace();
	}		
	return false;		
	
}

public boolean deleteScore(String routename){
	try{
		conn = con.setDB(conn);
		
		String sql="delete from RouteInfo where routename=?";
		
		pstmt=conn.prepareStatement(sql);
		
		pstmt.setString(1, routename);
		pstmt.executeUpdate();
	
		con.closeDB(conn, pstmt);

		return true;
		
	}catch(Exception e){
		  e.printStackTrace();
	}		
	return false;		
	
}

}
