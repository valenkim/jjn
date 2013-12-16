package entity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import mapping.GsonView;
import mappingInfo.Item;
import db.DBconnection;


public class CompanyInfo {
        public String id;
        public String pass;
        public String title;
        public String tel;
        public String address;
        public String email;
        public String type;
        public String event;
        public String ctype;
    	public double lng;
    	public double lat;
    	public int mealCount;
    	public int sleepCount;
         
        Connection conn = null;
        PreparedStatement pstmt = null;
        DBconnection con = new DBconnection();
        ResultSet rs = null;
        

        public boolean  createCompanyInfo(String userId, String pass,String name, String email, String address, String tel,String event,String ctype,String type){
    		try{
    			conn = con.setDB(conn);
    			
    			String membersql="INSERT INTO CompanyInfo (userId,pass,name,email,address,tel,event,ctype,type)values('"+userId+"','"+pass+"','"+name+"','"+email+"','"+address+"','"+tel+"','"+event+"','"+ctype+"','"+type+"')";    			
    			pstmt=conn.prepareStatement(membersql);
    			pstmt.executeUpdate();
    			
    			GsonView gv = new GsonView();
    			Item i;		
    			i = gv.changeAddress(address);
    			
    		   String membersql2 = "UPDATE CompanyInfo set lat = ?, lng = ? WHERE userId = '"+userId+"'";
    			pstmt=conn.prepareStatement(membersql2);
    			
    			pstmt.setDouble(1, i.lat);
    			pstmt.setDouble(2, i.lng);
    			
    			pstmt.executeUpdate();		   
    			
    			con.closeDB(conn, pstmt);
    			return true;
    			
    		}catch(Exception e){
    			  e.printStackTrace();
    		}		
    		return false;
        
        } 

	public ArrayList<CompanyInfo> selectCall() throws SQLException{
        		
        		DBconnection con = new DBconnection();
        		
        		try{
        			conn = con.setDB(conn);
        			
        			String sql = "SELECT userId, pass, name, email, address, tel, type, event FROM CompanyInfo";
        			
        			pstmt  = conn.prepareStatement(sql);
        			rs = pstmt.executeQuery(sql);
        	
        			ArrayList <CompanyInfo> c = new ArrayList<CompanyInfo>();
        			
        		   while(rs.next()){
        			   CompanyInfo ci = new CompanyInfo();
        			   ci.id = rs.getString("userId");
        			   ci.address = rs.getString("address");
//        			   ci.lat = rs.getDouble("lat");
//        			   ci.lng = rs.getDouble("lng");
        			   ci.title = rs.getString("name");
        			   ci.type = rs.getString("type");
                       ci.event = rs.getString("event");
                       ci.pass = rs.getString("pass");
                       ci.email =  rs.getString("email");
                       ci.tel = rs.getString("tel");
        			   c.add(ci);
        		   }		
        		 	
        		   con.closeDB(conn, pstmt);
        		 	
        			return c;
        			
        		}catch(Exception e){
        			e.printStackTrace();
        		}
        		return null;
        		
        		
        	}
        
        public boolean  deleteCompanyInfo(String id){
    		try{
    			conn = con.setDB(conn);
    			
    			String membersql="DELETE FROM CompanyInfo WHERE userId='"+id+"'";    			
    			pstmt=conn.prepareStatement(membersql);
    			pstmt.executeUpdate();
    		
    			con.closeDB(conn, pstmt);

    			return true;
    			
    		}catch(Exception e){
    			  e.printStackTrace();
    		}		
    		return false;
        
        }      
     
        public boolean loginCompanyInfo(String id, String pass){
        	try{
        		conn = con.setDB(conn);
        		String userid="";
        		String userpwd=pass;
        		
        	
        		String sql="SELECT id From CompanyInfo where id='"+id+"' and  pass='"+userpwd+"'";
        		pstmt  = conn.prepareStatement(sql);
        		rs = pstmt.executeQuery(sql);
        		
        		while(rs.next())
        			userid = rs.getString("id");
        		
        		rs.close();
        		con.closeDB(conn, pstmt);
        		
        		if(userid.equals(""))
        			return false;
        		else
        			return true;
        		
        	}catch(Exception e){
       			e.printStackTrace();	}
       			return false;
      				
        }
        	
        public ArrayList<CompanyInfo> selectCompany(int ctype) throws SQLException{
    		
    		DBconnection con = new DBconnection();
    		
    		try{
    			conn = con.setDB(conn);
    			
    			String selsql = "SELECT hate FROM Travel WHERE id = 1";
    			
    			pstmt  = conn.prepareStatement(selsql);
    			rs = pstmt.executeQuery(selsql);
    			
    			String hate = null;
    			  while(rs.next()){
    				  hate = rs.getString("hate");
    			  }
    			  
    			  rs.close();
    			
    			String sql = "SELECT userId, name, address, lat, lng, type FROM CompanyInfo WHERE ctype = "+ctype+" and type <> '"+hate+"'";
    			
    			pstmt  = conn.prepareStatement(sql);
    			rs = pstmt.executeQuery(sql);
    	
    			ArrayList <CompanyInfo> c = new ArrayList<CompanyInfo>();
    			
    		   while(rs.next()){
    			   CompanyInfo ci = new CompanyInfo();
    			   ci.id = rs.getString("userId");
    			   ci.address = rs.getString("address");
    			   ci.lat = rs.getDouble("lat");
    			   ci.lng = rs.getDouble("lng");
    			   ci.title = rs.getString("name");
    			   ci.type = rs.getString("type");
    			   
    			   c.add(ci);
    		   }		
    		 	
    		   con.closeDB(conn, pstmt);
    		 	
    			return c;
    			
    		}catch(Exception e){
    			e.printStackTrace();
    		}
    		return null;

    	}
        
    	public CompanyInfo findCompany(String id) throws SQLException{
    		DBconnection con = new DBconnection();
    		
    		try{
    			conn = con.setDB(conn);
    			
    			String sql = "SELECT userId, name, address, lat, lng, type FROM CompanyInfo WHERE userId = '"+id+"'";
    				
    			pstmt  = conn.prepareStatement(sql);
    			rs = pstmt.executeQuery(sql);
    	
    			CompanyInfo ci = new CompanyInfo();
    				
    		   while(rs.next()){
    			   ci.id = rs.getString("userId");
    			   ci.address = rs.getString("address");
    			   ci.lat = rs.getDouble("lat");
    			   ci.lng = rs.getDouble("lng");
    			   ci.title = rs.getString("name");
    			   ci.type =rs.getString("type");
 
    		   }		
    		 	
    		   con.closeDB(conn, pstmt);
    		 	
    			return ci;
    			
    		}catch(Exception e){
    			e.printStackTrace();
    		}
    		return null;
    		
    		
    	}


}
        

    			
        

        
        
        
        
        
        
        
        
    

