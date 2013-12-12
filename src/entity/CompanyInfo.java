package entity;

import db.DBconnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class CompanyInfo {
	
	public int id;
	public String address;
	public double lng;
	public double lat;
	public String title;
	
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	
	public ArrayList<CompanyInfo> selectCompany() throws SQLException{
		DBconnection con = new DBconnection();
		
		try{
			conn = con.setDB(conn);
			
			String sql = "SELECT userId, name, address, lat, lng FROM CompanyInfo";
			
			
			pstmt  = conn.prepareStatement(sql);
			rs = pstmt.executeQuery(sql);
	
			ArrayList <CompanyInfo> c = new ArrayList<CompanyInfo>();
			
		   while(rs.next()){
			   CompanyInfo ci = new CompanyInfo();
			   ci.id = rs.getInt("userId");
			   ci.address = rs.getString("address");
			   ci.lat = rs.getDouble("lat");
			   ci.lng = rs.getDouble("lng");
			   ci.title = rs.getString("name");
			   
			   c.add(ci);
		   }		
		 	
		   con.closeDB(conn, pstmt);
		 	
			return c;
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
		
		
	}
	public CompanyInfo findMealCompany(int id) throws SQLException{
		DBconnection con = new DBconnection();
		
		try{
			conn = con.setDB(conn);
			
			String sql = "SELECT userId, name, address, lat, lng FROM CompanyInfo WHERE userId = "+ id;
			
			
			pstmt  = conn.prepareStatement(sql);
			rs = pstmt.executeQuery(sql);
	
			CompanyInfo ci = new CompanyInfo();
				
		   while(rs.next()){
			   ci.id = rs.getInt("userId");
			   ci.address = rs.getString("address");
			   ci.lat = rs.getDouble("lat");
			   ci.lng = rs.getDouble("lng");
			   ci.title = rs.getString("name");
		   }		
		 	
		   con.closeDB(conn, pstmt);
		 	
			return ci;
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
		
		
	}

}
