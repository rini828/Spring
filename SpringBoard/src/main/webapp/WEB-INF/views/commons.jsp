<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<h1>/views/commons.jsp</h1>
		<h2> 예외발생!!! </h2>
		
		<hr>
		${e.getMessage() }
		
		<hr>
		${e }
		
		<h3><a href="/board/listAll">목록 페이지로 이동</a></h3>
		
		<%
		   //response.addHeader("Refresh", "5; url='/board/listAll");
		%>
		
		
</body>
</html>