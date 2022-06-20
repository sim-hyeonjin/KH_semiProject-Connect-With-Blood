<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="member.model.vo.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이페이지</title>




 
 

<!-- Bootstrap core CSS -->
<link href=“https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css” rel=“stylesheet” integrity=“sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin=“anonymous”>
<!-- jQuery library -->
<script src=“https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js”></script>

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">

<!-- Popper JS -->
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>



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
	margin-left: 50%;
	font-size: smaller;
}

#non{color: rgb(172, 172, 172)}

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


</style>
</head>
<body>


	<!-- header.jsp include -->
    <%@ include file="../common/header.jsp" %>
    
    <%
String userId = loginMember.getUserId();

String userPw = (loginMember.getUserPw()==null)? "":loginMember.getUserPw();
String userName = (loginMember.getUserName()==null)? "":loginMember.getUserName();
String userBirth = (loginMember.getUserBirth()==null)? "":loginMember.getUserBirth();
String userAddress = (loginMember.getUserAddress()==null)? "":loginMember.getUserAddress();
String userEmail = (loginMember.getUserEmail()==null)? "":loginMember.getUserEmail();
String userPhone = (loginMember.getUserPhone()==null)? "":loginMember.getUserPhone();
String userBloodtype = (loginMember.getUserBloodtype()==null)? "":loginMember.getUserBloodtype();

 %>
    
 

  <fieldset style="border: 0.5px dashed lightgray; padding: 20px;">
	<br><br><br>
    <div>
		
			<br><br><br>
			<h1 class="top">마이페이지</h1>
			<br><br><br>
			
		<form method="post" action="<%=contextPath%>/mody.mem">
	<div class="table-responsive">
		<table class="table table-bordered">
						<tr>
							<td>아이디</td>
							<td><input type="text" name="userId" id="non" value="<%=userId%>" readonly></td>
						</tr>
						<tr>
							<td>비밀번호</td>
							<td><input type="text" name="userPw" value="<%=userPw%>" ></td>
						</tr>
						<tr>
							<td>이름</td>
							<td><input type="text" name="userName" value="<%=userName%>" ></td>
						</tr>
						<tr>
							<td>주민등록번호</td>
							<td><input type="text" name="userBirth" id="non" value="<%=userBirth%>" readonly></td>
						</tr>
						<tr>
							<td>이메일</td>
							<td><input type="email" name="userEmail" value="<%=userEmail%>" ></td>
						</tr>
						<tr>
							<td>연락처</td>
							<td><input type="text" name="userPhone" value="<%=userPhone%>" ></td>
						</tr>
						<tr>
							<td>주소</td>
							<td><input type="text" name="userAddress" value="<%=userAddress%>" ></td>
						</tr>
						<tr>
							<td>혈액형</td>
							<td><input type="text" name="userBloodtype" id="non" value="<%=userBloodtype%>" readonly></td>
						</tr>
					</table>
				</div>
				
				<div class="modal-footer">
					<button type="submit" class="btn btn-outline-primary">수정하기</button>
					<a type="button" class="btn btn-secondary" href="<%=contextPath%>/views/member/mypage.jsp">닫기</a>
				</div>
		</form>
	</div>
	
	</fieldset>




</body>
</html>