<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

		<h1>/members/join.jsp</h1>
		
		<fieldset>
			<legend>스프링MVC 회원가입</legend>
			<!-- action="/members/join" 주소 생략가능
				action 속성정보가 없으면 자기자신의 주소를 호출 -->
			<form method="post">
			아이디 : <input type="text" name="usrid">
			비밀번호 : <input type="password" name="usrpw">
			이름 : <input type="text" name="usrname">
			이메일 : <input type="text" name="usremail">

			<input type="submit" value="회원가입">
			</form>
		</fieldset>
</body>
</html>