<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="member.model.vo.Member, java.util.ArrayList"%>
    
<%
	
%>     

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

<style>
	body{
			margin-top: 100px;
		}
	
	    #form{
	        width : 800px;
	        height : 450px;
	        border: 1px solid red;
	        margin: auto;
	        padding-inline: 30px;
	        text-align: center;
	    }
</style>

</head>
<body>

<!-- header.jsp include -->
<%@ include file="../common/header.jsp" %>
<br><br>

<h1 align="center"><strong style="color:red ;">헌혈예약</strong></h1>
<br><br>

<div id="form">
<br><br>
	<form method="post" action="<%=contextPath %>/enroll.reserv">
		<h3>회원이름</h3>
		<%=loginMember.getUserName() %>
		
		<!-- 서블릿에서 사용하기 위해 hidden으로 가져간다  -->
        <input type="hidden" name="userNo" value="<%=loginMember.getUserNo()%>">
		
		<br><br>
		<h3>헌혈의집 주소</h3> 
		<select id="location" name="location">
			<option value="">주소</option>
			<option value="서울">서울</option>
			<option value="부산">부산</option>
			<option value="경기">경기</option>
			<option value="인천">인천</option>
			<option value="광주">광주</option>
			<option value="대구">대구</option>
		</select>
		<br><br>
		<select id="locationDetail" name="locationDetail">
			<option>상세주소</option>
		</select>
		<br><br>
		<h3>예약시간</h3>
		<select id="time" name="time">
			<option value="">시간</option>
			<option value="09:00~11:00">09:00~11:00</option>
			<option value="11:00~13:00">11:00~13:00</option>
			<option value="14:00~16:00">14:00~16:00</option>
			<option value="16:00~18:00">16:00~18:00</option>
		</select>
		<br><br>
		<button type="submit" class="btn btn-danger">예약하기</button> <button type="reset" class="btn btn-primary">취소</button>
	</form>
	<br><br>
</div>
<br><br>



<br><br>
<!-- footer.jsp include -->
<%@ include file="../common/footer.jsp" %>


<!-- 상세주소 가져오는 script -->
<script>
	$(function() {
		$('#location').change(function() {
			var seoul = ["서울 중구 한강대로 405 서울역사 지하1층 B05호"
				        ,"서울 서대문구 명물길 6, 신촌빌딩 8층"
				        ,"서울 영등포구 여의대방로 300"
				        ,"서울 구로구 새말로 97, 신도림테크노마트 지하광장"
				        ,"서울 강서구 강서로 385, 우성SB타워 507호"];
			
			var busan = ["부산 부산진구 전포대로 168"
						,"부산 금정구 부산대학로 47, 2층"
						,"부산 부산진구 양지로 54, 진리관 1층"
						,"부산 해운대구 구남로 29번길 38 2층"
						,"부산 사상구 사상로 200, 301호"];
			
			var gyeonggi = ["경기 수원시 권선구 권광로 129"
						   ,"경기 수원시 팔달구 덕영대로 923-1, 4층"
						   ,"경기 안산시 상록구 광덕4로 391, 공영주차장 내"
						   ,"경기 성남시 분당구 분당로 53번길 11, 서원빌딩 4층"
						   ,"경기 수원시 팔달구 권광로 181 씨네파크 2층 204호"
						   ,"경기 화성시 동탄반석로 204 동탄제일프라자 205호"];
			
			var incheon = ["인천 연수구 연수동 함박뫼로 220"
						  ,"인천 부평구 광장로 16, 부평민자역사 1층"
						  ,"인천 남동구 인하로 497-9, 신현프라자 201호"
						  ,"인천 연수구 송도과학로16번길 33-4 송도 트리플스트리트 D동 501호, 503호"];
			
			var gwangju = ["광주 남구 서문대로 406"
						  ,"광주 서구 무진대로 904 종합버스터미널 2층"
						  ,"광주 북구 우치로 100번길 9-4"];
			
			var daegu = ["대구 중구 태평로 7"
						,"대구 중구 동성로 2길 80, 2.28공원관리사무소 내"
						,"대구 북구 영송로 15, 대구보건대학교 문화관 1층"
						,"대구 북구 대학로 83, 4층"];
			
			var changelocation;
			
			if(this.value == "서울") {
				changelocation = seoul;
			} else if(this.value == "부산") {
				changelocation = busan;
			} else if(this.value == "경기") {
				changelocation = gyeonggi;
			} else if(this.value == "인천") {
				changelocation = incheon;
			} else if(this.value == "광주") {
				changelocation = gwangju;
			} else if(this.value == "대구") {
				changelocation = daegu;
			}
			
			$('#locationDetail').empty();
			for(var count=0; count<changelocation.length; count++) {
				var option = $("<option>" + changelocation[count] + "</option>");
				$("#locationDetail").append(option);
			}
			
		});
	});
</script>


</body>




</html>