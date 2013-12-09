package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class DBconnection {
		
	public Connection setDB(Connection conn){
		try{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection("jdbc:mysql://ecdysis.krois.se:43306/kkwak?useUnicode=true&characterEncoding=UTF-8" ,"kkwak" ,"software");
		}catch(Exception e){
			e.printStackTrace();
		}
		return conn;
	}
	
	public void closeDB(Connection conn, PreparedStatement pstmt) throws SQLException{
		conn.close();
		pstmt.close();
	}
	
}
