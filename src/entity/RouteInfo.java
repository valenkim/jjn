package entity;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import db.DBconnection;

public class RouteInfo {
	public String userid;
	public String routename;
	public int id;
	public int startTime;
	public int timecount;
	public String stat;
	public String train;
	public int traincount;
	public int timer;
	public int ctype;
	public String dest;
	public Date startDate;
	public Date endDate;
	public int freeCount;
	public int dateCount;
	public String companyName;
	public int score;
	public int mealCount;
	public int sleepCount;
	public String type;
    
	Connection conn = null;
	PreparedStatement pstmt = null;
	DBconnection con = new DBconnection();
	ResultSet rs = null;
	
	public ArrayList<RouteInfo> selectall(){
		try{
			conn = con.setDB(conn);
		
			String sql="SELECT userid, routename, score From RouteInfo";
			pstmt  = conn.prepareStatement(sql);
			rs = pstmt.executeQuery(sql);

			ArrayList <RouteInfo> m = new ArrayList<RouteInfo>();
			
		   while(rs.next()){
			   RouteInfo mm = new RouteInfo();
			   mm.userid = rs.getString("userid");
			   mm.routename = rs.getString("routename");
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

	
	
	public boolean saveRoute(String userid, String routename, int score){
		try{
			conn = con.setDB(conn);
		 	String udsql="INSERT INTO RouteInfo (userid, routename, score) VALUE ('"+userid+"', '"+routename+"', '"+score+"')";
			
			System.out.println("new");
			pstmt=conn.prepareStatement(udsql);
			pstmt.executeUpdate();		
			
			con.closeDB(conn, pstmt);

		}catch(Exception e){
			  e.printStackTrace();
		}
		return false;		
		
	   } 

	public boolean updateRoute(String userid, String starscore){
		try{
			conn = con.setDB(conn);
			
			String sql="UPDATE RouteInfo SET routename=? WHERE userid = ?";
			
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

	public boolean deleteRoute(String routename){
		try{
			conn = con.setDB(conn);
			
			String sql="delete from RouteStore where routename='"+routename+"'";
						
			pstmt=conn.prepareStatement(sql);
			
			pstmt.executeUpdate(sql);
			
			String sql2="delete from RouteInfo where routename='"+routename+"'";
			pstmt=conn.prepareStatement(sql2);
			pstmt.executeUpdate(sql2);
			
			con.closeDB(conn, pstmt);

			return true;
			
		}catch(Exception e){
			  e.printStackTrace();
		}		
		return false;		
		
	}
	
	public ArrayList<RouteInfo> CallRouting(String routename, String tableName){
		try{
			conn = con.setDB(conn);
		    String sql;
			if(routename.equals(""))
				sql="SELECT * From "+tableName;
			else
				sql="SELECT * From "+tableName+" where routename='"+routename+"'";
			
			pstmt  = conn.prepareStatement(sql);

			rs = pstmt.executeQuery(sql);

			ArrayList <RouteInfo> m = new ArrayList<RouteInfo>();
			
		   while(rs.next()){
			   RouteInfo mm = new RouteInfo();
			   //mm.userid = rs.getString("userid");
			   //mm.routename = rs.getString("routename");
			   mm.id = rs.getInt("id");
			   mm.startTime = rs.getInt("startTime");
			   mm.timecount = rs.getInt("timeCount");
			   mm.stat = rs.getString("stat");
			   mm.train = rs.getString("train");
			   mm.traincount = rs.getInt("trainCount");
			   mm.timer = rs.getInt("timer");
			   mm.ctype = rs.getInt("ctype");
			   mm.dest = rs.getString("dest"); 
			   mm.startDate = rs.getDate("startDate");
			   mm.endDate = rs.getDate("endDate");
			   mm.freeCount = rs.getInt("freecount");
			   mm.dateCount = rs.getInt("dateCount");
			   mm.companyName = rs.getString("companyName");
			   mm.score = rs.getInt("starscore");
			   mm.mealCount = rs.getInt("mealCount");
			   mm.sleepCount = rs.getInt("sleepCount");
			   mm.type = rs.getString("type");
			   
			   m.add(mm);
		   }		
		 	con.closeDB(conn, pstmt);
		 	
			return m;
	    	
		
		 }catch(Exception e){
			  e.printStackTrace();
			 
		 }
		return null;

	}
	
	public boolean saveOwnRoute(String routeName, String userId, ArrayList<TravelInfo> t){
		try{
			conn = con.setDB(conn);
			
			for(int i=0;i<t.size();i++){
				
				String sql="INSERT INTO RouteStore (routename, id, startTime, timeCount, stat, train, trainCount, timer, ctype, dest, startDate,"
						+ "endDate, dateCount, freeCount, companyName, userid, starscore)  VALUE (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			
				pstmt=conn.prepareStatement(sql);
			
			
				pstmt.setString(1, routeName);
				pstmt.setInt(2,t.get(i).id);
				pstmt.setInt(3, t.get(i).startTime);
				pstmt.setInt(4,  t.get(i).timeCount);
				pstmt.setString(5, t.get(i).stat);
				pstmt.setString(6, t.get(i).train);
				pstmt.setInt(7, t.get(i).trainCount);
				pstmt.setInt(8, t.get(i).timer);
				pstmt.setInt(9, t.get(i).ctype);
				pstmt.setString(10, t.get(i).dest);
				pstmt.setDate(11, t.get(i).sDate);
				pstmt.setDate(12, t.get(i).eDate);
				pstmt.setInt(13, t.get(i).dateCount);
				pstmt.setInt(14, t.get(i).freeCount);
				pstmt.setString(15, t.get(i).companyName);
				pstmt.setString(16, userId);
				pstmt.setString(17, "5");
				
				pstmt.executeUpdate();		
			}
			
			String sql = "INSERT INTO RouteInfo (userid, routename) VALUE (?,?)";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			pstmt.setString(2, routeName);
			
			pstmt.executeUpdate();		
			

			con.closeDB(conn, pstmt);

			System.out.println("RouteInfo에도 저장");
		}catch(Exception e){
			  e.printStackTrace();
		}
		return false;		
		
	   } 


}
