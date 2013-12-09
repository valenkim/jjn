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




public class ListServlet extends HttpServlet{

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

		pw.println("<th>아이디</th><th>별점</th><th>삭제</th><th>수정</th>");

		////////////////// DB에서 전체 정보 얻어와 테이블로 출력하기 ///////////////

		

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

				//현재행의 각각의 컬럼값들 얻어오기

				String userid=rs.getString("userid");

				String starscore=rs.getString("starscore");


				//보여줄 테이블에 행(tr) 추가하고 컬럼값들을 td에보이기

				pw.println("<tr>");

				pw.println("<td>"+userid+"</td>");

				pw.println("<td>"+starscore+"</td>");

				pw.println("<td><a href='delete.do?userid="+userid+"'>삭제</a></td>");

				pw.println("<td><a href='update.do?userid="+userid+"'>수정</a></td>");

				

				//파라미터를 보내서 삭제도 가능하다.

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
		pw.println("<a href='AdminUI.jsp'>돌아가기</a>");
		pw.println("<br>");
		
		pw.println("</tr>");		

		pw.println("</table>");		
		
		pw.println("<br>");
		pw.println("<a href='insertrouteall.html'>여행루트 추가</a>");
		pw.println("<br>");
		
		pw.println("</body>");
         
		pw.println("</html>");

	

	}

}
