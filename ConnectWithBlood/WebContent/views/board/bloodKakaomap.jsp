<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList, board.model.jsoup.*"%>
<%
	BloodMapJsoup bloodMapJsoup = new BloodMapJsoup(); 
// 	String[] seoul = bloodMapJsoup.seoul();
	String seoul = bloodMapJsoup.seoul();


%> 
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8"/>
	<title>헌혈증 기증 가능 혈액원</title>
	<!-- Bootstrap core CSS -->
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
	
	<style>
		#id{
			margin-right: 80px;
		}
		div>a{
			text-decoration: none;
			color: rgb(255, 0, 0);
			
		}
		div>a:hover{
			color: brown;
		}

		span{
			font-size: 16px;
			color:grey;
		}
		#outer{
			font-size: 18px;
			border: 1px solid rgb(157, 182, 190);
			width:1000px;
			height:450px;
			padding-inline: 30px;
			padding-top: 10px;
			background-color: rgb(219, 228, 234);
		}
	</style>
</head>
<body>


    <!-- header.jsp include -->
    <%@ include file="../common/header.jsp" %>
    
    		<br><br><br>
    	<h2 align="center">헌혈증 기증 가능 혈액원</h2>
		<br><br>
		<div id="outer"  style="margin-left: 27%;">
		
				* 수혈을 받으신 분들에게 기증받은 헌혈증서를 연간 500매(1,000매_취약계층 등)까지 무상으로 지원해드립니다.<br><br>
	
				* 헌혈증서를 병원에 제출하시면 수혈비용 중 본인부담금을 면제 받을 수 있습니다. (단, 기타 법령에 의해 본인 부담 진료비가 발생하지 않는 
				  분들 [1종 의료급여수급권자, 2종 의료급여수급권자 중 장애인]에게는 헌혈증서를 지급하지 않습니다.)
			<br><br>
				<h5><strong>구비서류</strong></h5>
				1. 헌혈증서 신청서 <br>
				2. 신펑자의 신분증 사본(또는 등·초본) <br>
					<span style="font-size:16px">- 신청자가 본인이 아닐경우 : 신청자와 환자와의 관계를 증명할 수 있는 서류(가족인 경우), 위임장(가족이 아닌 경우)</span><br>
				3. 실제혈액 수혈(사용)량 확인이 가능한 의료기관 발급 증빙서류 <br>
				4. 기타서류 <span>※혈액원에 문의</span>
			<br><br>
				거주지 혹은 치료중인 병원과 가까운 혈액원(헌혈지원팀)으로 문의하시기 바랍니다. <br>
				<span>※ 업무시간 (평일 09:00 ~ 18:00)</span>
		</div>
    
	<div id="map" style="width:1000px;height:800px; margin-top: 80px;margin-left: 27%;"></div>
	<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=1f7c7ae6b81c3f02f9751b96805e5538&libraries=services"></script>
	<script>
		var container = document.getElementById('map');
		var options = {
			center: new kakao.maps.LatLng(35.910701, 127.910667),
			level: 13
		};

		var map = new kakao.maps.Map(container, options);
		
		
		////병원 이름으로 마커 위치, 이름 바꾸고 병원 홈페이지로 연결하기
		
		
		// 마커를 표시할 위치와 내용을 가지고 있는 객체 배열입니다 
		var positions = [
		    {
		        content: '<div><a href="https://www.bloodinfo.net/blood_house.do?action=detail&sitecode=51100001">서울중앙혈액원</a></div>', 
		        latlng: new kakao.maps.LatLng(37.5484638, 126.8698072)
		    },
		    {
		        content: '<div><a href="https://www.bloodinfo.net/blood_house.do?action=detail&sitecode=51100002">서울남부혈액원</a></div>', 
		        latlng: new kakao.maps.LatLng(37.4824625, 127.0430492)
		    },
		    {
		        content: '<div><a href="https://www.bloodinfo.net/blood_house.do?action=detail&sitecode=51100003">서울동부혈액원</a></div>', 
		        latlng: new kakao.maps.LatLng(37.6530259, 127.0581539)
		    },
		    {
		        content: '<div><a href="https://www.bloodinfo.net/blood_house.do?action=detail&sitecode=51100004">부산혈액원</a></div>',
		        latlng: new kakao.maps.LatLng(35.1518684, 129.0670203)
		    },
		    {
		        content: '<div><a href="https://www.bloodinfo.net/blood_house.do?action=detail&sitecode=51100005">경기혈액원</a></div>',
		        latlng: new kakao.maps.LatLng(37.2287154, 127.0312056)
		    },
		    {
		        content: '<div><a href="https://www.bloodinfo.net/blood_house.do?action=detail&sitecode=51100006">인천혈액원</a></div>',
		        latlng: new kakao.maps.LatLng(37.4196076, 126.6899472)
		    },
		    {
		        content: '<div><a href="https://www.bloodinfo.net/blood_house.do?action=detail&sitecode=51100007">강원혈액원</a></div>',
		        latlng: new kakao.maps.LatLng(37.8552763, 127.7318914)
		    },
		    {
		        content: '<div><a href="https://www.bloodinfo.net/blood_house.do?action=detail&sitecode=51100008">충북혈액원</a></div>',
		        latlng: new kakao.maps.LatLng(36.6241564, 127.4510086)
		    },
		    {
		        content: '<div><a href="https://www.bloodinfo.net/blood_house.do?action=detail&sitecode=51100009">대전세종충남혈액원</a></div>',
		        latlng: new kakao.maps.LatLng(36.3656891, 127.4398468)
		    },
		    {
		        content: '<div><a href="https://www.bloodinfo.net/blood_house.do?action=detail&sitecode=51100010">전북혈액원</a></div>',
		        latlng: new kakao.maps.LatLng(35.8560289, 127.0561302)
		    },
		    {
		        content: '<div><a href="https://www.bloodinfo.net/blood_house.do?action=detail&sitecode=51100011">광주전남혈액원</a></div>',
		        latlng: new kakao.maps.LatLng(35.1119472, 126.8835505)
		    },
		    {
		        content: '<div><a href="https://www.bloodinfo.net/blood_house.do?action=detail&sitecode=51100012">대구경북혈액원</a></div>',
		        latlng: new kakao.maps.LatLng(35.8714354, 128.6014455)
		    },
		    {
		        content: '<div><a href="https://www.bloodinfo.net/blood_house.do?action=detail&sitecode=51100013">경남혈액원</a></div>',
		        latlng: new kakao.maps.LatLng(35.234773, 128.686453)
		    },
		    {
		        content: '<div style="height:50px ;"><a href="https://www.bloodinfo.net/blood_house.do?action=detail&sitecode=51100014">제주특별자치도혈액원<br></a></div>',
		        latlng: new kakao.maps.LatLng(33.491844, 126.520514)
		    },
		    {
		        content: '<div><a href="https://www.bloodinfo.net/blood_house.do?action=detail&sitecode=51100007">울산혈액원</a></div>',
		        latlng: new kakao.maps.LatLng(35.5383773, 129.3113596)
		    }
		    
		];
		
		for (var i = 0; i < positions.length; i ++) {
		    // 마커를 생성합니다
		    var marker = new kakao.maps.Marker({
		        map: map, // 마커를 표시할 지도
		        position: positions[i].latlng // 마커의 위치
		    });

		    // 마커에 표시할 인포윈도우를 생성합니다 
		    var infowindow = new kakao.maps.InfoWindow({
		        content: positions[i].content // 인포윈도우에 표시할 내용
		    });

		    // 마커에 mouseover 이벤트와 mouseout 이벤트를 등록합니다
		    // 이벤트 리스너로는 클로저를 만들어 등록합니다 
		    // for문에서 클로저를 만들어 주지 않으면 마지막 마커에만 이벤트가 등록됩니다
		    kakao.maps.event.addListener(marker, 'mouseover', makeOverListener(map, marker, infowindow));
		    kakao.maps.event.addListener(marker, 'click', makeOutListener(infowindow));
		}

		// 인포윈도우를 표시하는 클로저를 만드는 함수입니다 
		function makeOverListener(map, marker, infowindow) {
		    return function() {
		        infowindow.open(map, marker);
		    };
		}

		// 인포윈도우를 닫는 클로저를 만드는 함수입니다 
		function makeOutListener(infowindow) {
		    return function() {
		        infowindow.close();
		    };
		}
		
		
	</script>
	<br><br><br><br>


	<!-- footer.jsp include -->
	<%@ include file="../common/footer.jsp" %>
	
    <!-- Bootstrap.bundle.min.js -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
</html>