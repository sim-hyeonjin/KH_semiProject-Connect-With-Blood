<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
// int여도 String으로 받아서 다시 int로 형변환 해야하나?
  /*String temp_todayNewMemberCnt = (String)request.getAttribute("todayNewMemberCnt");
  int todayNewMemberCnt = 0;
  if(temp_todayNewMemberCnt != null){
    todayNewMemberCnt = Integer.parseInt(temp_todayNewMemberCnt);
  }
  String temp_monthNewMemberCnt = (String)request.getAttribute("monthNewMemberCnt");
  int monthNewMemberCnt = 0;
  if(temp_monthNewMemberCnt != null){
    monthNewMemberCnt = Integer.parseInt(temp_monthNewMemberCnt);
  }*/
  //금일 신규회원 현황
  int todayNewMemberCnt = (Integer)request.getAttribute("todayNewMemberCnt");
  int monthNewMemberCnt = (Integer)request.getAttribute("monthNewMemberCnt");
  //금일,이번달 탈퇴회원 현황
  int todayDelMemberCnt = (Integer)request.getAttribute("todayDelMemberCnt");
  int monthDelMemberCnt = (Integer)request.getAttribute("monthDelMemberCnt");
  //금일,이번달 정지회원 현황
  int todayStopMemberCnt = (Integer)request.getAttribute("todayStopMemberCnt");
  int monthStopMemberCnt = (Integer)request.getAttribute("monthStopMemberCnt");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8"><!-- 규민파트ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ -->
 <!-- Bootstrap core CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
  <title>회원관리-회원현황</title>
    <style>
      div { text-align: center; }
    </style>
</head>
<body>
  <!-- header.jsp include -->
    <%@ include file="../common/header.jsp" %>
        <br><br>
        <div>
       <p><img src="https://blog.kakaocdn.net/dn/cbHGnP/btq6Q7UdArH/s02cmddpSfUvi2ylZvTdkK/img.png" width="650" height="450"  align="center"></p>
      </div>
      <div class="table-responsive">
        <table class="table table-dark table-hover">
          <thead>
            <tr align="center">
              <th scope="col"></th>
              <th scope="col">신규회원</th>
              <th scope="col">탈퇴회원</th>
              <th scope="col">정지회원</th>
            </tr>
          </thead>
          <tbody>
            <tr align="center">
            <td>금일현황</td>
            <td><%=todayNewMemberCnt %></td>
            <td><%=todayDelMemberCnt %></td>
            <td><%=todayStopMemberCnt %></td>
            </tr>
            <tr align="center">
            <td>이 달 합계</td>
            <td><%=monthNewMemberCnt %></td>
            <td><%=monthDelMemberCnt %></td>
            <td><%=monthStopMemberCnt %></td>
            </tr>
          </tbody>
        </table>
      </div>
<!-- Custom js for this template -->
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
  <script src="https://cdn.jsdelivr.net/npm/feather-icons@4.28.0/dist/feather.min.js" integrity="sha384-uO3SXW5IuS1ZpFPKugNNWqTZRRglnUJK6UAZ/gxOX80nxEkN9NcGZTftn6RzhGWE" crossorigin="anonymous"></script>
</body>
</html>