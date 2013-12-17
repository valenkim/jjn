package manager;

import entity.CompanyInfo;
import entity.TravelInfo;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mapping.GsonView;
import mappingInfo.Item;


public class SleepManager extends HttpServlet {
	private static final long serialVersionUID = 1L;
       


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");	
		response.setCharacterEncoding("utf-8");	
		
		GsonView gv = new GsonView();
		
		String add = request.getParameter("add");
		Item i;
		
		i = gv.changeAddress(add);

		ArrayList<CompanyInfo> ci = null ;
		CompanyInfo c = new CompanyInfo();

		int j =0;
		int ctype = 0; //���ھ�ü
		
		try {
			ci = c.selectCompany(ctype);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("��ǥ��ȯ ����");
		
		for(int index=0; index<ci.size(); index++){
			
			c =  gv.distance(ci.get(index).id, ci.get(index).address, ci.get(index).title, ci.get(index).type,  i.lat, i.lng, ci.get(index).lat, ci.get(index).lng);
			
			if(c != null){
				request.setAttribute("title"+j,c.title);
				request.setAttribute("address"+j,c.address);
				request.setAttribute("userId"+j, c.id);
				request.setAttribute("type"+j, c.type);
				System.out.println(c.title);
				
				
				j++;
			}
			
		}
		request.setAttribute("count", j);
		
		ServletContext context = request.getSession().getServletContext();
		RequestDispatcher rd  = context.getRequestDispatcher("/SelectSleepView.jsp");
		rd.forward(request, response);		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");	
		response.setCharacterEncoding("utf-8");	
		
		CompanyInfo c = new CompanyInfo();
		TravelInfo t = new TravelInfo();
		
		String id = request.getParameter("userId");
		
		int ctype = 0; //���ھ�ü
		try {
			c = c.findCompany(id);
			c.sleepCount = 1;
			t.saveMealSleep(c, ctype, 0); //timer = 0
			System.out.println("���Ҹ� �����߽��ϴ�.");
			

			
		} catch (SQLException e) {
			e.printStackTrace();
			
		}finally{
			
			
			
			ServletContext context = request.getSession().getServletContext();
			RequestDispatcher rd  = context.getRequestDispatcher("/CloseManager");
			rd.forward(request, response);		
		
		}
	}

}
