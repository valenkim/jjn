<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

</head>
<%
request.setCharacterEncoding("utf-8"); %>


<body>
	<form action="RegistrationManager_C" method="post" >
				
				회사 회원가입폼<br><br>
			ID : <input type="text" name="id"><br>
		    Password : <input type="password" name="pass"><br>
  이름 : <input type="text" name="name"><br>
 
  주소 :  <input type="text" name="address" > <br>
 
email: <input type="text" name="email"><br>
Tel: <input type="text" name="tel"><br>

가게유형<br>
<select name="type" >
  <optgroup label="음식점">
    <option value="한식">한식</option>
    <option value="양식">양식</option>
    <option value="중식">중식</option>
    <option value="일식">일식</option>
    <option value="분식">분식</option>
    <option value="기타1">기타</option>
    
  </optgroup>
  <optgroup label="숙소">
    <option value="모텔">모텔</option>
    <option value="게스트하우스">게스트하우스</option>
    <option value="호텔">호텔</option>
    <option value="찜질방">찜질방</option>
    <option value="기타2">기타</option>
</optgroup>
</select>
<br>
기타사항/메뉴가격<br>
<textarea name="event" rows="10" cols="90"></textarea>
<br>
<input type="hidden" name="mode" value="create"><br>
			<input type="submit" name="register" value="가입"> 
			<input type="reset" name="reset" value="초기화"><br>
					
			
		
	</form>
</body>
</html>