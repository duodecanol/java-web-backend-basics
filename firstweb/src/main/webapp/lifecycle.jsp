<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
Hello~~~~
<% // scriptlet
	System.out.print("jspService()");
%>

<%! //declaration
	public void jspInit() {
		System.out.print("jspInit()!!!");
	}
%>
<%! //declaration
	public void jspDestroy() {
		System.out.print("ㅠㅠㅠㅠㅠjspDestroy()");
		System.out.print("\n");
	}
%>

</body>
</html>