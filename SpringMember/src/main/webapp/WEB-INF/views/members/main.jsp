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
	<h1>/members/main.jsp</h1>
	<!-- 로그인 여부(세션정보)에 따라서 페이지 이동 (JSTL) -->
	
	<%-- <c:if test="${sessionScope.id == null }"> --%>
	<c:if test="${ empty id }">
	   <c:redirect url="/members/login"/>	
	</c:if>
	
	
	<h2>${id } 님 안녕하세요!</h2>
	
	<input type="button" value="로그아웃" onclick=" location.href='/members/logout'; ">
	<a href="javascript:location.href='/members/logout';"> 로그아웃 </a>
	
	<hr>
	
	<h3><a href="/members/info">회원정보 조회 (info)</a></h3>
	
	<h3><a href="/members/update">회원정보 수정 (update)</a></h3>
	
	<h3><a href="/members/delete">회원정보 삭제 (delete)</a></h3>
	
	<!-- 관리자만 볼수있게 제어 -->
	<c:if test="${ !empty id && id.equals('admin') }">
		<!-- 관리자(admin)전용 메뉴 -->
		<h3><a href="/members/list">회원정보 목록 (List)</a></h3>
	</c:if>
	
	

</body>
</html>