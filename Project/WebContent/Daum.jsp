<!DOCTYPE html>
<html>
<head>
<title>Hello, World!</title>
<meta name="viewport" content="initial-scale=1.0,user-scalable=no">
<style type="text/css">
html { height: 100% }
body { height: 100%; margin: 0; padding: 0 }
#map { width: 100%; height: 100% }
</style>
<script type="text/javascript" src="http://apis.daum.net/maps/maps3.js?apikey=0729b388f5177c4711ea55f7369ac7551d79392d"></script>
<script type="text/javascript">
	window.onload = function() {
	var position = new daum.maps.LatLng(37.537123, 127.005523);

	var map = new daum.maps.Map(document.getElementById('map'), {
		center: position,
		level: 4,
		mapTypeId: daum.maps.MapTypeId.HYBRID
	});

	var marker = new daum.maps.Marker({
		position: position
	});
	marker.setMap(map);

	var infowindow = new daum.maps.InfoWindow({
		content: 'Hello, World!'
	});
	infowindow.open(map, marker);
	};
</script>
</head>
<body>
<div id="map"></div>
</body>
</html>