<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
 <head>
<body>

  <script>
   function viewXML() {
    var xmlDoc = new ActiveXObject("Microsoft.XMLDOM");
    xmlDoc.async = false;
    var loadtext = "http://maps.naver.com/api/geocode.php?key=f95a90125c66a5db7e5c6687969b79e6&query=서울시 중랑구 묵1동";
    loadtext += add.value;
    xmlDoc.load(loadtext);
    var x = xmlDoc.childNodes[1].childNodes[2].childNodes[0].childNodes[0].text 
    var y = xmlDoc.childNodes[1].childNodes[2].childNodes[0].childNodes[1].text
   
    first = xmlDoc.childNodes[1].childNodes[2].childNodes[1].text
    alert(first +" : " + x +"," + y  );
   }
   
   </script>
 </head>
 <body>

  <input type='text' name='add' onkeydown="javascript: if (event.keyCode == 13) {viewXML();}"> 
  <a href="javascript:viewXML()">[ 좌표 가져오기 ]</a><br>

  
  
 </body>
</html>


