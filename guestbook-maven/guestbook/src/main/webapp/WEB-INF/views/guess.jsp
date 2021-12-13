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
  
  <form method="post" action="write">
    name: <input type="text" name="name"><br>
    <textarea name="content" rows="6" cols="60"></textarea>
    <br> <input type="submit" value="register">
  </form>

</body>


</html>