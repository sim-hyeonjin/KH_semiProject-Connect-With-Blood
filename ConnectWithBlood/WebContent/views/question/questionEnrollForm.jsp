<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="question.model.vo.*,java.util.ArrayList"%>
<%
	ArrayList<Category> clist = (ArrayList<Category>)request.getAttribute("clist");

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
	
     
        <form action="<%=contextPath %>/insert.que" method="post" id="queEnrollform" enctype="multipart/form-data" >
        
        <div class="outer position-relative" >
        <br><br>
        <h2 align="center">QnA 작성</h2>
        <br>

			<input type="hidden" name="userNo" value="<%=loginMember.getUserNo()%>">


            <div class="position-absolute top-50 start-50 translate-middle">

                <!--카테고리-->
                <select class="form-select form-select-sm" aria-label=".form-select-sm example" name="category">
 					 <%for(Category c : clist){ %>
                            	<option value="<%=c.getCategoryNo() %>"><%=c.getCategoryName() %></option>
                        <%} %>
                </select>
                <br>

                <!--제목-->
                <div class="input-group mb-3">
                    <input type="text" class="form-control" id="title" aria-label="Text input with dropdown button" name="title" placeholder="제목">
                </div>

                <!--내용-->
                <div class="mb-3">
                    <label for="exampleFormControlTextarea1" class="form-label" id="content" >내용</label>
                    <textarea class="form-control" id="exampleFormControlTextarea1" rows="10" style="resize:none" name="content" placeholder="내용"></textarea>
                </div>

                <!--첨부파일-->
                <input type="file" id="upfileQue" name="upfileQue">
                <br><br>
                
                
                <div align="center">
                    <button type="submit"  class="btn btn-outline-secondary">등록하기</button>
                    <button type="reset"  class="btn btn-outline-secondary">초기화</button>
                </div> 
            
        
            </div>
        </div>
</form>

        
	
	
   
   
   
   
   	<!-- footer.jsp include -->
	<%@ include file="../common/footer.jsp" %>


	<!-- Bootstrap.bundle.min.js -->
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
   
</body>
</html>