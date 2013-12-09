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
   request.setCharacterEncoding("utf-8");
%>
<form action="ViewOtherTableManager" method="get"><input type="submit" value="여행루트보기"/>
<table border="1" cellspacing="0">
<tr>
<td>아이디</td>
<td>별점</td>
</tr>
<tr>
	<td><%=request.getAttribute("userid") %></td>
	<td><%=request.getAttribute("starscore") %></td>
	</tr>
</table>
</form>

</body>
</html>