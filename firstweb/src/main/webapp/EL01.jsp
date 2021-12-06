<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
	pageContext.setAttribute("p1", "page scope value");
	request.setAttribute("r1", "request scope value");
	session.setAttribute("s1", "session scope value");
	application.setAttribute("a1", "application scope value");
%>
<html>
<head>
<meta charset="UTF-8">
<title>Expression Language 01</title>
</head>
<body>
<h4>pageContext.getAttribute("p1") : <%=pageContext.getAttribute("p1") %></h4>
<h4>pageScope.p1 : ${ pageScope.p1 } </h4>
<h4>request.getAttribute("r1"): ${ requestScope.r1 } </h4>
<h4>session.getAttribute("s1"): ${ sessionScope.s1 } </h4>
<h4>application.getAttribute("a1"): ${ applicationScope.a1 } </h4><br>

pageContext.getAttribute("p1") : ${ p1 }<br> 
request.getAttribute("r1") : ${ r1 }<br>
session.getAttribute("s1") : ${ s1 }<br>
application.getAttribute("a1") : ${ a1 } <br>
</body>
</html>