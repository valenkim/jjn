<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>안녕하세요 관리자모드입니다.</title>
</head>
<body>
<form action="SelectRouteManager" method="get">
	<input type="submit" value="삭제할 루트 선택"><p>
</form>


<form action="ViewUserManager" method="Post">
	<input type="submit" value="회사 정보보기"><p>
</form>
<form action="ViewUserManager" method="get">
	<input type="submit" value="여행자 정보보기"><p>
</form>

<form action="ScoreManager">
	<input type="submit" value="별점보기"><p>
</form>

<form action="ViewOtherRouteManager">
	<input type="submit" value="루트목록보기"><p>
</form>

</body>
</html>

