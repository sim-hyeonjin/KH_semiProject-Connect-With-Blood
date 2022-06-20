<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList, question.model.vo.*, common.PageInfo"%>
    
<%
	ArrayList<Question> list = (ArrayList<Question>)request.getAttribute("list");

	PageInfo pi = (PageInfo)request.getAttribute("pi");
	
	int currentPage = pi.getCurrentPage();
	int startPage = pi.getStartPage();
	int endPage = pi.getEndPage();
	int maxPage = pi.getMaxPage();

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

	<br><br>
	<h2 align="center">Q&A</h2>
	<br><br>


	<!-- 현재 QnA 목록 출력 -->
	<table class="table table-hover" style="width:1200px ;" align="center">
	  <thead>
	    <tr>
	      <th scope="col">질문번호</th>
	      <th scope="col">질문종류</th>
	      <th scope="col">질문제목</th>
<!-- 	      <th scope="col">질문내용</th> -->
	      <th scope="col">질문작성자</th>
	      <th scope="col">질문일자</th>
	    </tr>
	  </thead>
	  <tbody>
	  <!-- 질문 리스트가 비어있는 경우 -->
	  <%if(list.isEmpty()) { %>
	  	<tr>
	  		<td colspan="6">질문이 없습니다.</td> 
	  	</tr>
	  <%} else { %>
	  	<!-- 질문 리스트가 존재 -->
	  	<%for(Question q : list) {%>
	    <tr>
	      <th scope="row"><%=q.getQuestionNo() %></th>
	      <td><%=q.getCategoryNo() %></td>
	      <td><%=q.getQuestionTitle() %></td>
<%-- 	      <td><%=q.getQuestionContent() %></td> --%>
	      <td><%=q.getQuestionWriter() %></td>
	      <td><%=q.getQuestionDate() %></td>
	    </tr>
	    <%} %>
	  <%} %>
	    
	  </tbody>
	</table>
	
	<script>
        $(function(){
          $(".table>tbody>tr").click(function(){
            location.href = "<%=contextPath%>/detail.que?qno="+$(this).children().eq(0).text();
          })
        })

      </script>
	
	<br>
	
	<!--페이징-->
       <div class="paging-area" align="center">
        	<%if(currentPage!=1) {%>
            <button onclick="location.href='<%=contextPath %>/list.que?qpage=<%=currentPage-1 %>'" class="btn btn-light">&lt;</button>
			<%} %>
			
			<%for(int i=startPage;i<endPage+1;i++) {%>
			<%if(i!=currentPage){ %>
			<button onclick="location.href='<%=contextPath %>/list.que?qpage=<%=i %>'" class="btn btn-light"><%=i %></button>
			<%}else{ %> 
			<button disabled class="btn btn-light"><%=i %></button> 
			<%} %>
			<%} %>
			
			<%if(currentPage!=maxPage){ %>          
        	<button onclick="location.href='<%=contextPath %>/list.que?qpage=<%=currentPage+1 %>'" class="btn btn-light">&gt;</button>
        	<%} %>
        
        
        </div>
	
	

	<!-- footer.jsp include -->
	<%@ include file="../common/footer.jsp" %>

<!-- Bootstrap.bundle.min.js -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
</html>