<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>숫자 맞추기</title>
</head>

<body>
  <h1>1 ~ 100 사이의 숫자를 맞춰보세요</h1>
  <hr>
  <h3>${ message }</h3>

  <c:choose>
    <c:when test="${ sessionScope.count != null }">
      <form method="get" action="guess">
        1~100 의 숫자를 맞춰보세요! <br> <input type="text" name="number"><br> <input type="submit" value="확인">
      </form>
    </c:when>
    <c:otherwise>
      <br>
      <input type="button" value="돌아가기" onclick="location.href='guess'">
    </c:otherwise>
  </c:choose>

</body>


</html>