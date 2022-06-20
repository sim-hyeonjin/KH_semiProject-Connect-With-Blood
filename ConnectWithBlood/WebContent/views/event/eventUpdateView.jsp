<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import = "event.model.vo.*,java.util.ArrayList"%>
<%
	Event e = (Event)request.getAttribute("event");
	Attachment at = (Attachment)request.getAttribute("at");
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
		<h2 align="center">EVENT</h2>
		<br><br>


	<table class="table table-bordered" style="width:700px;" align="center">
		<tr>
			<th colspan="4"><%=e.getEventTitle() %></th>
		</tr>
		<tr>
			<td width="15%">작성자</td>
			<td width="35%"></td>
			<td width="15%">작성일</td>
			<td width="35%"><%=e.getEventDate()%></td>
		</tr>
		<tr>
			<td colspan="2">진행상태</td>
			<th colspan="2"><%=e.getEventProgress() %></th>
		</tr>
		<tr>
			<td colspan="4">
				<p style="height:200px;"><%=e.getEventContent() %></p>
			</td>
		</tr>
					<%if(at==null) {%>
		<tr>
			<td colspan="4">
				<div>
                		첨부파일이 없습니다.
                </div>
			</td>
		</tr>
                	<%}else{ %>
        
		<tr>
			<td>
			첨부파일
			</td>
			<td colspan="3">		
                <img src="<%=contextPath %>/<%=at.getFilePath()+at.getChangeName() %>" width="700" height="550">
			</td>
		</tr>
		
		<tr>
			<td>
			</td>
			<td colspan="3">
				<a download="<%=at.getOriginName() %>" href="<%=contextPath%>/<%=at.getFilePath()+at.getChangeName()%>"><%=at.getOriginName() %></a>
			</td>
		</tr>
		
              <%} %>                


	</table>

	<br><br>
	


	<div align="center">
		<a href="<%=contextPath%>/list.ev?epage=1" class="btn btn-outline-secondary">목록가기</a>


        <%if(loginUser!=null && loginUser.getUserId().equals("admin")) {%>
		<a href="<%=contextPath%>/delete.ev?eno=<%=e.getEventNo()%>">삭제하기</a>
		<a href="<%=contextPath%>/updateForm.ev?eno=<%=e.getEventNo()%>">수정하기</a>
		<%} %>
		<br>
	</div>



	<!-- footer.jsp include -->
	<%@ include file="../common/footer.jsp" %>


	<!-- Bootstrap.bundle.min.js -->
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>

</body>
</html>