<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%-- <c:redirect url="http://localhost:8080/firstweb/JSTL_value.jsp"></c:redirect> --%>
<c:redirect url="https://en.dict.naver.com/#/search">
	<c:param name="range" value="all" />
	<c:param name="query" value="dormant" />
</c:redirect>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>