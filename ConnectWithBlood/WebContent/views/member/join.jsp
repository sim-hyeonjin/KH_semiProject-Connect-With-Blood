<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset='utf-8'>
    <meta http-equiv='X-UA-Compatible' content='IE=edge'>
    <title>회원가입 약관</title>
    <meta name='viewport' content='width=device-width, initial-scale=1'>

       


    <style>
    .inner{
        position: absolute;
        padding: 150px;
    }

        .h{text-align: center;}
        #smallH{color: darkred;}
        fieldset>textarea, input, label{text-align: center; width: auto;}
        #b{
            margin: auto; 
        }
        #outform{
            margin:auto;
        }
        #agreeBox{
            border: dashed gray; padding: 20px;
            text-align: center;
        }
        #innerBox{
            border: dashed gray;
            padding: 20px;
            text-align: left; 
            
        }
        #bTop{
            text-align: left;
            float: left;
            border: none;
        }
        #content{
            clear: both;
        }
        #box{
            width: auto;
            display: inline-block;
            text-align: center;
        }
        textarea{width: 550px;}

        
        #userId{
            float: left;
            
        }
        #iinner{
        	padding:auto;
        	text-align:center;
        }
        #btn1{text-align:center;}

        
    </style>
</head>

<body>

	<!-- header.jsp include -->
    <%@ include file="../common/header.jsp" %>
    
    
    
<br><br><br>



<div style="width:600px; margin:auto;">
            <h1 class="modal-title">개인정보 기입사항</h1> <br>
            <form action="<%=contextPath%>/join.mem" id="inputFrom" method="post">
                <fieldset id="innerBox" >
                <div class="fieldlabel"><label for="userId">* 아이디</label></div>
                <input type="text" id="userId" name="userId" maxlength="20"></input>
                &nbsp;&nbsp;
                <button type="button" class="btn btn-outline-danger" name="idCheck" id="idCheck" onclick="idCheck22();">아이디 중복 체크</button>
        
        <script>
        function idCheck22(){
            var $userId = $("#inputFrom input[name=userId]");
            //var userId=$('#userId').val();

            $.ajax({
                url : "<%=contextPath%>/idCheck.mem",
                type:"post",
                data : {idCheck :  $userId.val()},
                success : function(result){
                	if(result=="NNNNN"){ 
                		alert("이미 존재하거나 탈퇴한 회원의 아이디입니다.")
                		$userId.focus(); 
                	}else{ 
                        if(confirm("사용가능한 아이디입니다")){
                            $userId.attr("readonly",true); 
                		}else{
                            $userId.focus();
                        }
                	}
                },
                error : function(){
                    alert("서버요청 실패");
                }
            })
        };
        </script>
        
        
        
                <br><br>
                <div class="fieldlabel"><label for="userPw" id="userPw">* 패스워드</label></div>
                <div class="formfield">
        <input type="password" id="userPw" name="userPw" maxlength="20" autocomplete="off">
        </div>
                
                 <br>
                <div class="fieldlabel"><label for="userName">* 이름</label></div>
                <div class="formfield"><input type="text" id="userName" name="userName" maxlength="20" value=""></div>
        
                <br>

                <div class="fieldlabel"><label for="userBirth">* 주민등록번호(-포함하여 작성)</label></div>
                <div class="formfield"><input type="text" id="userBirth" name="userBirth" maxlength="20" value=""></div>
        
                
                <br>
                <div class="fieldlabel"><label for="address">* 주소</label></div>
                <div class="formfield"><input type="text" id="address" name="userAddress" maxlength="40" value=""></div>
        
                <br>
                <div class="fieldlabel"><label for="email01">* 이메일</label></div>
                <div class="formfield">
                <input type="text" id="email" name="email" size="20" maxlength="20" value="" autocomplete="off">
                     <span>@</span>
                    
                    <select id="Edomains" name="Edomains">
                        <option value="naver.com" name="Edomains">naver.com</option>
                        <option value="daum.net" name="Edomains">daum.net</option>
                        <option value="gmail.com" name="Edomains">gmail.com</option>
                        <option value="yahoo.co.kr" name="Edomains">yahoo.co.kr</option>
                    </select>

                    <script>
                        $('input[name="email"]').on('click',function(){
                            var email = $(this).val();
                            });
                        
                        $('input[name="Edomains"]').on('click',function(){
                            var Edomains = $(this).val();
                            });
                       </script>

                </div><br>
                
                <div class="fieldlabel"><label for="mPhone1">* 연락처</label></div>
                <div class="formfield">
                    <select id="mPhone1" name="mPhone1">
                        <option value="010" name="mPhone1">010</option>
                        <option value="011" name="mPhone1">011</option>
                        <option value="016" name="mPhone1">017</option>
                    </select>-
                    <input id="mPhone2" name="mPhone2" type="number" value="" size="4" maxlength="4" autocomplete="off" style="width: 100px">-
                    <input id="mPhone3" name="mPhone3" type="number" value="" size="4" maxlength="4" autocomplete="off" style="width: 100px">
                </div> <br>

                <script>
                    $('input[name="mPhone1"]').on('click',function(){
                        var mPhone1 = $(this).val();
                        });
                    
                    $('input[name="mPhone2"]').on('click',function(){
                        var mPhone2 =$(this).val() ;
                        });
                    $('input[name="mPhone3"]').on('click',function(){
                        var mPhone3 =$(this).val() ;
                        });
                   </script>



        
                <br>
                <div class="blood_abo"><label>* 혈액형 타입</label> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    <select name="blood2" id="blood2">
                        <option value="A형">A형</option>
                        <option value="B형">B형</option>
                        <option value="AB형">AB형</option>
                        <option value="O형">O형</option>
                    </select>
        
                <br>
                </div>
                <div class="blood_rh"> <label>* RH형 타입</label> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    <input type="radio" name="blood1" value="RH+" alt="blood1" checked >RH+
                    <input type="radio" name="blood1" value="RH-" alt="blood1">RH-
                </div>
        
                <br>
        
                <!-- <div class="fieldlabel"><label>- 성별</label></div>
                <div class="formfield">
                    <input type="radio" name="sex" value="no" alt="no" checked >선택안함 &nbsp;
                    <input type="radio" name="sex" value="남" alt="남자" checked >남자 &nbsp;
                    <input type="radio" name="sex" value="여" alt="여자" >여자
                </div> -->
                
                
                
                
                
                
          </fieldset>
          
             <br>
        
     <script>
     $('input[name="blood1"]').on('click',function(){
    	 var blood1 = $(this).val();
    	 });
     
     $('input[name="blood2"]').on('click',function(){
    	 var blood2 =$(this).val() ;
    	 // 예시 : var userId = $("#userId").val()
    	 });
    </script>
        
                <script>
                    function joinAlert(){
                        alert("회원가입을 축하합니다!");
                    }
                </script>
                
                <div class="btn1" style="text-align:center;">
                    <input type="submit" value="회원가입" class="btn btn-danger btn-block" id="joinBtn" style="width:200px;" onclick="joinAlert();">
            		<a type="button" class="btn btn-light" href="<%=contextPath%>">닫기</a>
                </div>
     </form>
            
            
            
            
            
                
 </div>








    
        <br><br><br><br><br>
        <!-- footer.jsp include -->
        <%@ include file="../common/footer.jsp" %>


        

</body>
</html>