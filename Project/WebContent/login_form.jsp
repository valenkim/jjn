<?xml version="1.0" encoding="utf-8" ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>login_form</title>
</head>
<body>
<form method="post" action ="/Project/login">
<table>
<tr>
<td>아이디:</td>
<td><input type="text" name="id" size="15"></td>
</tr>
<tr>
<td>비밀번호:</td>
<td><input type="text" name="pass" size="15"></td>
</tr>
<tr>
<td colspan="2" align="center"><input type="submit" name="login" value="로그인">
<input type="reset" name="logout" value="다시입력">
<a href="register_form.jsp">
<b>회원가입</b>
</a>
</td>
</tr>
</table>
</form>
</body>
</html>
