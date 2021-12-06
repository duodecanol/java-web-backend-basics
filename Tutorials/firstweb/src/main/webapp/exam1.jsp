<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%!
	String id = "u001"; // 멤버변수 선언
	public String getId() { // 메서드 선언
		return id;
	}
%>

id : <%=getId() %>

</body>
</html>