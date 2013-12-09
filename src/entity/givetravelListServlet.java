package entity;




import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;





import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




public class givetravelListServlet extends HttpServlet{

	@Override

	protected void service(HttpServletRequest request, HttpServletResponse response)

			throws ServletException, IOException {

		response.setContentType("text/html; charset=utf-8");

		PrintWriter pw=response.getWriter();

		pw.println("<html>");

		pw.println("<head></head>");

		pw.println("<body>");

		pw.println("<table border='1' width='400'>");

		pw.println("<tr>");

		pw.println("<th>�꾩씠��/th><th>蹂꾩젏</th>");

		////////////////// DB�먯꽌 �꾩껜 �뺣낫 �살뼱���뚯씠釉붾줈 異쒕젰�섍린 ///////////////

		

		Connection con = null;

		PreparedStatement pstmt=null;

		ResultSet rs=null;

		try{

			Class.forName("com.mysql.jdbc.Driver");

			String url="jdbc:mysql://ecdysis.krois.se:43306/kkwak?useUnicode=true&characterEncoding=UTF-8";

			con=DriverManager.getConnection(url,"kkwak","software");

			pstmt=con.prepareStatement("select * from routeall");

			rs=pstmt.executeQuery();

			while(rs.next()){

				//�꾩옱�됱쓽 媛곴컖��而щ읆媛믩뱾 �살뼱�ㅺ린

				String userid=rs.getString("userid");

				String starscore=rs.getString("starscore");


				//蹂댁뿬以��뚯씠釉붿뿉 ��tr) 異붽��섍퀬 而щ읆媛믩뱾��td�먮낫�닿린

				pw.println("<tr>");

				pw.println("<td>"+userid+"</td>");

				pw.println("<td>"+starscore+"</td>");

				pw.println("</tr>");

			}

		}catch(ClassNotFoundException cf){

			System.out.println(cf.getMessage());

		}catch(SQLException se){

			System.out.println(se.getMessage());

		}finally{

			try{

				if(rs!=null) rs.close();

				if(pstmt!=null) pstmt.close();

				if(con!=null) con.close();				

			}catch(SQLException se2){

				System.out.println(se2.getMessage());

			}

		}

		

		//////////////////////////////////////////////////////////////////////		
		pw.println("<a href='UserUI.jsp'>�뚯븘媛�린</a>");
		pw.println("<br>");
		
		pw.println("</tr>");		

		pw.println("</table>");		

		pw.println("</body>");
         
		pw.println("</html>");

	

	}

}