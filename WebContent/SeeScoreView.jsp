<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>별점 보기</title>
</head>
<body>
<%
   request.setCharacterEncoding("utf-8");
%>
<%
	String count =request.getAttribute("count").toString();
	int n = Integer.parseInt(count);	
%>
<table border="1" cellspacing="0">
<tr>
<td>아이디</td>
<td>경로이름</td>
<td>별점</td>
</tr>
    <% for(int i=0; i<n; i++){ %>
	<tr>
	<td><%=request.getAttribute("userid"+i) %></td>
	<td><%=request.getAttribute("routename"+i) %></td>
	<td><%=request.getAttribute("score"+i) %></td>
	</tr>
	<%} %>	
</table>
</body>
</html>