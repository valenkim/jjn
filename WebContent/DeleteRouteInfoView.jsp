<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%String routename = request.getParameter("routename");
		request.setAttribute("routename",routename);%>
<form action="DeleteRouteManager" method="post">
		<table>
			<tr>
				<td>루트삭제하기</td>
			</tr>
			<tr>
				<td>RouteName : <input type="text" name="routename" value=<%=routename%>></td>
			</tr>
			<tr>
				<td>
				<input type="submit" value="삭제"> 
			</td>
			</tr>
		</table>
	</form>
</body>
</html>