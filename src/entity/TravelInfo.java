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
	public String stat;
	public String dest;
	public int timeCount;
	public int mealCount;
	public int sleepCount;
	public int freeCount;
	public int trainCount;
	public int dateCount;
	public int ctype;
	public Date sDate;
	public Date eDate;
	public String companyName;
	public String userid;
	public String score;
	
	
	
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
			if(city.equals("statCity"))
				udsql="UPDATE Travel SET stat = '"+city_name+"', trainCount = 1 WHERE id = 1";
			else if(city.equals("destCity"))
				udsql="UPDATE Travel SET dest = '"+city_name+"', trainCount = 1 WHERE id =1";
			
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
			String sql="INSERT INTO Travel (id, startTime) VALUE (?,?)";
			
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setInt(1, id);
			pstmt.setInt(2, i);
			
			System.out.println("new!!");
			
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
			
			String upsql = "SELECT id,startTime FROM Travel ORDER BY  id DESC LIMIT 1";
			
			pstmt  = conn.prepareStatement(upsql);
			rs = pstmt.executeQuery(upsql);

			int id = 0; 
			int startTime = 8;
			
			while(rs.next()){
			   id = rs.getInt("id");
			   startTime = rs.getInt("startTime");
		   }
		   
			rs.close();
			
			String sql = "UPDATE Travel SET freeCount = 1 WHERE id = "+id;
			
			pstmt=conn.prepareStatement(sql);
			pstmt.executeUpdate();
			
			con.closeDB(conn, pstmt);
			
			TravelInfo t = new TravelInfo();
			t.updateStartTime(id, startTime, 2);
			
			
		}catch(Exception e){
			  e.printStackTrace();
		}
		return false;		
	}
	
	public boolean saveMealSleep(CompanyInfo c, int ctype, int timer){
		try{
			conn = con.setDB(conn);
			
			String upsql = "SELECT id, startTime FROM Travel ORDER BY  id DESC LIMIT 1";
			
			pstmt  = conn.prepareStatement(upsql);
			rs = pstmt.executeQuery(upsql);
	
			int id = 0; 
			int startTime = 0;
			
		   while(rs.next()){
			   id = rs.getInt("id");
			   startTime = rs.getInt("startTime");
		   }		
		   
			String sql="UPDATE Travel set companyName = ?, ctype = ?, timer = ?, type = ?, mealCount = ?, sleepCount = ? WHERE id = "+id;
			
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, c.title);
			pstmt.setInt(2, ctype);
			pstmt.setInt(3, timer);
			pstmt.setString(4, c.type);
			pstmt.setInt(5, c.mealCount);
			pstmt.setInt(6, c.sleepCount);
	
			
			pstmt.executeUpdate();
		
			con.closeDB(conn, pstmt);
			
			//startTime 갱신
			TravelInfo ti = new TravelInfo();			
			if(ctype == 1){ //만약 음식점이면
				ti.updateStartTime(id, startTime, 2);
			}

			return true;
			
		}catch(Exception e){
			  e.printStackTrace();
		}		
		
		return false;
	}
		
	
	public boolean saveRoute(){
		
		
		try{
			RouteInfo r = new RouteInfo();

			conn = con.setDB(conn);			
			String sql = "SELECT userid FROM Travel ORDER BY  id DESC LIMIT 1";
			pstmt  = conn.prepareStatement(sql);
			rs = pstmt.executeQuery(sql);
			
			while(rs.next())
				r.userid = rs.getString("userid");
		   
			rs.close();
			
			String upsql = "UPDATE Travel SET freeCount = 1 WHERE id = "+r.userid;
			
			pstmt=conn.prepareStatement(upsql);
			pstmt.executeUpdate();
			
			con.closeDB(conn, pstmt);
			
			
		}catch(Exception e){
			  e.printStackTrace();
		}
		return false;		
				
	}
	
public ArrayList<TravelInfo> loadTravelInfo(){
		
		try{
			ArrayList<TravelInfo> t = new ArrayList<TravelInfo>();
			conn = con.setDB(conn);		
			
			String sql = "SELECT id, startTime, timeCount, stat, train, trainCount, timer, ctype, dest, startDate,"
	 			+ " endDate, dateCount, freeCount, companyName, userid, starscore  FROM Travel";
			pstmt  = conn.prepareStatement(sql);
			rs = pstmt.executeQuery(sql);
			
			while(rs.next()){
				TravelInfo ti = new TravelInfo();
				ti.id = rs.getInt("id");
				ti.userid = rs.getString("userid");
				ti.startTime = rs.getInt("startTime");
				ti.timeCount = rs.getInt("timeCount");
				ti.stat = rs.getString("stat");
				ti.trainCount = rs.getInt("trainCount");
				ti.timer = rs.getInt("timer");
				ti.ctype = rs.getInt("ctype");
				ti.dest = rs.getString("dest");
				ti.sDate = rs.getDate("startDate");
				ti.eDate = rs.getDate("endDate");
				ti.dateCount = rs.getInt("dateCount");
				ti.freeCount = rs.getInt("freeCount");
				ti.companyName = rs.getString("companyName");
				ti.score = rs.getString("starscore");
				ti.train = rs.getString("train");
				
				t.add(ti);
			}
			System.out.println("다 받아옴");
			rs.close();
			con.closeDB(conn, pstmt);
			return t;
			
			
		}catch(Exception e){
			  e.printStackTrace();
		}
		return null;
				
	}

public void deleteTravel(){
	try{
		conn = con.setDB(conn);
		
		String userid ="no";
		String hate ="일식";
		
		String sql = "SELECT userid, hate FROM Travel WHERE id = 1";
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery(sql);
		
		while(rs.next()){
			userid = rs.getString("userid");
			hate = rs.getString("hate");
		}
		rs.close();
		
		sql = "Delete FROM Travel";
		pstmt  = conn.prepareStatement(sql);
		pstmt.executeUpdate(sql);
		
		sql = "INSERT INTO Travel (id, dateCount, userid, hate) VALUE (?,?,?,?)";
		pstmt=conn.prepareStatement(sql);
		pstmt.setString(1, "1");
		pstmt.setString(2, "1");
		pstmt.setString(3, userid);
		pstmt.setString(4,  hate);
		
		
		
		pstmt.executeUpdate();		
	
		con.closeDB(conn, pstmt);
		
	}catch(Exception e){
		e.printStackTrace();
	}
}
public TravelInfo selectStatCity() {
	try{
		TravelInfo t = new TravelInfo();
		
		conn = con.setDB(conn);
		
		String sql = "SELECT stat, dest From Travel WHERE id = 1";
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery(sql);
		
		while(rs.next()){
			t.stat= rs.getString("stat");
			t.dest = rs.getString("dest");
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
