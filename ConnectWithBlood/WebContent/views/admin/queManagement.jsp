<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8"><!-- 규민파트ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ -->

 <!-- Bootstrap core CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <title>회원관리-회원목록</title>
</head>
<body>
	<!-- header.jsp include -->
    <%@ include file="../common/header.jsp" %>
    <div class="inquiry">

        <table class="table table-dark">
            <thead  align="center">
                <tr>
                    <td>1:1 문의</td>
                    <td><a href="">1</a></td>
                </tr>
                <tr>
                    <td>답변 수</td>
                    <td><a href="">0/0</a></td>
                </tr>
            </thead>
            </table>
    </div>
    <br><br><br><br><br><br><br><br>

    <table class="table table-dark">
    <thead  align="center">
        <tr>
            <td><input type="checkbox" name="all" onclick="answer(this.checked);"></td>
            <td>질문유형</td>
            <td>제목</td>
            <td>작성자</td>
            <td>작성일</td>
            <td>처리여부</td>
            <td>답변자</td>
            <td>답변일시</td>
            
        </tr>
    </thead>
    <tbody align="center">
        <tr>
            <td><input type="checkbox" name="blood"></td>
            <td>
                <select name="h_area1" onChange="cat1_change(this.value,h_area2)" class="h_area1">
                <option>-선택-</option>
                <option value='1'>헌혈예약</option>
                <option value='2'>헌혈예매</option>
                <option value='3'>헌혈구매</option>
                <option value='4'>헌혈강매</option>
                </select>
            </td>
            <td>헌혈 안무섭나요?</td>
            <td>user1</td>
            <td>2022-01-01</td>
            <td><input type="checkbox"></td> <!--처리여부는 밑에 답변일시 있어서 필요없지 않나요?-->
            <td>                
                <select name="h_area1" onChange="cat1_change(this.value,h_area2)" class="h_area1">
                <option>-선택-</option>
                <option value='1'>관리자1</option>
                <option value='2'>관리자2</option>
                <option value='3'>관리자3</option>
                </select>
            </td>
            <td>2022-01-02</td>

        </tr>
        <script>
            function answer(isTrue){
                var subject=document.getElementsByName("blood"); 

                for(var i=0; i<subject.length;i++){
                    if(isTrue){
                        subject[i].checked=true; 
                    }else{                      
                        subject[i].checked=false;
                    }
                }
            }
        </script>
    </tbody>
    

</body>
</html>