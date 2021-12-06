<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="value1" scope="request" value="kang"></c:set>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL 01</title>
</head>
<body>
<h2>JSTL (JSP Standard Tag Library)</h2>
성: ${ value1 } <br>
<c:remove var="value1" scope="request"></c:remove>

성: ${ value1 } <br>
</body>
</html>