<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>음식점 선택하기</title>
</head>
<body>
<form action="MealManager" method="get">
<%
double lng = Double.valueOf(request.getAttribute("lng").toString());
double  lat =Double.valueOf( request.getAttribute("lat").toString());
%>

좌표 <%=lng%>, <%=lat %>
</form>
</body>
</html>