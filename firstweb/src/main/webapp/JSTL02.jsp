<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- request.setAttribute("n", 10); -->
<c:set var="n" scope="request" value="10"></c:set>
<c:set var="score" scope="request" value="88"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL 02</title>
</head>
<body>
n : ${ requestScope.n } <br>
<c:if test="${ n == 0 }">
	n과 0은 같습니다.
</c:if>
<c:if test="${ n == 10 }">
	n과 10은 같습니다.
</c:if>
<br><br><br>

score : ${ requestScope.score } <br>
<c:choose>
	<c:when test="${ score >= 90 }">
		A학점 입니다.
	</c:when>
	<c:when test="${ score >= 80 }">
		B학점 입니다.
	</c:when>
	<c:when test="${ score >= 70 }">
		C학점 입니다.
	</c:when>
	<c:when test="${ score >= 60 }">
		D학점 입니다.
	</c:when>
	<c:otherwise>
		F학점 입니다.
	</c:otherwise>
</c:choose>
</body>
</html>