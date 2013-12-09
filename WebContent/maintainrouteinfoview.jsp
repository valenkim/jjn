<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

<title>Insert title here</title>

</head>

<body>
<%
   request.setCharacterEncoding("utf-8");
%>
<form action="MaintainRoutemanager" method="get"><input type="submit" value="여행루트보기"/>
<table border="1" cellspacing="0">
<tr>
<td>아이디</td>
<td>일과</td>
</tr>
<tr>
	<td><%=request.getAttribute("userid") %></td>
	<td><%=request.getAttribute("starscore") %></td>
	</tr>
</table>
</form>
<a href="maintaininsert.jsp">여행루트추가</a><br/>

</body>

</html>


