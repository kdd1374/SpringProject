<%@page import="com.dto.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8"/>
	<title>Daum 지도 시작하기</title>
</head>
<body>
	<div id="map" style="width:500px;height:400px; margin:auto;top:100px;"></div>
	<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=7027320d53e7e69cbfd3e9345005f0ea"></script>
	<script>
		var container = document.getElementById('map');
		var options = {
			center: new daum.maps.LatLng(37.499406, 127.028975),
			level: 3
		};

		var map = new daum.maps.Map(container, options);
		
		// 마커가 표시될 위치입니다 
		var markerPosition  = new daum.maps.LatLng(37.499406, 127.028975); 

		// 마커를 생성합니다
		var marker = new daum.maps.Marker({
		    position: markerPosition
		});

		// 마커가 지도 위에 표시되도록 설정합니다
		marker.setMap(map);

		var iwContent = '<div style="padding:5px;">고양이네<br><a href="http://map.daum.net/link/map/고양이네,37.499406, 127.028975" style="color:blue" target="_blank">큰지도보기</a> <a href="http://map.daum.net/link/to/고양이네,37.499406, 127.028975" style="color:blue" target="_blank">길찾기</a></div>', // 인포윈도우에 표출될 내용으로 HTML 문자열이나 document element가 가능합니다
		    iwPosition = new daum.maps.LatLng(37.499406, 127.028975); //인포윈도우 표시 위치입니다

		// 인포윈도우를 생성합니다
		var infowindow = new daum.maps.InfoWindow({
		    position : iwPosition, 
		    content : iwContent 
		});
		  
		// 마커 위에 인포윈도우를 표시합니다. 두번째 파라미터인 marker를 넣어주지 않으면 지도 위에 표시됩니다
		infowindow.open(map, marker); 
	</script>
</body>
</html>
