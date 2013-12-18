<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>여행계획짜기</title>
</head>
<body>
<table cellspacing="1"  width="800" cellpadding="5" > 
<tr align="center"><td>
<form method="get" action="TimeManager">
<input type="submit" value="시간선택하기"><p>
</form>
<form method="get" action="StatCityManager">
<input type="submit" value="이동하기"><p>
</form>
<form method="get" action="InputMealAddressView.jsp">
<input type="submit" value="식사하기"><p>
</form>
<form method="get" action="InputSleepAddressView.jsp">
<input type="submit" value="숙박하기"><p>
</form>

<form method="post" action="CloseManager">
	<input type="submit" value="여행 완료하기"><p>
</form>

<form method="post" action="FreeManager">
	<input type="submit" value="자유 여행하기"><p>
</form>

<form method="get" action="CloseManager">
	<input type="submit" value = "취소하기"><p>
</form>

<form method="get" action="SelectSaveView.jsp">
<input type="submit" value="저장하기"><p>
</form>

</td>
<td align="left">☞ 숙박하기를 선택하시면 하루 일과가 종료 됩니다.<p>
<p>☞ 취소하기를 누르시면 저장하지 않은 자료는 사라집니다.
<p>☞ 자유여행을 누르시면 하루가 "자유여행"으로 표시되고 다음날로 넘어갑니다.</td></tr>

</table>
----------------------------------------------------------------------------------------------------------------<p>

<table cellspacing="1"  width="800" cellpadding="5" > 
<tr align="center"><td>
<form method="post" action="TimeTableManager">
	<input type="submit" value="여행스케줄 보기"><p>
</form>

<form action="TravelerUI.jsp">
	<input type="submit" value="돌아가기"><p>
</form>

</td>
<td align="left">☞ 내가 만든 여행 스케줄을 볼 수 있습니다.<p>
☞ 돌아가기를 누르면 루트 만들기, 다른 루트 보기 페이지로 돌아갑니다.<p>
</p></td>
</table>
----------------------------------------------------------------------------------------------------------------<p>

</body>
</html>