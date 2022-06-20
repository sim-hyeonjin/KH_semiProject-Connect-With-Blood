<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList, question.model.vo.*"%>

<%
	Question que = (Question)request.getAttribute("que");
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

	table p{
		border: 1px solid grey;
	}
		table{
/* 		border: 1px solid red; */
		width: 700px;
		
	}
    #reply-area tr{
            border: 0px solid black;
            border-width: 0px 0px 1px 0px;
    }
</style>
</head>
<body>

	<!-- header.jsp include -->
    <%@ include file="../common/header.jsp" %>

	
	<br><br>
	<h2 align="center">Q&A</h2>
	<br><br>



	<table class="table table-bordered" style="width:700px ;" align="center">
		<tr>
			<th colspan="4"><%=que.getQuestionTitle() %></th>
		</tr>
		<tr>
			<td width="15%">작성자</td>
			<td width="35%"><%=que.getQuestionWriter() %></td>
			<td width="15%">카테고리</td>
			<td width="35%"><%=que.getCategoryNo() %></td>
		</tr>
		<tr>
			<th colspan="4"><%=que.getQuestionDate() %></th>
		</tr>
		<tr>
			<td colspan="4">
				<p style="height:200px;"><%=que.getQuestionContent() %></p>
			</td>
		</tr>
		<tr>
			<td>첨부파일</td>
			<td colspan="3">
                	<%if(at==null) {%>
                		첨부파일이 없습니다.
                	<%}else{ %>
                		<a download="<%=at.getOriginName() %>" href="<%=contextPath%>/<%=at.getFilePath()+at.getChangeName()%>"><%=at.getOriginName() %></a>
                	<%} %>
            	</td>
		</tr>

	</table>

	<br><br>
	<div align="center">
		<a href="<%=contextPath%>/list.queu?qpage=1" class="btn btn-outline-secondary">목록가기</a>

           <%if(loginMember!=null && loginMember.getUserName().equals(que.getQuestionWriter())||isAdmin) {%>
		<a href="<%=contextPath%>/delete.que?qno=<%=que.getQuestionNo()%>" class="btn btn-outline-secondary">삭제하기</a>
		<a href="<%=contextPath%>/updateForm.que?qno=<%=que.getQuestionNo()%>" class="btn btn-outline-secondary">수정하기</a>
		<%} %>		
	</div>
	<br><br>
	 <!--댓글 기능-->
        <div id="reply-area">
            <table align="center" >
                <thead>
                	<%if(loginMember.getUserId().equals("admin")){ %>
                    <tr>
                        <th style="width:10%">댓글작성</th>
                        <td style="width:80%" align="center">
                            <textarea id="replyContent" cols="65" rows="3" style="resize:none"></textarea>
                        </td>
                        <td style="width:10%"><button onclick="insertReply();" class="btn btn-outline-secondary">등록</button></td>
                    </tr>
					<%}else{ %> 
					<tr>
                        <th style="width:10%">댓글작성</th>
                        <td style="width:80%" align="center">
                            <textarea cols="65" rows="3" style="resize:none" readonly>관리자만 작성할 수 있습니다.</textarea>
                        </td>
                        <td style="width:10%"><button disalbed class="btn btn-outline-secondary">등록</button></td>
                    </tr>
					<%} %>
                </thead>
                <tbody>

                </tbody>
            </table>
            
            <script>
               $(function(){
                    selectReply();

                })
            //댓글 작성 함수
                function insertReply(){
                    $.ajax({
                        url : "replyInsert.que",
                        data : {
                            content : $("#replyContent").val(),
                            qno : <%=que.getQuestionNo()%>

                        },
                        type : "post",
                        success : function(result){ 
							
							if(result>0){ 
								selectReply(); 
								$("#replyContent").val("");
							}
                        },
                        error : function(){
                            console.log("ajax 통신 실패");
                        }
                    })
                }

                //댓글 조회 함수
                function selectReply(){
                    $.ajax({
                        url : "replyList.que",
                        data : {
                            qno : <%=que.getQuestionNo()%>
                        },
                        success : function(list){ //[{},{},{}]
                            
                            var row = "";
                            for(var i in list){
                                row += "<tr>"
                                    +   "<td>"+"관리자"+"</td>"
                                    +   "<td>"+list[i].ansContent+"</td>"
                                    +   "<td>"+list[i].ansDate+"</td>"
                                    +"</tr>";

                            }

                            $("#reply-area tbody").html(row);

                        },
                        error : function(){
                            console.log("ajax 통신 실패");
                        }
                    })
                }
            
            </script>
            
	</div>

	<br><br><br>


	
	<!-- footer.jsp include -->
	<%@ include file="../common/footer.jsp" %>
	
	
<!-- Bootstrap.bundle.min.js -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
</html>