<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page  import = "java.net.*"

%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>시간 선택하기</title>
</head>

<body>
<h1>시간을 선택하세요</h1>
<form action="TimeManager" method="get">

<%
	String count =request.getAttribute("count").toString();
	String id =request.getAttribute("id").toString();
	
	int n = Integer.parseInt(count);
	int stime = Integer.parseInt(request.getAttribute("startTime").toString());
	int ttime = Integer.parseInt(request.getAttribute("timer").toString());
	int t= stime+ttime;
	%>
</form>
<jsp:useBean id="datebean" class="entity.TravelInfo" scope="session"/>
<form method="post" action="TimeManager">
	<select name="time">
<%
	request.setAttribute("id", id);

	for(int i =(t-8); i<n; i++){ %>
		<option  value=<%= request.getAttribute("time"+i) %>><%= request.getAttribute("time"+i) %>:00</option>
<%} %><input type="hidden"  name="id" value=<%=id%>>
		</select><input type="submit" value="완료"><p>

</form>
</body>
</html>