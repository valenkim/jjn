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
<<<<<<< HEAD
	
=======
	 public static Connection getConnection() throws SQLException{
		  Connection conn;
		  String url = "jdbc:mysql://ecdysis.krois.se:43306/kkwak?useUnicode=true&characterEncoding=UTF-8";
		  String id = "kkwak";
		  String password = "software";
		  conn = DriverManager.getConnection(url, id, password);

		  return conn;
		 }
		 public static void close(PreparedStatement ps, Connection conn){
		  if(ps != null){try{ps.close();}catch(SQLException e){e.printStackTrace();}}
		  if(conn != null){try{conn.close();}catch(SQLException e){e.printStackTrace();}}
		 }
		 public static void close(ResultSet rs, PreparedStatement ps, Connection conn){
		  if(rs != null){try{rs.close();}catch(SQLException e){e.printStackTrace();}}
		  close(ps, conn);
		 }
>>>>>>> refs/remotes/choose_remote_name/master
}
