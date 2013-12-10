package entity;

import db.DBconnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class CompanyInfo {
	
	public int id;
	public String address;
	public double lng;
	public double lat;
	
	Connection conn;
	PreparedStatement pstmt;
	
	public void selectCompany() throws SQLException{
		DBconnection con = new DBconnection();
		
		conn = con.setDB(conn);
		
		String sql = "SELECT name, address, lat, lng FROM CompanyInfo";
		
		
		
		
		
		
		con.closeDB(conn, pstmt);
		
		
	}

}
