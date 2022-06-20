<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset='utf-8'>
    <meta http-equiv='X-UA-Compatible' content='IE=edge'>
    <title>아이디 찾기</title>
    <meta name='viewport' content='width=device-width, initial-scale=1'>








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
    width: 100%;
    height: 48px;
    border-radius: 3px;
    font-size: 15px;
    color: #fff;
    background-color: brown;
    border-radius: 50px;
    padding: 8px;
    padding-left: 70px;
    padding-right: 70px;
    border: none;
}
.btn_find:hover{background-color: rgb(222, 102, 102);}


 fieldset{border: 0.5px dashed lightgray; padding: 20px; }

 #domains{
     width: 100%;
     height: 30px;
    text-align: center;
    border-color: lightgray;
}


</style>


</head>
<body>





	    <%@ include file="../common/header.jsp" %>
    
    

<div class="inner_findId">
    <div class="findId">
        
        <form method="post" id="authForm" action="<%=contextPath %>/findId.mem">
            <input type="hidden" name="redirectUrl">
            <fieldset style="border: 0.5px dashed lightgray; padding: 20px;">
                <legend align="center"><b>아이디 찾기</b> <br></legend>
                	<br><br>
                
                <div class="box">
                    <div class="inp_text">
                        <input type="text" id="findId_name" name="userName" placeholder="이름을 입력해주세요" >
                    </div>
                </div>
            <div>
                <div class="box findId_eamil">
                    <div class="inp_text">
                        <input type="email" id="findId_eamil" name="userEmail" placeholder="이메일을 입력해주세요" >
                    </div>
                </div>
                    <!-- <div id="domainsBox" >
                        <select id="domains" >
                            <option value="naver.com">naver.com
                            <option value="daum.net">daum.net
                            <option value="gmail.com">gmail.com
                            <option value="yahoo.co.kr">yahoo.co.kr
                        </select>
                    </div> -->
            </div>                        
                

        <br>
        <button type="submit" class="btn_find">아이디 찾기</button>

	

        </div>
        </fieldset>
        </form>
        
        

        

        <br><br><br><br><br>
            <!-- footer.jsp include -->
            <%@ include file="../common/footer.jsp" %>



    </div>
</div>

	
	
	



</body>
</html>