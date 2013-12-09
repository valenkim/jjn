<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>도시 선택</title>
</head>
<body>
<h1>목적지를 선택하세요</h1>
<form action="CityManager" method="post">
도시선택:
<%
	String count =request.getAttribute("count").toString();
	String statCity = request.getAttribute("statCity").toString();
	int n = Integer.parseInt(count);
	
%>
</form>

<jsp:useBean id="datebean" class="entity.TravelInfo" scope="session"/>
<form method = "get" action="DestCityManager">
	<select name="destCity"  >
	<% for(int i =0; i<n; i++){ %>
			<option  value=<%= request.getAttribute("city"+i) %>><%= request.getAttribute("city"+i) %></option>
	<%} %>	
		</select>	
		
		<input type="hidden" name ="statCity" value= <%=statCity %>>
	<input type="submit" value="완료"><p>
</form>
<p>


<%--기차종류: 
<select name="sel2" >
 <option value="1" ><%= request.getAttribute("train0") %></option>
 <option value="2" ><%= request.getAttribute("train1") %></option>
 <option value="3" ><%= request.getAttribute("train2") %></option>
</select>
 --%>
 
<br><br>
<br><br>


</body>
</html>