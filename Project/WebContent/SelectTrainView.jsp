<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>기차를 선택하세요</title>
</head>
<body>
<h1>기차를 선택하세요</h1>

<form action="TrainManager" method="get">
기차선택:
<%
	String count =request.getAttribute("count").toString();
	int n = Integer.parseInt(count);
%>
</form>

<jsp:useBean id="datebean" class="entity.TravelInfo" scope="session"/>
<form method = "post" action="TrainManager">
	<select name="id"  >
	<% for(int i =0; i<n; i++){ %>
			<option  value=<%= request.getAttribute("id"+i) %>><%= request.getAttribute("train"+i)%>
																									, 소요시간 :<%= request.getAttribute("trainTime"+i) %> 시간</option>
	<%} %>	
		</select>				
	<input type="submit" value="완료"><p>
</form>

</body>
</html>