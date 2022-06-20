<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>헌혈예약</title>
<style>
    #text1{
        width : 800px;
        height : auto;
        border: 1px solid red;
        margin: auto;
        padding-inline: 30px;
    }

    #text2{
        width : 800px;
        height : auto;
        border: 1px solid red;
        margin: auto;
        padding-inline: 30px;
    }
    
    #agree{
      width: 800px;
      margin: auto;
      display: block;
    }
</style>

</head>
<body>


<!-- header.jsp include -->
<%@ include file="../common/header.jsp" %>
<br><br>

<h1 align="center"><strong style="color:red ;">유의사항</strong></h1>
<br><br>

<div id="text1">
<br>
<h4 strong style="color:red">예약 및 취소 시</h4> <br>
- 6개월 이내 헌혈의집으로 예약할 수 있으며, 당일 예약은 불가합니다.<br>
- 최근 헌혈혈액검사결과에 따라 예약이 제한될 수 있습니다.<br>
  (예약 후 헌혈혈액검사결과 이상 판정 시 예약이 자동 취소되며 안내문자가 발송됩니다.)<br>
- 문자메시지로 예약현황을 안내해 드립니다.<br>
  (예약 직후, 예약일 3일 전, 예약 당일)<br>
- 예약안내 문자를 받지 못하신 경우에는 예약현황을 확인해 주십시오.<br>
- 헌혈의집 사정으로 예약일정이 변경 또는 취소될 수 있으며, 예약일 이전에 헌혈 참여 시 예약이력은 자동 취소됩니다.<br>
<br><br>
<h4 strong style="color:red">예약 후 방문 시</h4><br>
- 예약시간 경과 시 예약이 취소되니 시간을 꼭 지켜주십시오.<br>
- 헌혈장소 도착 시 예약헌혈자임을 직원에게 말씀해 주십시오.<br>
- 당일 상황에 따라 헌혈 대기시간이 지연될 수 있습니다.<br>
- 긴급헌혈 또는 혈액재고 등에 따라 헌혈종류 변경을 요청드릴 경우 양해와 협조 부탁드립니다.<br>
- 전자문진에 미리 참여 후 방문하시는 경우 헌혈시간이 단축될 수 있습니다.<br>
  (전자문진 참여 후 3일간 유효)<br>
- 부득이한 사정으로 방문하지 못하시는 경우 예약을 취소해 주시거나 CRM센터(1600-3705)로 연락주십시오.<br>
<br><br>
<h4 strong style="color:red">헌혈 예약없이 현장 방문시 헌혈접수 마감시간</h4><br>
- 전혈 헌혈 : 운영 종료시간 30분전<br>
- 혈장 성분헌혈 : 운영 종료시간 1시간 전<br>
- 혈소판성분헌혈, 혈소판혈장성분헌혈 : 운영 종료시간 1시간 30분전<br>
※ 단 당일 대기중인 헌혈자가 많은 경우 안내된 시간보다 조기에 헌혈접수가 마감 될수 있습니다.<br><br>
</div>
<br><br>

<h1 align="center"><strong style="color:red ;">개인정보 수집 및 이용에 대한 안내</strong></h1>
<br><br>

<div id="text2">
<br>
<h4 strong style="color:red">개인정보 수집 및 이용에 대한 안내</h4>

<h4 strong style="color:red">[수집 및 이용 목적]</h4>
  - 헌혈예약 및 예약 관련 상담<br>

<h4 strong style="color:red">[수집 및 이용 항목]</h4>
  - (필수) 이름, 주민등록번호(외국인등록번호), 휴대전화번호<br>

  - 혈액관리법 시행령 제10조의 2에 따라 헌혈예약 시 헌혈경력 및 검사결과 조회를 위해 주민등록번호를 처리.<br>

<h4 strong style="color:red">[이용 및 보유 기간]</h4>
  - 헌혈예약 후 5년<br>

<h4 strong style="color:red">[동의거부 권리 및 불이익]</h4>
  - 정보주체는 개인정보 수집에 동의하지 않을 권리가 있으며, 필수항목을 입력하지 않으시는 경우 헌혈예약이 불가.<br><br>
</div>
<br><br>

	<a class="btn btn-danger" id="agree" href="<%=contextPath%>/views/reservation/reservationEnroll.jsp">개인정보 수집 및 이용 동의</a>

<br><br>
<!-- footer.jsp include -->
<%@ include file="../common/footer.jsp" %>

</body>
</html>