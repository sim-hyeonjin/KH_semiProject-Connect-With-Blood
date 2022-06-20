<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
  <head> 
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, 그리고 Bootstrap 기여자들">
    <meta name="generator" content="Hugo 0.88.1">
    <title>ConnectWithBlood</title>

    <link rel="canonical" href="https://getbootstrap.kr/docs/5.1/examples/carousel/">

    <!-- Bootstrap core CSS -->
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

    <!-- Favicons -->
	<link rel="apple-touch-icon" href="/docs/5.1/assets/img/favicons/apple-touch-icon.png" sizes="180x180">
	<link rel="icon" href="/docs/5.1/assets/img/favicons/favicon-32x32.png" sizes="32x32" type="image/png">
	<link rel="icon" href="/docs/5.1/assets/img/favicons/favicon-16x16.png" sizes="16x16" type="image/png">
	<link rel="manifest" href="/docs/5.1/assets/img/favicons/manifest.json">
	<link rel="mask-icon" href="/docs/5.1/assets/img/favicons/safari-pinned-tab.svg" color="#7952b3">
	<link rel="icon" href="/docs/5.1/assets/img/favicons/favicon.ico">
	<meta name="theme-color" content="#7952b3">

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

    
    <!-- Custom styles for this template -->
    <link href="resources/css/carousel.css" rel="stylesheet">
  </head>
  <body>
    
    <!-- header.jsp include -->
    <%@ include file="views/common/header.jsp" %>

	<main>
	
	  <div id="myCarousel" class="carousel slide" data-bs-ride="carousel">
	    <div class="carousel-indicators">
	      <button type="button" data-bs-target="#myCarousel" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
	      <button type="button" data-bs-target="#myCarousel" data-bs-slide-to="1" aria-label="Slide 2"></button>
	      <button type="button" data-bs-target="#myCarousel" data-bs-slide-to="2" aria-label="Slide 3"></button>
	    </div>
	    <div class="carousel-inner">
	      <div class="carousel-item active">
	        <img src="resources/images/notice.jpg" alt="" width="100%" height="100%" xmlns="http://www.w3.org/2000/svg" aria-hidden="true" preserveAspectRatio="xMidYMid slice" focusable="false"><rect width="100%" height="100%" fill="#777"/></img>
	
	        <div class="container">
	          <div class="carousel-caption text-start">
	            <p><a class="btn btn-lg btn-primary" href="<%=contextPath%>/list.no?npage=1">더보기</a></p>
	          </div>
	        </div>
	      </div>
	      <div class="carousel-item">
	        <img src="resources/images/event.jpg" alt="" width="100%" height="100%" xmlns="http://www.w3.org/2000/svg" aria-hidden="true" preserveAspectRatio="xMidYMid slice" focusable="false"><rect width="100%" height="100%" fill="#777"/></img>
	
	        <div class="container">
	          <div class="carousel-caption">
	            <p><a class="btn btn-lg btn-primary" href="<%=contextPath%>/list.ev?epage=1">더보기</a></p>
	          </div>
	        </div>
	      </div>
	      <div class="carousel-item">
	        <img src="resources/images/faq.jpg" alt="" width="100%" height="100%" xmlns="http://www.w3.org/2000/svg" aria-hidden="true" preserveAspectRatio="xMidYMid slice" focusable="false"><rect width="100%" height="100%" fill="#777"/></img>
	        <div class="container">
	          <div class="carousel-caption text-end">
	            <p><a class="btn btn-lg btn-primary" href="<%=contextPath%>/list.faq">더보기</a></p>
	          </div>
	        </div>
	      </div>
	    </div>
	    <button class="carousel-control-prev" type="button" data-bs-target="#myCarousel" data-bs-slide="prev">
	      <span class="carousel-control-prev-icon" aria-hidden="true"></span>
	      <span class="visually-hidden">Previous</span>
	    </button>
	    <button class="carousel-control-next" type="button" data-bs-target="#myCarousel" data-bs-slide="next">
	      <span class="carousel-control-next-icon" aria-hidden="true"></span>
	      <span class="visually-hidden">Next</span>
	    </button>
	  </div>
	
	
	  <!-- Marketing messaging and featurettes
	  ================================================== -->
	  <!-- Wrap the rest of the page in another container to center all the content. -->
	
	  <div class="container marketing">
	
	    <!-- Three columns of text below the carousel -->
	    <div class="row">
	      <div class="col-lg-4">
	        <img src="resources/images/bloodEnroll.png" alt=""  width="140" height="140" xmlns="http://www.w3.org/2000/svg" role="img" aria-label="Placeholder: 140x140" preserveAspectRatio="xMidYMid slice" focusable="false"><title></title><rect width="100%" height="100%" fill="#777"/><text x="50%" y="50%" fill="#777" dy=".3em"></text></img>
	        <h2>헌혈증 등록</h2>
	        <p>헌혈에 감사드립니다</p>
	        <p><button type="button" class="btn btn-secondary" data-bs-toggle="modal" data-bs-target="#staticBackdrop">등록하기 &raquo;</button></p>
	      </div><!-- /.col-lg-4 -->
	      
	      
	      
	      <!-- 헌혈증 등록 모달 시작  -->
	      
<div class="modal fade" id="staticBackdrop" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
  <div style="text-align: center" class="modal-dialog modal-dialog-centered modal-dialog-scrollable">
    <div class="modal-content">
      <div class="modal-header">
        <h3 strong style="color:brown" class="modal-title" id="staticBackdropLabel">헌혈증 등록</h3>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
			<form action="<%=contextPath%>/insertB.mem" method="post">
				<br><h4>회원이름</h4> <br>
              <div class="box">
                    <div class="inp_text">
                        <input type="text" id="inp_text" name="userId" placeholder="아이디를 입력해주세요" >
                    </div>
                </div>
                <br>
                <div class="box">
                    <div class="inp_text">
                        <input type="text" id="inp_text" name="bloodNo" maxlength="12" placeholder="헌혈증 일련번호를 입력해주세요 (-포함)" >
                    </div>
                </div>
                    
                    <br><br>
				
				<h4>헌혈종류</h4> 
                <div id="domainsBox" >
                    <select id="domains"  name="bloodWh">
                        <option id="fontc">헌혈 종류를 선택해주세요</option>
                        <option value="전혈헌혈_320ml" name="bloodWh">전혈헌혈- 320ml</option>
                        <option value="전혈헌혈_400ml" name="bloodWh">전혈헌혈- 400ml</option>
                        <option value="성분헌혈_혈장" name="bloodWh">성분헌혈- 혈장</option>
                        <option value="성분헌혈_혈소판" name="bloodWh">성분헌혈- 혈소판</option>
                    </select>
                </div>
             <br><br>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">취소</button>
        <button type="submit" class="btn btn-primary">등록</button>
      </div>
 		</form>
      </div>
    </div>
  </div>
</div>
	      
	      <!-- 헌혈증 등록 모달 끝 -->
	      
	      <div class="col-lg-4">
	        <img src="resources/images/blood.png" alt="" width="140" height="140" xmlns="http://www.w3.org/2000/svg" role="img" aria-label="Placeholder: 140x140" preserveAspectRatio="xMidYMid slice" focusable="false"><title>Placeholder</title><rect width="100%" height="100%" fill="#777"/><text x="50%" y="50%" fill="#777" dy=".3em"></text></img>
	        <h2>헌혈예약</h2>
	        <p>헌혈을 예약해보세요</p>
	        <p><a class="btn btn-secondary" href="views/reservation/reservation.jsp">예약하기 &raquo;</a></p>

	      </div><!-- /.col-lg-4 -->
	      <div class="col-lg-4">
	        <img src="resources/images/question.png" alt="" width="140" height="140" xmlns="http://www.w3.org/2000/svg" role="img" aria-label="Placeholder: 140x140" preserveAspectRatio="xMidYMid slice" focusable="false"><title>Placeholder</title><rect width="100%" height="100%" fill="#777"/><text x="50%" y="50%" fill="#777" dy=".3em"></text></img>
	        <h2>문의하기</h2>
	        <p>무엇을 도와드릴까요?</p>
	        <p><a class="btn btn-secondary" href="<%=contextPath%>/list.queu?qpage=1">문의하기 &raquo;</a></p>
	      </div><!-- /.col-lg-4 -->
	    </div><!-- /.row -->
	
	
	    <!-- START THE FEATURETTES -->
	
	    <hr class="featurette-divider">
	
	    <div class="row featurette">
	      <div class="col-md-7">
	        <h2 class="featurette-heading">World Blood Donor <span class="text-muted">Day</span></h2><br>
	        <p class="lead">세계 헌혈자의 날(World Blood Donor Day)은 자발적 무상 헌혈에 참여하는 헌혈자에게 감사와 존경을 전하기 위해 마련된 기념일이다.</p>
	        <a href="https://www.who.int/campaigns/world-blood-donor-day" style="text-decoration: none;">더보기</a>
	      </div>
	      <div class="col-md-5">
	        <img src="resources/images/bloodDay.png" alt="" width="500" height="500" xmlns="http://www.w3.org/2000/svg" role="img" aria-label="Placeholder: 500x500" preserveAspectRatio="xMidYMid slice" focusable="false"><title>Placeholder</title><rect width="100%" height="100%" fill="#eee"/><text x="50%" y="50%" fill="#aaa" dy=".3em"></text></img>
	
	      </div>
	    </div>
	
	    <hr class="featurette-divider">
	
	    <div class="row featurette">
	      <div class="col-md-7 order-md-2">
	        <h2 class="featurette-heading">Youtube <span class="text-muted">Video</span></h2>
	        <p class="lead">대한적십자사 혈액관리본부 공식 유튜브</p>
	        <a href="https://www.youtube.com/c/ABO%ED%8A%9C%EB%B8%8C" style="text-decoration: none;">더보기</a>
	      </div>
	      <div class="col-md-5 order-md-1">
			<iframe width="500" height="500" src="https://www.youtube.com/embed/FqL8EtRRUs0" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>	
	      </div>
	    </div>
	
	    <hr class="featurette-divider">
	
	    <div class="row featurette">
	      <div class="col-md-7">
	        <h2 class="featurette-heading">Blood <span class="text-muted">Information</span></h2>
	        <p class="lead" style="font-size: 23px;">혈액형의 종류에는 흔히 알고 계시는 ABO혈액형 뿐만 아니라 Rh- 및 여러가지 희귀 혈액형이 있습니다</p>
	        <a href="https://www.bloodinfo.net/bloodknowledge_bloodtype.do" style="text-decoration: none;">더보기</a>
	      </div>
	      <div class="col-md-5">
	        <img src="resources/images/abo.jpg" alt="" width="500" height="500" xmlns="http://www.w3.org/2000/svg" role="img" aria-label="Placeholder: 500x500" preserveAspectRatio="xMidYMid slice" focusable="false"><title>Placeholder</title><rect width="100%" height="100%" fill="#eee"/><text x="50%" y="50%" fill="#aaa" dy=".3em"></text></img>
	
	      </div>
	    </div>
	
	    <hr class="featurette-divider">
	
	    <!-- /END THE FEATURETTES -->
	
	  </div><!-- /.container -->
	
	
		<!-- footer.jsp include -->
	    <%@ include file="views/common/footer.jsp" %>
	  
	</main>

	<!-- bootstrap.bundle.min.js -->
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>

  </body>
</html>

    