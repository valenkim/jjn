<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>도시 선택</title>
</head>
<body>
<h1>출발 도시를 선택하세요</h1>
<form action="CityManager" method="get">
도시선택:
<%
	String count =request.getAttribute("count").toString();
	int n = Integer.parseInt(count);
	
%>
</form>

<jsp:useBean id="datebean" class="entity.TravelInfo" scope="session"/>
<form method = "post" action="StatCityManager">
	<select name="statCity"  >
	<% for(int i =0; i<n; i++){ %>
			<option  value=<%= request.getAttribute("city"+i) %>><%= request.getAttribute("city"+i) %></option>
	<%} %>	
		</select>	
	<input type="submit" value="완료"><p>
</form>
<p>

 
<br><br>
<br><br>


</body>
</html>