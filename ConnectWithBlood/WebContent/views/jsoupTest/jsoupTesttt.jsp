<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="jsoup.JsoupTest"%>
    
<%
	JsoupTest j = new JsoupTest(); 
	String[] c = j.a();
%>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%-- <%@import file="" %> --%>

<%-- 	<%=JsoupTest.main(args) %> --%>

	<%=c[2] %>

</body>
</html>