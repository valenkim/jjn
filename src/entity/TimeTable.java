package entity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import db.DBconnection;

public class TimeTable{
	public int id;
	public int time;
	public int startTime;
	public int timer;
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	DBconnection con = new DBconnection();
	ResultSet rs = null;
	
	public ArrayList<TimeTable> selectTime() {	
		
		try{
			
			ArrayList<TimeTable> t = new ArrayList<TimeTable>();
			
			conn = con.setDB(conn);

			
			String sql="SELECT time FROM timetablestore";
			pstmt  = conn.prepareStatement(sql);
			rs = pstmt.executeQuery(sql);
			
	    	while(rs.next()){	
			   TimeTable tt = new TimeTable();
			   tt.time= rs.getInt("time");
			   t.add(tt);
			   }		
	    	rs.close();
	    	con.closeDB(conn, pstmt);
		
	    	return t;
		
		 	}catch(Exception e){
		 		e.printStackTrace();
			 
		 }
		return null;
		
	}


	public TimeTable selectTravelTime() {	
		
		try{
			TimeTable t = new TimeTable();
			
			conn = con.setDB(conn);

			String sql="SELECT id, startTime, timer FROM Travel ORDER BY id DESC LIMIT 1";
			pstmt  = conn.prepareStatement(sql);
			rs = pstmt.executeQuery(sql);
	
	 	   while(rs.next()){	
			   t.startTime =  rs.getInt("startTime");
			   t.timer = rs.getInt("timer");
			   t.id = rs.getInt("id");	   
	 	   }	
	 	   rs.close();
	 	   con.closeDB(conn, pstmt);
		
	 	   return t;
		
		 }catch(Exception e){
			  e.printStackTrace();
			 
		 }
		return null;
	}
		
}
