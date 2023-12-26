<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<h1>fileResult.jsp</h1>
		${paramMap }<hr>
		<h2> 아이디 : ${paramMap.userid } </h2>
		<h2> 이름 : ${paramMap.username } </h2>
		<c:forEach var="fileName" items="${paramMap.fileList }">
		    <h2> 파일명 : <a href="/download?fileName=${fileName }">${fileName }</a></h2>
		
		<hr>
		<img src="/download?fileName=${fileName }">
		</c:forEach>
		
		<a href="/fileUpload">다시 업로드 하기</a>

</body>
</html>