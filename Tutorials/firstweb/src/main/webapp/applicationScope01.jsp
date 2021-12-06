<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	try {
		int value = (int)application.getAttribute("value");			
		value++; // increase the value by 1
		value++; // increase the value by 1
		application.setAttribute("value", value);
%>
		<h1><%=value %></h1>
<%		
	} catch (NullPointerException e) {
%>
		<h1>Value is not set.</h1>
<%
	}
%>

</body>
</html>
