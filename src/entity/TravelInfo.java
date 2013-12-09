package entity;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;

import db.DBconnection;

public class TravelInfo {
	
	public int id;
	public int time;
	public String city;
	public String train;
	public int trainTime;
	public int timer;
	public int startTime;
	public int startDate;
	public int endDate;
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	DBconnection con = new DBconnection();
	ResultSet rs= null;
	
	
	

	public boolean  saveTime(int id, int time){
		try{
			conn = con.setDB(conn);
			
			String udsql="UPDATE Travel SET startTime = "+time+",timeCount = 1 WHERE id = "+id;
			
			pstmt=conn.prepareStatement(udsql);
			pstmt.executeUpdate();
		
			con.closeDB(conn, pstmt);

			return true;
			
		}catch(Exception e){
			  e.printStackTrace();
		}		
		return false;

	}
	public boolean saveCity(String city, String city_name){
		try{
			conn = con.setDB(conn);
			
			String udsql = "";
			if(city == "statCity")
				udsql="UPDATE Travel SET stat = '"+city_name+"', trainCount = 1";
			else if(city == "destCity")
				udsql="UPDATE Travel SET dest = '"+city_name+"', trainCount = 1";
			
			pstmt=conn.prepareStatement(udsql);
			pstmt.executeUpdate(udsql);
			
			con.closeDB(conn, pstmt);	
			
			return true;
			
		}catch(Exception e){
			  e.printStackTrace();
		}		
		return false;
		
	}
	
	public boolean saveTrain(int id){
		try{
			conn = con.setDB(conn);
			

			String udsql = "SELECT  train, trainTime, startTime FROM TrainTimeTable WHERE id = "+id;

			pstmt=conn.prepareStatement(udsql);
			rs = pstmt.executeQuery(udsql);

			TravelInfo ti = new TravelInfo();
			
	 	   while(rs.next()){	
	 		   ti.train = rs.getString("train");
	 		   ti.timer = rs.getInt("trainTime");
			   ti.startTime =  rs.getInt("startTime");
	 	   }

			udsql = "SELECT  id FROM Travel ORDER BY id DESC LIMIT 1";
			pstmt=conn.prepareStatement(udsql);
			rs = pstmt.executeQuery(udsql);
			
			while(rs.next()){
				ti.id = rs.getInt("id");
			}
			
			udsql="UPDATE Travel SET train = '"+ti.train+"', timer = "+ti.timer+",  startTime = "+ti.startTime+", trainCount = 1 WHERE id = "+ti.id;
			
			System.out.println("update");
			
			pstmt=conn.prepareStatement(udsql);
			pstmt.executeUpdate();
				
			ti.updateStartTime(ti.id, ti.startTime, ti.timer);
			
			rs.close();
			con.closeDB(conn, pstmt);
			
			
			return true;
			
		}catch(Exception e){
			  e.printStackTrace();
		}		
		return false;
		
		
	}
	public void updateStartTime(int id,  int startTime, int interval){
		try{
			conn = con.setDB(conn);
			
			int i=startTime+interval;
			System.out.println(i);
			
			id++;
			String udsql="INSERT INTO Travel (id, startTime) VALUE ('"+id+"', '"+i+"')";
			
			System.out.println("new");
			pstmt=conn.prepareStatement(udsql);
			pstmt.executeUpdate();		
			
			con.closeDB(conn, pstmt);

		}catch(Exception e){
			  e.printStackTrace();
		}		
		
	}

	public boolean saveDate(Date startDate, Date endDate){
		try{
			conn = con.setDB(conn);
			
			String sql="UPDATE Travel SET startDate = ?, endDate=? WHERE dateCount= 1";
			
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setDate(1, startDate);
			pstmt.setDate(2,  endDate);
			pstmt.executeUpdate();
		
			con.closeDB(conn, pstmt);

			return true;
			
		}catch(Exception e){
			  e.printStackTrace();
		}		
		return false;		
		
	}
	

	public boolean updateDate(Date startDate, Date endDate){
		try{
			conn = con.setDB(conn);
			
			String upsql = "SELECT id FROM Travel ORDER BY  id DESC LIMIT 1";
			
			pstmt  = conn.prepareStatement(upsql);
			rs = pstmt.executeQuery(upsql);
	
			int id = 0; 
			
		   while(rs.next()){
			   id = rs.getInt("id");
		   }		
		   id++;
			
			String sql="INSERT INTO Travel (startDate, endDate, id, dateCount) VALUE (?, ?, ?, ?)";
			
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setDate(1, startDate);
			pstmt.setDate(2, endDate);
			pstmt.setInt(3, id);
			pstmt.setInt(4, 1);
			pstmt.executeUpdate();
		
			con.closeDB(conn, pstmt);

			return true;
			
		}catch(Exception e){
			  e.printStackTrace();
		}		
		return false;

		
		
	}
	public boolean saveFreeTravel(){
		
		try{
			
			conn = con.setDB(conn);
			
			String upsql = "SELECT id FROM Travel ORDER BY  id DESC LIMIT 1";
			
			pstmt  = conn.prepareStatement(upsql);
			rs = pstmt.executeQuery(upsql);

			int id = 0; 
			while(rs.next()){
			   id = rs.getInt("id");
		   }
		   
			rs.close();
			
			String sql = "UPDATE Travel SET freeCount = 1 WHERE id = "+id;
			
			pstmt=conn.prepareStatement(sql);
			pstmt.executeUpdate();
			
			con.closeDB(conn, pstmt);
			return true;
			
		}catch(Exception e){
			  e.printStackTrace();
		}
		return false;		
	}
}
