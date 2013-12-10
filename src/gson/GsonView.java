package gson;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import Info.*;
import gson.GsonUtil;

public class GsonView {
	
	public Item changeAddress(String add){
		try{
			String url = "http://apis.daum.net/local/geo/addr2coord";
			String apiKey = "70406acff0e6212666f566f68392c9e0fd72ffa0";
			String address = URLEncoder.encode(add, "utf-8");
	
			String json = GsonUtil.readUrl(url+"?apikey="+apiKey+"&q="+address+"&output=json");
			
			Gson gson = new Gson();
			
			Page page = gson.fromJson(json, Page.class);			
			Item k = null;
			int index =0;
		    for (Item i : page.channel.item){
		    	
		        System.out.println(i.lat);
		    	System.out.println(i.lng);
		    	System.out.println(i.title);
		    	
		    	k = page.channel.item.get(index);
		    }

		    return k;
		    
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}

	public void distance(double lat1, double 	lng1,  double lat2, double  lng2){
		
		final double R = 6371;
		final double TO_RADIAN = Math.PI/180.0;
		double dLat = (lat2-lat1)*TO_RADIAN;
		double dLng = (lng2-lng1)*TO_RADIAN;
		
		double a = Math.sin(dLat/2)*Math.sin(dLat/2)+
				Math.sin(dLng/2)*Math.sin(dLng/2)*Math.cos(lat2)*Math.cos(lat2);
		double c = 2*Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
		double d = R * c;
		
		if( d < 5){//�ݰ� 5km
			System.out.println(d);
		}		
		
	}
	
}
	
