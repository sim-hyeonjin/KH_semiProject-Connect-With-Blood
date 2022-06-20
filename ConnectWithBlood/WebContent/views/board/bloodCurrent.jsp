<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  import="java.util.ArrayList, board.model.jsoup.*"%>
<%
	BloodJsoup bloodJsoup = new BloodJsoup(); 
	String[] bloodCellDays = bloodJsoup.bloodCellDay();
	String[] bloodCellTotals = bloodJsoup.bloodCellTotal();
	String[] bloodCellStocks = bloodJsoup.bloodCellStock();
	String[] PlateletDays = bloodJsoup.PlateletDay();
	String[] PlateletTotals = bloodJsoup.PlateletTotal();
	String[] PlateletStocks = bloodJsoup.PlateletStock();
	String today = bloodJsoup.today();

	
%>    


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>혈액 보유 현황</title>
<!-- Bootstrap core CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

<style>
    .cap{
        caption-side: top;
    }

    .btn-outline-secondary{
       

        margin-left:68.5% ;
    }
/*     body{ */
/* 		    margin-top: 100px; */
/* 	} */
	#outer{
			margin-top: 100px;
	
	}
</style>

</head>
<body>
	
	<div id="outer">
	<br><br>

	<h3 align="center" style="font-weight:600 ;">오늘의 혈액보유량</h3>


    <!-- header.jsp include -->
    <%@ include file="../common/header.jsp" %>
	<br><br>

    <table border="1" style="color: black; width: 1000px;" align="center">  
        <tr>
        	<td></td>
        </tr>
        <tr>
            <td>혈액보유현황은 매일 <strong style="color:red ;">00:00 기준</strong></td> 
        </tr>
        <tr>
        	<td></td>
        </tr>
        <tr>
            <td>현재 혈액보유량 = 의료기관 공급가능한 재고 + 검사대기혈액 재고 (검사대기혈액 : 검사종료 후 의료기관 공급 가능한 혈액)</td>
        </tr>
        <tr>
        	<td></td>
        </tr>
    </table>
    <br><br>

  <h3 align="center">적혈구 체제</h3>
    <table border="1" style="color: black; width: 1000px;"  class="table table-hover" align="center">
    
        
        <caption class="cap"><%=today %> 기준 / 단위 : unit</caption>
        <caption class="cap2"><p style="color:red ;" >* 적정혈액보유량은 일평균 5일분이상입니다.</p></caption>
        <thead>
            <tr>
                <th>구분</th>
                <th>합계</th>
                <th>O형</th>
                <th>A형</th>
                <th>B형</th>
                <th>AB형</th>
            </tr>
        </thead>
        <tbody>
            <tr>
                <td>1일 소요량</td>
                <td><%=bloodCellDays[2] %></td>
                <td><%=bloodCellDays[3] %></td>
                <td><%=bloodCellDays[4] %></td>
                <td><%=bloodCellDays[5] %></td>
                <td><%=bloodCellDays[6] %></td>
            </tr>
            <tr>
                <td>현재 혈액 보유량</td>
                <td><%=bloodCellTotals[2] %></td>
                <td><%=bloodCellTotals[3] %></td>
                <td><%=bloodCellTotals[4] %></td>
                <td><%=bloodCellTotals[5] %></td>
                <td><%=bloodCellTotals[6] %></td>
            </tr>
            
            
            <tr>
                <td>보유상태</td>
                <td><%=bloodCellStocks[0]%></td>
                <td><%=bloodCellStocks[1]%></td>
                <td><%=bloodCellStocks[2]%></td>
                <td><%=bloodCellStocks[3]%></td>
                <td><%=bloodCellStocks[4]%></td>
            </tr>
        </tbody>
    </table>

         

    <h3 align="center">농축 혈소판</h3>
    <table border="1" style="color: black; width: 1000px;" class="table  table-hover" align="center">
        <caption class="cap"><%=today %> 기준 / 단위 : unit</caption>
        <caption class="cap2"></caption>
        <thead>
            <tr>
                <th>구분</th>
                <th>합계</th>
                <th>O형</th>
                <th>A형</th>
                <th>B형</th>
                <th>AB형</th>
            </tr>
        </thead>
        <tbody>
            <tr>
                <td>1일 소요량</td>
                <td><%=PlateletDays[0] %></td>
                <td><%=PlateletDays[1] %></td>
                <td><%=PlateletDays[2] %></td>
                <td><%=PlateletDays[3] %></td>
                <td><%=PlateletDays[4] %></td>
            </tr>
            <tr>
                <td>현재 혈액 보유량</td>
                <td><%=PlateletTotals[0] %></td>
                <td><%=PlateletTotals[1] %></td>
                <td><%=PlateletTotals[2] %></td>
                <td><%=PlateletTotals[3] %></td>
                <td><%=PlateletTotals[4] %></td>
            </tr>
            <tr>
                <td>보유상태</td>
                <td><%=PlateletStocks[0] %></td>
                <td><%=PlateletStocks[1] %></td>
                <td><%=PlateletStocks[2] %></td>
                <td><%=PlateletStocks[3] %></td>
                <td><%=PlateletStocks[4] %></td>
            </tr>
        </tbody>
    </table>
    
    <a href="https://www.bloodinfo.net/bloodstats_stocks.do" class="btn btn-outline-secondary" >자세히보기</a>
    
    <br><br><br><br><br><br><br>
    </div>
    	<!-- footer.jsp include -->
	<%@ include file="../common/footer.jsp" %>
	
	
    <!-- Bootstrap.bundle.min.js -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
</html>