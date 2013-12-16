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
<td>비밀번호</td>
<td>이름</td>
<td>전화번호</td>
<td>주소</td>
<td>이메일</td>
<td>비선호</td>
<td></td>

</tr>
    <% for(int i =0; i<ni; i++){ %>
	<tr>
	<td><%=request.getAttribute("userid"+i) %></td>
	<td><%=request.getAttribute("userpwd"+i) %></td>
	<td><%=request.getAttribute("name"+i) %></td>
	<td><%=request.getAttribute("tel"+i) %></td>
	<td><%=request.getAttribute("add"+i) %></td>
	<td><%=request.getAttribute("email"+i) %></td>
	<td><%=request.getAttribute("hate"+i) %></td>
	<td><a href='DeleteTravelerView.jsp?id=<%=request.getAttribute("userid"+i) %>'>삭제</a></td>
	</tr>
	<%} %>	
	
</table>
</body>
</html>