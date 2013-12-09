<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!doctype html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <title>jQuery UI Datepicker - Select a Date Range</title>
  <link rel="stylesheet" href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css">
  <script src="http://code.jquery.com/jquery-1.9.1.js"></script>
  <script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>
  <link rel="stylesheet" href="/resources/demos/style.css">
  <script>

  $(function() {
    $( "#startDate" ).datepicker({
      defaultDate: "+1w",
      minDate: 0,
      maxDate: "+3M",
      changeMonth: true,
      numberOfMonths: 3,
      onClose: function( selectedDate ) {
          $( "#endDate" ).datepicker( "option", "minDate", selectedDate );
    	  var year = selectedDate.substring(6,10);
    	  var month = parseInt(selectedDate.substring(0,2));
    	  var day = parseInt(selectedDate.substring(3,5)); 
    	  var startDate = new Date(year, month-1, day+6);  // date로 변경
    	  startDate = $.datepicker.formatDate('mm/dd/yy', startDate);
   	  	$( "#endDate" ).datepicker( "option", "maxDate", startDate);
      }
    });
    $( "#endDate" ).datepicker({
      defaultDate: "+1w",
      minDate: "-6D",
      maxDate: "+6D",
      changeMonth: true,
      numberOfMonths: 3,
      onClose: function( selectedDate ) {
        $( "#startDate" ).datepicker( "option", "maxDate", selectedDate);
      }
    });
  });
  </script>
</head>
<body>
<form  method = "get" action="DateManager">

<label for="startDate">여행시작일</label>
<input type="text" id="startDate" name="startDate">
<label for="endDate">여행끝</label>
<input type="text" id="endDate" name="endDate">


	<input type="submit" value="여행 계획 짜기"><p>
</form>

 
</body>
</html>