<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="member.model.vo.Member, reservation.model.vo.*"%>

<%
	
%>

    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	body{
		margin-top: 100px;
	}
	
	 #view{
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

<h1 align="center"><strong style="color:red ;">예약조회</strong></h1>
<br><br>

<div id="view">
<br><br>

<h3>회원이름</h3>
<%=loginMember.getUserName() %>

<h3>헌혈의집 주소</h3>

<h3>예약시간</h3>

</div>



<br><br>
<!-- footer.jsp include -->
<%@ include file="../common/footer.jsp" %>

</body>
</html>