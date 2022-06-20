<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="faq.model.vo.Faq, java.util.ArrayList"%>
    
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
	
        .q{
            width: 800px;
            height: 60px;
            text-align: center;
            border: 0px solid black;
            border-width: 1px 0px 1px 0px;
            cursor: pointer;
            font-size:large;
            line-height:60px;
        }

        .a{
            border: 0px solid gray;
            border-width: 1px 0px 1px 0px;
            width: 800px;
            height: auto;
            display: none; 
            margin-top: 5px;
            padding: 10px;
            box-sizing: border-box;
            background-color: rgb(243, 243, 243);
            text-align: center;
            font-size:large;
            
        }


</style>
</head>
<body>

	<!-- header.jsp include -->
    <%@ include file="../common/header.jsp" %>

	<div align="center">
		<br><br>
		<h2 align="center">FAQ</h2>
		<br><br>

	<%if(list.isEmpty()){ %>
	<table style="width:1000px ;" align="center">
        	<tr>
        		<td>작성된 FAQ가 없습니다</td>
        	</tr>
	</table>
        
     <%}else{ %>
	
		<%for(Faq f : list){ %>

		<div class="q">Q. <%=f.getFaqTitle() %></div>
        <p class="a">A. <%=f.getFaqContent() %></p>
		
        
        <%} %>
	<%} %>
	</div>

	<script>
	
        $(function(){
            $(".q").click(function(){

                
                var $answer = $(this).next(); 
                
                if($answer.css("display")=="none"){
                    $(this).siblings(".a").slideUp();
                    
                    $(".q").css("font-weight", "normal");

                    $(this).css("font-weight", "bold");
                    
                    $answer.slideDown();
                }else{
                    $answer.slideUp();

                    $(".q").css("font-weight", "normal");

                }
            
            });
        });
    </script>

	<br><br>



	<!-- footer.jsp include -->
	<%@ include file="../common/footer.jsp" %>

	<!-- Bootstrap.bundle.min.js -->
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>

</body>
</html>