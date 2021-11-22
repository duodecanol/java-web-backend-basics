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
	StringBuffer url = request.getRequestURL();
	out.print("url : " + url.toString());
	out.print("<br>");
	/*
	https://www.javatpoint.com/jsp-implicit-objects

	Object			Type
	-----------------------------------
	out				JspWriter
	request			HttpServletRequest
	response		HttpServletResponse
	config			ServletConfig
	application		ServletContext
	session			HttpSession
	pageContext		PageContext
	page			Object
	exception		Throwable
	*/
%>
</body>
</html>