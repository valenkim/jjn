<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="/Project/register" method="post">
<table>
 <tr>
  <td>회원가입폼</td>
 </tr>
 <tr>
  <td>ID : <input type="text" name="id"></td>
  </tr>
 <tr>
  <td>Password : <input type="password" name="pass"></td>
 </tr>
 <tr>
  <td>이름 : <input type="text" name="name"></td>
 </tr>
  <tr>
  <td>email: <input type="text" name="email"></td>
 </tr>
 <tr>
  <td>Tel: <input type="text" name="tel"></td>
 </tr>
  <tr>
  <td>
  <input type="submit" name="register" value="가입"> 
  <input type="reset" name="reset" value="초기화"><br>
    </td>
 </tr>
</table>
</form>
</body>
</html>