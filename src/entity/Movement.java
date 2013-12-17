package entity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import db.DBconnection;

public class Movement{
	public String city;
	public int id;
	public String train;
	public int trainTime;
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	DBconnection con = new DBconnection();
	ResultSet rs = null;
	String str = "timetablestore";
	
public ArrayList<Movement> selectCity(String statCity){
		
		try{
			conn = con.setDB(conn);
		
			String sql="SELECT city From City where city <> '"+statCity+"'";
			pstmt  = conn.prepareStatement(sql);
			rs = pstmt.executeQuery(sql);
	
			ArrayList <Movement> m = new ArrayList<Movement>();
			
		   while(rs.next()){
			   Movement mm = new Movement();
			   mm.city = rs.getString("city");
			   m.add(mm);
		   }		
		 	con.closeDB(conn, pstmt);
		 	
			return m;
	    	
		
		 }catch(Exception e){
			  e.printStackTrace();
			 
		 }
		return null;

	}

public ArrayList<Movement> selectMovement(String statCity, String destCity){

		try{
			conn = con.setDB(conn);
			
			String sql = "SELECT startTime FROM Travel ORDER BY id DESC LIMIT 1";
			pstmt  = conn.prepareStatement(sql);
			rs = pstmt.executeQuery(sql);
			
			int startTime = 0;
			
			while(rs.next()){
				startTime = rs.getInt("startTime");
			}
			
			sql="SELECT train, trainTime, id FROM TrainTimeTable WHERE stat = '"+statCity+"' AND dest = '"+destCity+"' AND startTime >= "+startTime;
			
			pstmt  = conn.prepareStatement(sql);
			rs = pstmt.executeQuery(sql);
			
			ArrayList<Movement> m = new ArrayList <Movement>();
			
		   while(rs.next()){
			   Movement mm = new Movement();
			   mm.train = rs.getString("train");
			   mm.trainTime = rs.getInt("trainTime");
			   mm.id = rs.getInt("id");
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
}
