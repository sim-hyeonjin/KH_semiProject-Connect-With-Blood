<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList"%>


<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, 그리고 Bootstrap 기여자들">
    <meta name="generator" content="Hugo 0.88.1">
    <title>Dashboard</title>
    <link rel="canonical" href="https://getbootstrap.kr/docs/5.1/examples/dashboard/">
	<!-- Ajax -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
	<!-- Custom styles for this template -->
    <link href="../../resources/css/dashboard.css" rel="stylesheet">
    <!-- Icon -->
  	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.1/font/bootstrap-icons.css">
  	
  	<!-- Chart -->
  	<script src="https://cdn.jsdelivr.net/npm/chart.js@2.8.0"></script>
    <!-- Favicons -->
	<link rel="apple-touch-icon" href="/docs/5.1/assets/img/favicons/apple-touch-icon.png" sizes="180x180">
	<link rel="icon" href="/docs/5.1/assets/img/favicons/favicon-32x32.png" sizes="32x32" type="image/png">
	<link rel="icon" href="/docs/5.1/assets/img/favicons/favicon-16x16.png" sizes="16x16" type="image/png">
	<link rel="manifest" href="/docs/5.1/assets/img/favicons/manifest.json">
	<link rel="mask-icon" href="/docs/5.1/assets/img/favicons/safari-pinned-tab.svg" color="#7952B3">
	<link rel="icon" href="/docs/5.1/assets/img/favicons/favicon.ico">
	<meta name="theme-color" content="#7952B3">
    <style>
      .bd-placeholder-img {
        font-size: 1.125rem;
        text-anchor: middle;
        -webkit-user-select: none;
        -moz-user-select: none;
        user-select: none;
      }
      @media (min-width: 768px) {
        .bd-placeholder-img-lg {
          font-size: 3.5rem;
        }
      }
    </style>
  </head>
  <body>
  	<!-- header.jsp include -->
    <%@ include file="../common/header.jsp" %>
    <br><br>
  	
	        
	
	
<div class="container-fluid">
  <div class="row">
    <nav id="sidebarMenu" class="col-md-3 col-lg-2 d-md-block bg-light sidebar collapse">
      <div class="position-sticky pt-3">
        <ul class="nav flex-column">
          <li class="nav-item">
            <a class="nav-link active" aria-current="page" href="#">
              <span data-feather="home"></span>
              Dashboard
            </a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="<%=contextPath%>/memManagement.ad?mpage=1">
              <i class="bi bi-people"></i>
              회원상태
            </a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="<%=contextPath%>/membershipStatus.ad">
              <i class="bi bi-person-plus"></i>
              회원현황
            </a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="<%=contextPath%>/list.no?npage=1">
              <i class="bi bi-star"></i>
              공지사항
            </a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="<%=contextPath%>/list.queu?qpage=1">
              <i class="bi bi-question-circle"></i>
              QnA
            </a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="<%=contextPath%>/list.faq">
              <i class="bi bi-list"></i>
              FAQ
            </a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="<%=contextPath%>/list.ev?epage=1">
              <i class="bi bi-gift"></i>
              이벤트관리
            </a>
          </li>
<!--           <li class="nav-item dropdown"> -->
<!--             <a class="nav-link dropdown-toggle" href="#" role="button" id="dropdownMenuLink" data-bs-toggle="dropdown" aria-expanded="false"> -->
<!--               <i class="bi bi-people"></i> -->
<!--               회원관리 -->
<!--             </a> -->
<!--             <ul class="dropdown-menu" aria-labelledby="navbarDarkDropdownMenuLink"> -->
<%--               <li><a class="dropdown-item" href="<%=contextPath%>/memManagement.ad">회원상태</a></li> --%>
<%--               <li><a class="dropdown-item" href="<%=contextPath%>/queManagement.ad">문의내역</a></li> --%>
<%--               <li><a class="dropdown-item" href="<%=contextPath%>/membershipStatus.ad">회원현황</a></li> --%>
<!--             </ul> -->
<!--           </li> -->
<!--           <li class="nav-item dropdown"> -->
<!--             <a class="nav-link dropdown-toggle" href="#" role="button" id="dropdownMenuLink" data-bs-toggle="dropdown" aria-expanded="false"> -->
<!--               <i class="bi bi-file-text"></i> -->
<!--               게시판관리 -->
<!--             </a> -->
<!--             <ul class="dropdown-menu" aria-labelledby="navbarDarkDropdownMenuLink"> -->
<%--               <li><a class="dropdown-item" href="<%=contextPath%>/list.no?npage=1">공지사항</a></li> --%>
<%--               <li><a class="dropdown-item" href="<%=contextPath%>/list.que?qpage=1">QnA</a></li> --%>
<%--               <li><a class="dropdown-item" href="<%=contextPath%>/list.faq">FAQ</a></li> --%>
<!--             </ul> -->
<!--           </li> -->
        </ul>
      </div>
    </nav>
	
	<!-- 차트 부분 -->
    <main class="col-md-9 ms-sm-auto col-lg-10 px-md-4">
      <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
        <h1 class="h2">헌혈증 등록현황</h1>
      </div>
      <canvas class="my-4 w-100" id="myChart" width="900" height="500"></canvas>
      <!-- 부트스트랩 -->
	  <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
	    integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
	    crossorigin="anonymous"></script>
	  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
	    integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
	    crossorigin="anonymous"></script>
	  <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
	    integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
	    crossorigin="anonymous"></script>
	   
  <!-- 차트 -->
  <script>
    var ctx = document.getElementById('myChart').getContext('2d');
    var chart = new Chart(ctx, {
      // 챠트 종류를 선택
      type: 'line',
      // 챠트를 그릴 데이터
      data: {
        labels: ['6일전', '5일전', '4일전', '3일전', '2일전', '1일전', '오늘'],
        datasets: [{
          label: '헌혈증 등록현황',
          backgroundColor: 'transparent',
          borderColor: 'red',
          data: [10
          		,20
          		,15
          		,30
          		,53
          		,12
          		,66]
        }]
      },
      // 옵션
      options: {}
    });
  </script>
  	<!-- footer.jsp include -->
	<%@ include file="../common/footer.jsp" %>
	<!-- Custom js for this template -->
	
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/feather-icons@4.28.0/dist/feather.min.js" integrity="sha384-uO3SXW5IuS1ZpFPKugNNWqTZRRglnUJK6UAZ/gxOX80nxEkN9NcGZTftn6RzhGWE" crossorigin="anonymous"></script>
  </body>
</html>