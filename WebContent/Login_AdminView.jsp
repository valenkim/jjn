<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>login_form</title>
</head>
<body>
<form method="get" action ="Login_traveler">
<table>
<tr>
<td>아이디:</td>
<td><input type="text" name="id" size="15"></td>
</tr>
<tr>
<td>비밀번호:</td>
<td><input type="password" name="pass" size="15"></td>
</tr>
<tr>
<td colspan="2" align="center">
<input type="hidden" name="mode" value="login">
<input type="submit" name="login" value="로그인">
<input type="reset" name="logout" value="다시입력">
<p>관리자<p>
id : admin<p>
pass : 1234

</a>
</td>
</tr>
</table>
</form>
</body>
</html>
