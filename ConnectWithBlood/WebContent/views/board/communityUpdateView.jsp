<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList, board.model.vo.*"%>
<%
	ArrayList<Category> clist = (ArrayList<Category>)request.getAttribute("clist");
	Community comm = (Community)request.getAttribute("comm");
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
    .outer{
        /*  border: 1px solid blue; */
        width:1000px;
        height: 800px;
        margin: auto;
    }

    .mb-3{
        width: 800px;
    }
    #form22{
        border: 1px solid red;
    }

</style>
</head>
<body>
   
  	 <!-- header.jsp include -->
	 <%@ include file="../common/header.jsp" %>
	
	
		<br><br>
     
        <form action="<%=contextPath %>/update.co" method="post" id="update" enctype="multipart/form-data" >


        <input type="hidden" name="cno" value="<%=comm.getCommNo()%>">
        
        
        <div class="outer position-relative" >
        <br>
        <h2 align="center">게시판 글 수정하기</h2>
        <br>

            <div class="position-absolute top-50 start-50 translate-middle">

                카테고리
                <select class="form-select form-select-sm" aria-label=".form-select-sm example" name="category">
                    <%for(Category c : clist){ %>
                            	<option value="<%=c.getCategoryNo()%>"><%=c.getCategoryName()%></option>
                    <%} %>
                </select>
                        <script>
                             $(function(){
                                 $("#update option").each(function(){
                                    if($(this).text()=="<%=comm.getCategoryNo()%>"){
                                         $(this).attr("selected",true); 
                                     }
                                 })

                             })
                        </script>
                <br>

                제목
                <div class="input-group mb-3">
                    <input type="text" class="form-control" id="title" aria-label="Text input with dropdown button" value="<%=comm.getCommTitle() %>" name="title" placeholder="제목">
                </div>

                
                <div class="mb-3">
                    <label for="exampleFormControlTextarea1" class="form-label"  id="content" >내용</label>
                    <textarea class="form-control" id="exampleFormControlTextarea1" rows="10" style="resize:none" name="content" placeholder="내용"><%=comm.getCommContent() %></textarea>
                </div>

                첨부파일
                <%if(at!=null) {%>
                    		<%=at.getOriginName() %>
                    		<input type="hidden" name="originFileNo" value="<%=at.getFileNo()%>">
                    		<input type="hidden" name="originFileName" value="<%=at.getChangeName()%>">
             
               	<%} %>
				<input type="file" name="reupfile">
                <br><br>
                
                
                <div align="center">
                    <button type="submit"  class="btn btn-outline-secondary">수정하기</button>
                    <button type="reset"  class="btn btn-outline-secondary">취소</button>
                </div> 
            
        
            </div>
        </div>
</form>

	<br><br>
	





	<!-- footer.jsp include -->
	<%@ include file="../common/footer.jsp" %>


	<!-- Bootstrap.bundle.min.js -->
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>

</body>
</html>