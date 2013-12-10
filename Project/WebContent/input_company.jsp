<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
<form action="/Project/company" method="post">
 가게유형<br>
<select name="type">
  <optgroup label="음식점">
    <option value="Korea1">한식</option>
    <option value="Usa">양식</option>
    <option value="China">중식</option>
    <option value="Japan">일식</option>
    <option value="Korean2">분식</option>
    <option value="Etc1">기타</option>
  </optgroup>
  <optgroup label="숙소">
    <option value="Motel">모텔</option>
    <option value="Guest">게스트하우스</option>
    <option value="Hotel">호텔</option>
    <option value="Jjim">찜질방</option>
    <option value="Etc2">기타</option>
</optgroup>
</select>
<br><br>
장소<br>
<select name="city">
<optgroup label="주요도시">
<option value="Seoul">서울특별시</option>
<option value="Busan">부산광역시</option>
<option value="In">인천광역시</option>
<option value="Kwang">광주광역시</option>
<option value="Ulsan">울산광역시</option>
<option value="Daejun">대전광역시</option>
<option value="Daegu">대구광역시</option>
</optgroup>
</select>
<tr>
<td>나머지주소입력 : <input type="text" name="address" size="100"></td>
</tr>
<br><br>
기타사항/메뉴가격<br>
<textarea name="event" rows="10" cols="90"></textarea>
<br><br>
<tr>
  <td>
  <input type="submit" name="company" value="저장"> 
  <input type="reset" name="reset" value="초기화"><br>
    </td>
 </tr>
 </form>
</body>
</html>
