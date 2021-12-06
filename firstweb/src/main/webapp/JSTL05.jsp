<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="http://localhost:8080/firstweb/JSTL_value.jsp" var="urlValue" scope="request" />
<c:import url="https://en.dict.naver.com/#/search"
	charEncoding="UTF-8"
	var = "naverDict"
	scope = "request">
	<c:param name="range" value="all" />
	<c:param name="query" value="dormant" />
</c:import>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL 05 - import</title>
</head>
<body>
${ urlValue } <br>
<b>${ urlValue }</b> <br>
${ urlValue } <br>
<%-- ${ naverDict } --%>

</body>
</html>