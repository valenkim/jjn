<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	String counti =request.getAttribute("counti").toString();
	int ni = Integer.parseInt(counti);
	
%>	
<table border="1" cellspacing="0">
<tr>
<td>아이디</td>
<td>주소</td>
<td>이름</td>
<td>타입</td>
<td>이벤트</td>
<td>패스</td>
<td>이메일</td>
<td>전화번호</td>
<td></td>

</tr>
    <% for(int i =0; i<ni; i++){ %>
	<tr>
	<td><%=request.getAttribute("id"+i) %></td>
	<td><%=request.getAttribute("address"+i) %></td>
	<td><%=request.getAttribute("title"+i) %></td>
	<td><%=request.getAttribute("type"+i) %></td>
	<td><%=request.getAttribute("event"+i) %></td>
	<td><%=request.getAttribute("pass"+i) %></td>
	<td><%=request.getAttribute("email"+i) %></td>
	<td><%=request.getAttribute("tel"+i) %></td>
	<td><a href='DeleteCompanyView.jsp?id=<%=request.getAttribute("id"+i)%>'>삭제</a></td>
	</tr>
	<%} %>	
	
</table>
</body>
</html>