<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>시간표</title>
</head>
<%
	String count =request.getAttribute("count").toString();
	int n = Integer.parseInt(count);
	int i = 0;
	int startTime;
	int timer;
	
	boolean first = true;
%>	
<body>
<h1>테이블 보기</h1>


<%
for(i=0; i<n; i++){

	timer = Integer.parseInt(request.getAttribute("timer"+i).toString());
	startTime = Integer.parseInt(request.getAttribute("startTime"+i).toString()); 
	
	if(((Integer) request.getAttribute("dateCount"+i)).intValue() ==1){
		if (!first) { %> </table> <% }
		first = false;
	%>
		<table border="2" cellspacing="1" style="border-collapse:collapse" width="200" cellpadding="5">
		<%=request.getAttribute("startDate"+i) %>
		<tr>
		<td align=center>시간</td>
		<td align=center>일과</td>
		</tr>
		<%
	}
	if(((Integer) request.getAttribute("trainCount"+i)).intValue() ==1){
		while(timer != 0){%><tr>
			<td align=center><%=startTime%>:00</td>	
			<td bgcolor="#58ACFA" align=center><p>이동하기<p>
					출발지 : <%=request.getAttribute("stat"+i) %><p> 목적지 : <%=request.getAttribute("dest"+i) %><p>
					기차종류 :  <%=request.getAttribute("train"+i) %></p></td>
			</tr>
		<% timer = timer - 1; 
				startTime = startTime + 1;
		}
	}else if(((Integer) request.getAttribute("mealCount"+i)).intValue() ==1){ 
		while(timer != 0){%><tr>
		<td align=center><%=startTime%>:00</td>	
		<td bgcolor="#FFDDDD" align=center><p>식사하기<p>
				음식점이름 : <%=request.getAttribute("companyName"+i) %><p> 타입 : <%=request.getAttribute("type"+i) %></p></td>
		</tr>
		<% timer = timer - 1; 
				startTime = startTime + 1;
		}
	 }else if(((Integer) request.getAttribute("sleepCount"+i)).intValue() ==1){ %>
		<tr>
			<td align=center><%=startTime%>:00</td>	
			<td bgcolor="FFEEAA" align=center><p>숙박하기<p>
					음식점이름 : <%=request.getAttribute("companyName"+i) %><p> 타입 : <%=request.getAttribute("type"+i) %></p></td>
			</tr><%
		}else if(((Integer) request.getAttribute("freeCount"+i)).intValue() ==1){
	 %><tr>
			<td align=center>8:00~24:00</td>	
			<td align=center bgcolor="#FFBF00"><p>자유여행</td>
			</tr><%
		}
	}

if (!first) { %></table><% } %>


</body>
</html>