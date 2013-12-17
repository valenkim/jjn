<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

</head>

<body>
	<form action="RegistrationManager_T" method="post" >
				
				여행자 회원가입폼<br><br>
			ID : <input type="text" name="id"><br>
		    Password : <input type="password" name="pass"><br>
  이름 : <input type="text" name="name"><br>
 
  주소 : <input type="text" name="address"><br>
 
email: <input type="text" name="email"><br>
Tel: <input type="text" name="tel"><br>

싫어하는 음식<br>
<input type="radio" name="hate" value="한식">한식
<input type="radio" name="hate" value="양식">양식
<input type="radio" name="hate" value="중식">중식
<input type="radio" name="hate" value="일식">일식
<input type="radio" name="hate" value="분식">분식
<input type="radio" name="hate" value="기타1">해당없음<br>
택일<br>

<input type="hidden" name="mode" value="create"><br>
			<input type="submit" name="register" value="가입"> 
			<input type="reset" name="reset" value="초기화"><br>
					
			
		
	</form>
</body>
</html>