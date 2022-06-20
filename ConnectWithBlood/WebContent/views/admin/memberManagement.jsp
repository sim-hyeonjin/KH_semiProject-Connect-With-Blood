<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList,admin.model.vo.*,common.*"%>
<%	
	ArrayList<AdminMember> list = (ArrayList<AdminMember>)request.getAttribute("list");
			 
			
	String keyField = request.getParameter("keyField");
	String keyWord = request.getParameter("keyWord");
	String modifyMemUpdate = request.getParameter("modifyMemUpdate");
	
	MemberPageInfo pi =(MemberPageInfo)request.getAttribute("pi");
	
	int currentPage = pi.getCurrentPage();
	int startPage = pi.getStartPage();
	int endPage = pi.getEndPage();
	int maxPage = pi.getMaxPage();
%>

<%-- 주석처리방법 --%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title> <!-- 규민파트ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ회원상태ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ -->

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>

<!-- Popper JS -->
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

<!-- 위의 링크들은 모달창이 안띄워져서 수업때 진행했던 링크들 복붙하니 모달창나옴. -->

<style>
	body{              
		margin-top: 100px;
	}
</style>
</head>
<body>

	<!-- header.jsp include -->
    <%@ include file="../common/header.jsp" %>
	<br>


	<!-- 멤버 정보 띄우기<!-- 멤버 정보 띄우기 --><!-- 멤버 정보 띄우기 --><!-- 멤버 정보 띄우기 -->
	<div>
		<table id="example-table-1" width="100%" class="table table-dark">
	  <thead align="center">
	    <tr>

	      <th scope="col">회원 아이디</th> <!-- USER_ID -->
	      <th scope="col">이름</th>		<!-- USER_NAME -->
	      <th scope="col">등급</th>		<!-- USER_GRADE -->
	      <th scope="col">가입일</th> <!-- USER_ENROLLDATE -->
	      <th scope="col">최근 로그인 시간</th> <!-- USER_LOGIN -->
	      <th scope="col">회원 상태</th> <!-- USER_STATUS -->
	      <th scope="col"></th> <!-- USER_STATUS -->
	      

	    </tr>
	  </thead align="center">
	  <tbody align="center">
	  
	  <%for(AdminMember ms : list) {%>
	  	<tr>
	  	<td><%=ms.getUserId() %></td>
	  	<td><%=ms.getUserName() %></td>
	  	<td><%=ms.getUserGrade() %></td>
	  	<td><%=ms.getUserEnrolldate() %></td>
	  	<td><%=ms.getUserLogindate() %></td>
	  	<td><%=ms.getUserStatus() %></td>
	  	<td> <button type="button" class="btn btn-danger modifyBtn" data-toggle="modal" data-target="#updateMemForm">수정</button></td>
	  	</tr>
	  <%} %>
	  
	  </tbody align="center">
	</table>
	</div>
	
	<!-- 멤버 정보 끝 -->
	
	<!-- 멤버 정보수정 시작  --> 
	
	<!-- The Modal -->
<div class="modal" id="updateMemForm">
  <div class="modal-dialog">
    <div class="modal-content">

      <!-- Modal Header -->
      <div class="modal-header">
        <h4 class="modal-title">회원정보 수정</h4>
        <button type="button" class="close" data-dismiss="modal">&times;</button>
      </div>

      <!-- Modal body -->
      <div class="modal-body">
		<form action="<%=contextPath%>/memModify.ad" method="post" align="center">
		
		<input type="hidden" id="modalHidden" name="userId">

        <!-- 은장/금장/명예장/명예대장/최고명예대장 -->
        <select name ="userGrade">
			<option value = "">회원 등급수정</option>
			<option value = "은장">은장</option>
			<option value = "금장">금장</option>
			<option value = "명예장">명예장</option>
			<option value = "명예대장">명예대장</option>
			<option value = "최고명예대장">최고명예대장</option>
		</select>
        
        <br><br>
        
        <select name ="userStatus">
	        <option value = "">회원상태 변경</option>
	        <option value = "NORMAL">NORMAL</option>
	        <option value = "SUSPENSION">SUSPENSION</option> <!-- 정지 -->
	        <option value = "WITHDRAWAL">WITHDRAWAL</option> <!-- 탈퇴 -->
        </select>
      </div>

      <!-- Modal footer -->
      <div class="modal-footer">
      <button type="submit" class="btn btn-dark" >정보변경</button>
        <button type="button" class="btn btn-danger" data-dismiss="modal">닫기</button>
      </div>
		</form>

    </div>
  </div>
</div>	    

  
	<script>
		$(function(){
			$(".modifyBtn").click(function(){
				var userId = $(this).parents().eq(1).children().eq(0).text();
				$("#modalHidden").val(userId);
				console.log($("#modalHidden").val());
		
			})
		})
	</script>
	<!-- 멤버 정보수정 끝 멤버 정보수정 끝 멤버 정보수정 끝 멤버 정보수정 끝 멤버 정보수정 끝 멤버 정보수정 끝 멤버 정보수정 끝 멤버 정보수정 끝 -->
	
	<!-- 페이징 처리 시작 페이징 처리 시작 페이징 처리 시작 페이징 처리 시작 페이징 처리 시작 페이징 처리 시작 페이징 처리 시작 페이징 처리 시작  -->
	 <div class="paging-area" align="center">
       		<%if(currentPage!=1){ %>
            <button onclick="location.href='<%=contextPath%>/memManagement.ad?mpage=<%=currentPage-1%>'" class="btn btn-secondary">&lt;</button>
            <%} %> <!--  &lt; < (부등호 꺽쇠) 오른쪽으로 열린 부등호.
 									수식에서 A < B 와 같은 형태로 사용. HTML 코드에서 모든 태그의 시작 기호.-->
            
            <%for(int i =startPage; i<=endPage; i++){ %>
	 			<%if(i!=currentPage){ %>
	            	<button onclick="location.href='<%=contextPath%>/memManagement.ad?mpage=<%=i%>'" class="btn btn-danger"><%=i %></button>
                    <%}else{ %>
				  	<button disabled class="btn btn-danger"><%=i %></button>         
	            <%} %>
            <%} %>
            
            <%if(currentPage!=maxPage){ %>
            <button onclick="location.href='<%=contextPath%>/memManagement.ad?mpage=<%=currentPage+1%>'" class="btn btn-secondary">&gt;</button>
       		<%} %>										<!--  &gt; < (부등호 꺽쇠) 왼쪽으로 열린 부등호.
 														수식에서 A > B 와 같은 형태로 사용. HTML 코드에서 모든 태그의 끝 기호.-->
        </div>
	<!-- 페이징 처리 끝 페이징 처리 끝 페이징 처리 끝 페이징 처리 끝 페이징 처리 끝 페이징 처리 끝 페이징 처리 끝 페이징 처리 끝 페이징 처리 끝  -->
	
	<!-- 멤버명단 검색처리 -->
	<div align="center">
		<form name="search" method="post" action="<%=contextPath%>/memManagementSelect.ad?mpage=1">
		<%if(currentPage!=1){ %>
            <input type="hidden" button onclick="location.href='<%=contextPath%>/memManagementSelect.ad?mpage=<%=currentPage-1%>'"></button>
            <%} %> 
            
            <%for(int i =startPage; i<=endPage; i++){ %>
	 			<%if(i!=currentPage){ %>
	            	<input type="hidden" button onclick="location.href='<%=contextPath%>/memManagementSelect.ad?mpage=<%=i%>'"></button>
                    <%}else{ %>      
	            <%} %>
            <%} %>
            
            <%if(currentPage!=maxPage){ %>
            <input type="hidden" button onclick="location.href='<%=contextPath%>/memManagementUpdate.ad?mpage=<%=currentPage+1%>'"></button>
       		<%} %>										
		
			<select name ="keyField" >
			
				<option value = "userName">회원 이름</option>
			 	<option value = "userGrade">등급</option>
			 	<option value = "userId">회원 아이디</option>
			</select>
				<input type = "text" name ="keyWord"  placeholder="검색어를 입력하세요">
				<input type = "submit" value ="검색" class="btn btn-dark" onclick="searchCheck(form)" required>
		</form>
	</div>
	
	<br>
	
	<script>

    function searchCheck(frm){
        //검색
       
        if(frm.keyWord.value ==""){
            alert("검색 단어를 입력하세요.");
            frm.keyWord.focus();
            return;
        }
        frm.submit();      
    } 
	</script>
	<!-- 멤버명단 검색처리 끝 멤버명단 검색처리 끝 멤버명단 검색처리 끝 멤버명단 검색처리 끝 멤버명단 검색처리 끝 멤버명단 검색처리 끝 -->
	
	
	<br><br><br><br>
   
	<!-- footer.jsp include -->
	<%@ include file="../common/footer.jsp" %>

<!-- Bootstrap.bundle.min.js -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
</html>