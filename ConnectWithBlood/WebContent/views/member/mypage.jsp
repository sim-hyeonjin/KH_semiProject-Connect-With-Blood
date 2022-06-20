<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="member.model.vo.*,reservation.model.vo.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이페이지</title>

<link rel="shortcut icon" href="/favicon.ico" type="image/x-icon">
<link rel="icon" href="/favicon.ico" type="image/x-icon">



<!-- jQuery library -->
<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
<!-- Latest compiled JavaScript -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<!-- Popper JS -->
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>





<style>
	.inner{
		border: 0.5px dashed lightgray; padding: 20px;
	}
	.leg{text-align: center;}
	input{
		border:  none;
	}
	td, input {
		font-size: 18px;
	}
	.changebBtn{
		width: 250px;
		height: 40px;
		border-radius: 50px;
		color: white;
		background-color: brown;
		border: none;
	}
	 
	.goMain{
		width: 250px;
		height: 40px;
		margin-left: 60%;
		border-radius: 50px;
		color: white;
		text-decoration: none;
	}
	.changebBtn:hover{background-color: rgb(222, 102, 102);}

	.top{
		text-align: center;
	}
#goMain{
	margin-left: 40%;
}
#outBtn{
	float: right;
}
#deleteBtn{
	font-size: smaller;
}

#non{color: gray;}

#inp_text{
 width:300px;
 text-align:center;
}

#button{
	margin: auto;
	text-align: center;
}

 option{color: crimson;}
 #fontc{color: gray;}
.btn_find:hover{background-color: rgb(222, 102, 102);}
#deleteBtn1{text-align:right;}
#bloodBtn1{text-align:center;}
#bloodBtn2{background-color:brown;}
#bloodBtn2:hover{background-color: rgb(222, 102, 102);}

table td{text-align:center;}
table td input{color:brown;}

#wh{color:brown; text-align:center;}

#searchBtn{
	text-align:center;
	width:300px
}
</style>
</head>
<body>


	<!-- header.jsp include -->
    <%@ include file="../common/header.jsp" %>
    
    <%
		String userId = loginMember.getUserId();
    	int userNo = loginMember.getUserNo();
		String userPw = (loginMember.getUserPw()==null)? "":loginMember.getUserPw();
		String userName = (loginMember.getUserName()==null)? "":loginMember.getUserName();
		String userBirth = (loginMember.getUserBirth()==null)? "":loginMember.getUserBirth();
		String userAddress = (loginMember.getUserAddress()==null)? "":loginMember.getUserAddress();
		String userEmail = (loginMember.getUserEmail()==null)? "":loginMember.getUserEmail();
		String userPhone = (loginMember.getUserPhone()==null)? "":loginMember.getUserPhone();
		String userBloodtype = (loginMember.getUserBloodtype()==null)? "":loginMember.getUserBloodtype();
		
		String bloodWh = (String)session.getAttribute("userBloodInfo");
		
		Reservation reserv = (Reservation)session.getAttribute("reserv");
		String reservationAddress2 = reserv.getReservationAddress2(); //detail
		String reservationDate = reserv.getReservationDate();

 	%>
    

		
			<br><br><br>
			<h1 class="top">My Page</h1>
			<br><br><br>
			
		<form method="post" action="<%=contextPath%>/mypage.mem">
			<fieldset class="inner">
			<!-- <div class="container"> -->
				<h4>개인정보 관리</h4>
				<p>정보 변경을 원하시면 변경할 정보를 입력한 후 하단의 개인정보 수정 버튼을 누르세요</p>
				
				<br>
	<div class="table-responsive">
		<table class="table table-bordered">

			<tr>
				<td>아이디</td>
				<td><input type="text" name="userId" value="<%=userId%>" readonly></td>
			</tr>
			<tr>
				<td>이름</td>
				<td><input type="text" name="userName" value="<%=userName%>" readonly></td>
			</tr>
			<tr>
				<td>주민등록번호</td>
				<td><input type="text" name="userBirth" value="<%=userBirth%>" readonly></td>
			</tr>
			<tr>
				<td>이메일</td>
				<td><input type="email" name="userEmail" value="<%=userEmail%>" readonly></td>
			</tr>
			<tr>
				<td>연락처</td>
				<td><input type="text" name="userPhone" value="<%=userPhone%>" readonly></td>
			</tr>
			<tr>
				<td>주소</td>
				<td><input type="text" name="userAddress" value="<%=userAddress%>" readonly></td>
			</tr>
			<tr>
				<td>혈액형</td>
				<td><input type="text" name="userBloodtype" value="<%=userBloodtype%>" readonly></td>
			</tr>
		</table>
	</div>
	

		<br>
			<div id="bloodBtn1">
			<a href="<%=contextPath%>/views/member/mypage_mody.jsp" class="btn btn-danger" id="bloodBtn2">개인정보 수정</a>
			</div>
			
	</fieldset>
</form>
<br><br>






 <div >
		<fieldset class="inner">
		<form action="<%=contextPath%>/mybloodInfo.mem">
			<input type="hidden" name="userId" value="<%=userId%>">
			
			<h4>헌혈증 관리</h4>
			<p>홈페이지에서 등록한 헌혈증 조회</p>
			<a href="<%=contextPath%>/views/member/insertBloodInfo.jsp" class="btn btn-outline-danger" id="bloodBtn">헌혈증 등록</a>
			 <button class="btn btn-warning" type="submit">조회하기</button>
			<br><br><br>
			
			
			
	<div class="table-responsive">
		<table class="table table-bordered">
			<tr>
				<td>등록된 헌혈증 현황  ['조회하기' 버튼을 눌러주세요]</td>
			</tr>
			<tr>
				<td id="wh"><%=bloodWh%></td>	
			</tr>
		</table>
	</div>
	</form>
</div>








 <div >
	<form action="<%=contextPath%>/list.reserv">
			<input type="hidden" name="userNo" value="<%=userNo%>">
						<br>
			<h4>&nbsp&nbsp&nbsp예약조회</h4>
			<p>&nbsp&nbsp&nbsp&nbsp예약내역 조회</p>
			<br><br><br>

	<div class="table-responsive">
		<table class="table table-bordered">
 
			<tr>
				<td>헌혈의 집 주소</td>
				<td id="wh"><%=reservationAddress2%></td>
			</tr>
			<tr>
				<td>예약 일자</td>
				<td id="wh"><%=reservationDate%></td>	
			</tr>
		</table>
	</div>
	</form>
</div>	
	
	
	









		<br>
		<div id="goMain1">
		<a type="button" href="<%=contextPath%>" class="goMain btn btn-secondary" id="goMain">메인으로 돌아가기</a>
		</div>
	<br>
		<div id="deleteBtn1">
	  <a type="button" class="btn btn-dark"  id="deleteBtn2" href="<%=contextPath%>/views/member/deleteUser.jsp">회원 탈퇴</a>
		</div>


	
	</fieldset>








    
    <br><br><br><br><br>
    	<!-- footer.jsp include -->
	<%@ include file="../common/footer.jsp" %>
	
	
	
<!-- Bootstrap.bundle.min.js -->
<script src=“https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js” integrity=“sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p” crossorigin=“anonymous”></script>
</body>
</html>