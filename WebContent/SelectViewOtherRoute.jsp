<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>확인할 루트를 선택하세요</h1>
<form action="ViewOtherRouteManager" method="get">
루트선택:
<%
	String count =request.getAttribute("count").toString();
	int n = Integer.parseInt(count);
	
%>
</form>
<form method = "post" action="ViewOtherRouteManager">
	<select name="routename" >
	<% for(int i =0; i<n; i++){ %>
			<option  value=<%= request.getAttribute("routename"+i) %>><%= request.getAttribute("routename"+i) %>, 별점:<%= request.getAttribute("score"+i) %></option>
	<%} %>	
		</select>	
	<input type="submit" value="선택"><p>
</form>
</body>
</html>