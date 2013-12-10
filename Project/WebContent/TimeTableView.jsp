<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>시간표</title>
</head>

<body>
<h1>테이블 보기</h1>
<form action="TimeTableManager" method="get">
<table border="1" cellspacing="0">
<tr>
<td>시간</td>
<td>일과</td>
</tr>
<tr>
<%
	int i = 0;
	String count =request.getAttribute("trainTime").toString();
	int n = Integer.parseInt(count);
	int time =  Integer.parseInt(request.getAttribute("startTime").toString());
	for(i=0; i<n; i++){ %>
	
	<td><%=time+i %>:00</td>
	<td>이동시간</td>
	</tr>
<% } %>
</table>
</form>

</body>
</html>