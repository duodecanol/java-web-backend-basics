<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
	int total = 0;
	for (int i = 1; i <= 10; i++) {
		total = total + 1;
	}
%>

1부터 10까지의 합 : <%=total %>
<!-- "C:\Users\Administrator\eclipse-workspace\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\work\Catalina\localhost\firstweb\org\apache\jsp\sum10_jsp.java" -->
</body>
</html>