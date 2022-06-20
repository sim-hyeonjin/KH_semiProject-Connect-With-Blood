<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList, faq.model.vo.Faq"%>
    
<%
ArrayList<Faq> list = (ArrayList<Faq>)request.getAttribute("list");
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
</style>
</head>
<body>

	<!-- header.jsp include -->
    <%@ include file="../common/header.jsp" %>

	<!-- 현재 FAQ 목록 출력 -->
	<table class="table table-hover" style="width:1200px ;" align="center" >
	  <thead>
	    <tr>
	      <th scope="col">FAQ번호</th>
	      <th scope="col">FAQ제목</th>
	      <th scope="col">FAQ내용</th>
	      <th scope="col">FAQ등록날짜</th>
	    </tr>
	  </thead>
	  <tbody>
	  <!-- FAQ 리스트가 비어있는 경우 -->
	  <%if(list.isEmpty()) { %>
	  	<tr>
	  		<td colspan="4">FAQ가 없습니다.</td> 
	  	</tr>
	  <%} else { %>
	  	<!-- FAQ 리스트가 존재 -->
	  	<%for(Faq f : list) {%>
	    <tr>
	      <th scope="row"><%=f.getFaqNo() %></th>
	      <td><%=f.getFaqTitle() %></td>
	      <td><%=f.getFaqContent() %></td>
	      <td><%=f.getFaqDate() %></td>
	    </tr>
	    <%} %>
	  <%} %>
	    
	  </tbody>
	</table>
	
	<br>
	

	<!-- footer.jsp include -->
	<%@ include file="../common/footer.jsp" %>

<!-- Bootstrap.bundle.min.js -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
</html>