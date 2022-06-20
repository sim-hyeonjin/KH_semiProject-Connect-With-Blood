<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList, notice.model.vo.*"%>
<%
	Notice n  = (Notice)request.getAttribute("n");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ConnectWithBlood</title>
<!-- Bootstrap core CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<style>
	body{
		margin-top: 20px;
	}
	table{
		border: 1px solid red;
		width: 40px;
		al
	}
	table p{
		border: 1px solid grey;
	}
</style>
</head>
<body>

	<!-- header.jsp include -->
    <%@ include file="../common/header.jsp" %>
		<br><br>
		<h4 align="center">NOTICE</h4>
		<br><br>
	

	<table class="table table-bordered" style="width:700px;" align="center">
		<tr>
			<th colspan="4"><%=n.getNoticeTitle() %></th>
		</tr>
		<tr>
			<td width="20%">작성자</td>
			<td width="30%"><%=n.getNoticeWriter() %></td>
			<td colspan="2" align="center"><%=n.getNoticeDate() %></td>
		</tr>
		<tr>
			<td colspan="4">
				<p style="height:200px;"><%=n.getNoticeContent() %></p>
			</td>
		</tr>


	</table>

	<br><br>
	


	<div align="center">
		<a href="<%=contextPath%>/list.no?npage=1" class="btn btn-outline-secondary">목록가기</a>


	<%if(loginMember!=null && loginMember.getUserId().equals("admin")) {%>
		<a href="<%=contextPath%>/delete.no?nno=<%=n.getNoticeNo()%>" class="btn btn-outline-secondary">삭제하기</a>
		<a href="<%=contextPath%>/updateForm.no?nno=<%=n.getNoticeNo() %>" class="btn btn-outline-secondary">수정하기</a>
	<%} %>
	<br><br>
		
	</div>
	<!-- footer.jsp include -->
	<%@ include file="../common/footer.jsp" %>
	
	
<!-- Bootstrap.bundle.min.js -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
</html>