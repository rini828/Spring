<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	  <h1>http://localhost:8088/members/delete 호출</h1>
	  <h1>/views/members/delete.jsp</h1>
	  
	  <fieldset>
	    <legend> 회원탈퇴 </legend>
	    <form action=""  method="post">
<!-- 	    	아이디 : <input type="text" name="userid"><br> -->
			<input type="hidden" name="userid" value="${id }">
			 비밀번호 : <input type="password" name="userpw"><br>
	    	<input type="submit" value=" 회원탈퇴 ">
	    </form>	  
	  </fieldset>
	  
	  
</body>
</html>