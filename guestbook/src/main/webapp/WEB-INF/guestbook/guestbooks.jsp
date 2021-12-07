<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
    <head>
        <title>방명록</title>
<%--         <link rel="stylesheet" href="${pageContext.request.contextPath}/style.css"  type="text/css" /> --%>
		<style type="text/css">
	        <%@ include file="style.css" %>
		</style>
    </head>
    <body>   	

        <div class="guestbooks split left">
            <c:forEach var="guestbook" items="${list}">
                <div class="guestbook item">
                    <div> <label>id : </label> ${guestbook.id}</div>
                    <div> <label>name : </label> ${guestbook.name}</div>
                    <div> <p>${guestbook.content}</p></div>
                    <div> <label>regdate : </label> ${guestbook.regdate}</div>
                </div>
            </c:forEach>
        </div>

        <br><br><br>
		
		<div class="formsection split right">
	        <form method="post" action="guestbooks/write">
	            이름 : <input type="text" name="name"><br>
	            내용 :
	            <textarea name="content" cols="50" rows="5"></textarea><br>
	            <input type="submit" value="확인">
	        </form>
		</div>
    </body>
</html>
