<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv='X-UA-Compatible' content='IE=edge'>
    <meta name='viewprot' content='width=device-width,initial-scale=1.0'>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR&display=swap" rel="stylesheet">
    <title>사이트 소개 페이지</title>

    <style>
        .wrap {
            margin-top: 3%;
            width: 100%;
        }
        
        html, body {
            height: 100%;
            margin: 0;
            padding: 0;
            /* padding-bottom: 50px; */
        }

        .text {
            /* font-family: 'Nanum Pen Script', cursive; */
            font-family: 'Noto Sans KR', sans-serif;
            font-size: 25px;
            text-align: center;
            color: rgb(114, 114, 114);
        }


        /* body * {
            border: thin red solid;
        } */
        section img {
            width: 55vh;
            height: 40vh;
            display: block;
            margin-left: auto;
            margin-right: auto;
        }
        
    </style>
</head>
<body>
    <!-- header.jsp include -->
    <%@ include file="../common/header.jsp" %>
    <div class="wrap">  
        <!-- <h2 style="color: rgb(141, 45, 45)">함께 살고자 합니다</h2> -->
        <section>
            <br><br>
            <img src="../../resources/images/소개.jpg" alt=""> <br>
            <p class="text">
                안녕하세요. <span style="color: red;">Connect With Blood</span> 입니다. <br>
                이 글을 보고 계시다는 것은 조금이라도 헌혈에 관심이 있었다는 뜻이겠죠. <br>
                여러분들의 방문을 환영합니다. <br> <br>
                혹시 헌혈을 해보셨나요? 해보셨다면 헌혈증을 어떻게 하셨나요? <br>
                평소에도 혈액은 부족했지만 코로나까지 겹치면서 혈액이 많이 필요한 상황입니다. <br>
                현재 개인이 개인에게 헌혈증을 기증하기 위해선 우편으로 전달하는 방법밖에 없습니다. <br>
                저희는 온라인으로 헌혈증을 등록하여 기증을 한다면 이러한 불편함을 줄일 수 있지 <br> 
                않을까 하는 생각으로 <span style="color: red;">Connect With Blood</span> 서비스를 시작했습니다. <br>
                쓰이지 않은 헌혈증과 헌혈의 활성화에 조금이나마 보탬이 되고 싶습니다.


            </p>
        </section>
    </div>

    
</body>
</html>