<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		 <h1>itwill.jsp</h1>
		 
		 <h2> 전달된 msg 정보를 출력 </h2>
		 
		 jsp : <%=request.getParameter("msg") %> <hr>
		 el : ${param.msg }<hr>
		 <h2> modelAttribute 어노테이션을 사용하여 정보를 전달 -> el표현식 출력 </h2>
		 spring - el : ${requestScope.msg }<hr>
		 spring - el : ${msg }<hr>
		 
		 ${age }
</body>
</html>