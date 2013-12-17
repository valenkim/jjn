<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<% String id = request.getParameter("id").toString(); %>
</head>
<body>
	<form action="AdminUI.jsp" method="post">
		<table>
			<tr>
				<td>회원삭제하기</td>
			</tr>
			<tr>
				<td>ID : <input type="text" name="id"  value =<%=id %>></td>
			</tr>
			<tr>
				<td><input type="hidden" name="mode" value="delete"> 
				<input type="submit" name="register" value="삭제"> 
				<input type="reset" name="reset" value="초기화"><br></td>
			</tr>
		</table>
	</form>
</body>
</html>