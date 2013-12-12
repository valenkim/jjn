<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>음식점 선택하기</title>
</head>
<body>
<form action="MealManager" method="post">
<%
//double lng = Double.valueOf(request.getAttribute("lng").toString());
//double  lat =Double.valueOf( request.getAttribute("lat").toString());

String count =request.getAttribute("count").toString();
int n = Integer.parseInt(count);
%>
<select name="userId"  >
 <%for(int i =0; i<n; i++){ 
 	%><option value=<%=request.getAttribute("userId"+i)%>>
상호명 : <%=request.getAttribute("title"+i)%><p>
, 주소 : <%= request.getAttribute("address"+i)%></p>

</option>
<%} %>
	<input type="submit" value="선택">

</select>
</form>
</body>
</html>