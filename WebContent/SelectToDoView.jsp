<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>여행계획짜기</title>
</head>
<body>

<form method="get" action="TimeManager">
<input type="submit" value="시간선택하기"><p>
</form>
<form method="get" action="StatCityManager">
<input type="submit" value="이동하기"><p>
</form>
<input type="submit" value="식사하기"><p>
<input type="submit" value="숙박하기"><p>

<form method="post" action="CloseManager">
	<input type="submit" value="여행 완료하기"><p>
</form>
----------------------------------------------------------<p>

<form method="post" action="FreeManager">
	<input type="submit" value="자유 여행하기"><p>
</form>



<form method="get" action="CloseManager">
	<input type="submit" value = "취소하기"><p>
</form>

<input type="submit" value="저장하기"><p>

-----------------------------------------------------------<p>
<form method="get" action="TimeTableManager">
	<input type="submit" value="여행스케줄 보기"><p>
	<input type="submit" value="끝내기"><p>
</form>


</body>
</html>