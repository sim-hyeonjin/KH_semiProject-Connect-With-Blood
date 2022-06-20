<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import = "event.model.vo.Event,java.util.ArrayList,common.PageInfo"%>

<%
	ArrayList<Event> list = (ArrayList<Event>)request.getAttribute("list");
	PageInfo pi = (PageInfo)request.getAttribute("pi");

	int currentPage = pi.getCurrentPage();
	int startPage = pi.getStartPage();
	int endPage = pi.getEndPage();
	int maxPage = pi.getMaxPage();
%>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<meta charset="UTF-8">
<title>ConnectWithBlood</title>
<style>
	body{
		margin-top: 20px;
	}

  .table{
    width: 1000px;

  }
  
  .outer{
	width:1200px;	
	margin-left:auto;
	margin-right:auto;
  }
</style>
</head>
<body>

	<!-- header.jsp include -->
    <%@ include file="../common/header.jsp" %>
    
    <div class="outer" align="center">
    	<br><br>
    	<h2 align="center">EVENT</h2>
   		<br><br>
    <div class="inner" align="center">
      <table align="center" class="table table-hover">
        <thead>
            <tr align="center">
              <th style="width:10% ;">No</th>
              <th style="width:10% ;">진행여부</th>
              <th>제목</th>
              <th style="width:15% ;">작성일</th>
              <th style="width:10% ;">조회수</th>
              
            </tr>
        </thead>
        <tbody>
        
        	<%if(list.isEmpty()){ %>
        	<tr>
        		<td colspan="6">작성된 게시글이 없습니다</td>
        	</tr>
        
       		<%}else{ %>
            		<%for(Event e : list) {%>
		            <tr align="center">
		              <td><%=e.getEventNo() %></td>
		              <td><%=e.getEventProgress() %></td>
		              <td align="left"><%=e.getEventTitle() %></td>
		              <td><%=e.getEventDate() %></td>
		              <td><%=e.getEventCount() %></td>
		            </tr>
		            <%} %>
            	<%} %>
        </tbody>
      </table>
    </div>



	<script>
      $(function(){
            $(".table>tbody>tr").click(function(){
                location.href = "<%=contextPath%>/detail.ev?eno="+$(this).children().eq(0).text();

<%-- location.href = "<%=contextPath%>/detail.ev?eno=3"; --%>

            })
        })
    </script>
	
	 <%if(loginMember!=null && loginMember.getUserId().equals("admin")) {%>
      <div align="center"> 
        <a href="<%=contextPath%>/enrollForm.ev" class="btn btn-outline-secondary">글작성</a>
      </div>
      <%} %>
      <br><br>
	

      <br><br>


      </div>

      <!--페이징-->
       <div class="paging-area" align="center">
        	<%if(currentPage!=1) {%>
            <button onclick="location.href='<%=contextPath %>/list.ev?epage=<%=currentPage-1 %>'" class="btn btn-light">&lt;</button>
			<%} %>
			
			<%for(int i=startPage;i<endPage+1;i++) {%>
			<%if(i!=currentPage){ %>
			<button onclick="location.href='<%=contextPath %>/list.ev?epage=<%=i %>'" class="btn btn-light"><%=i %></button>
			<%}else{ %> 
			<button disabled class="btn btn-light"><%=i %></button> 
			<%} %>
			<%} %>
			
			<%if(currentPage!=maxPage){ %>          
        	<button onclick="location.href='<%=contextPath %>/list.ev?epage=<%=currentPage+1 %>'" class="btn btn-light">&gt;</button>
        	<%} %>
        
        
        </div>
	
	
	<!-- footer.jsp include -->
	<%@ include file="../common/footer.jsp" %>
	
	
<!-- Bootstrap.bundle.min.js -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
</html>