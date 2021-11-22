<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- JPS 주석입니다!!!
	여러 줄로 사용 가능합니다.
 --%>
<!-- html 주석입니다. -->
<%
// 자바 주석입니다.
/*
여러 줄도 가능
합니다.
*/
	for (int i = 1; i <= 5; i++) {

%>
<H<%=i %>>아름다운 한글</H>
<%		
	}
%>

</body>
</html>