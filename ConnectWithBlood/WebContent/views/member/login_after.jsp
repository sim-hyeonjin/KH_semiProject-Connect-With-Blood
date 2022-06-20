<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="member.model.vo.Member"%>


<%
 String userName = request.getParameter("userName");
 String userEmail = request.getParameter("userEmail");
 String userId = (String)session.getAttribute("userId");
%>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

    <meta name='viewport' content='width=device-width, initial-scale=1'>
    <link rel='stylesheet' type='text/css' media='screen' href='main.css'>
    <script src='main.js'></script>

<style>
    a {
        color: #333;
        text-decoration: none;
    }
    input {
        -webkit-writing-mode: horizontal-tb !important;
        text-rendering: auto;
        color: initial;
        letter-spacing: normal;
        word-spacing: normal;
        text-transform: none;
        text-indent: 0px;
        text-shadow: none;
        /* display: inline-block; */
        text-align: start;
        -webkit-appearance: textfield;
        background-color: white;
        -webkit-rtl-ordering: logical;
        cursor: text;
        margin: 0em;
        font: 400 13.3333px Arial;
        padding: 1px 0px;
        border-width: 2px;
        border-style: inset;
        border-color: initial;
        border-image: initial;
    }
.inner_findId {
position: absolute;
left: 50%;
top: 50%;
margin: -145px 0 0 -160px;
}
.findId{
position: relative;
width: 320px;
margin: 0 auto;
}

body, button, input, select, td, textarea, th {
font-size: 13px;
line-height: 1.5;
-webkit-font-smoothing: antialiased;
}    
fieldset, img {
border: 0;
}
.findId .box {
margin: 35px 0 0;
border: 1px solid #ddd;
border-radius: 3px;
background-color: #fff;
box-sizing: border-box;
}
.findId .inp_text {
position: relative;
width: 100%;
margin: 0;
padding: 18px 19px 19px;
box-sizing: border-box;
}
.findId .inp_text+.inp_text {
border-top: 1px solid #ddd;
}
.inp_text input {
display: block;
width: 100%;
height: 100%;
font-size: 13px;
color: #000;
border: none;
outline: 0;
-webkit-appearance: none;
background-color: transparent;
}
.btn_find {
margin-left: 15px;
width: 100%;
height: 48px;
border-radius: 3px;
font-size: 15px;
color: #fff;
background-color: brown;
border-radius: 50px;
padding: 8px;
padding-left: 60px;
padding-right: 60px;
}
.btn_find:hover{background-color: rgb(222, 102, 102);}


fieldset{border: 0.5px dashed lightgray; padding: 20px; }

#returnBtn{border: none;}

#idBox{
    border: none;
    font-weight: bolder;
}
#idBox{text-align: center;}


</style>

<script>

</script>
</head>
<body>



<!-- header.jsp include -->
<%@ include file="../common/header.jsp" %>



<div class="inner_findId">
<div class="findId">
    
    <form method="post" id="authForm">
        <input type="hidden" name="redirectUrl">
        <fieldset>
            <legend align="center"><b>아이디 찾기</b> <br></legend>
            <p style="text-align: center;"> 
            회원가입시 사용한 아이디는 
            <input type="text" id="idBox" value="<%=userId%>"> 입니다.
            </p>
            

            <br>
            <a type="button" id="returnBtn" class="btn_find" href="<%=contextPath%>"></style=>메인으로 돌아가기</a>
            

            
        </fieldset>
    </form>
    
    
    
    
    
    <br><br><br><br><br>
    <!-- footer.jsp include -->
    <%@ include file="../common/footer.jsp" %>
    
    
    
</div>
</div>







</body>
</html>