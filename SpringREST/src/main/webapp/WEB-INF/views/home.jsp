<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" pageEncoding="UTF-8"%>
<html>
<head>
	<title>Home</title>
	<script src="https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.min.js"></script>
	<script type="text/javascript">
	   $(document).ready(function(){
		  
		   //버튼 클릭시
		   $("#btnSend").click(function(){
			   
			   // 리소스를 생성해서 전달(비동기방식)
			   var member = {
				    /* "userid":$("요소").val(), */
				    "userid":"admin",
				    "userpw":"1234",
				    "username":"관리자",
				    "useremail":"admin@admin.com"
			   };
			   
			   $.ajax({
				   url : "/sample/info",
				   type : "POST",
				   contentType : "application/json",
				   data : JSON.stringify(member), //json타입문자열로 전송
				   success:function(data){
						alert('/sample/info 다녀옴!');
						$('body').append(data);
				   },
				   error:function(){
					   alert(" 실패! ");
				   }
			   });//ajax
			   
		   });//click
		   
	   });//ready
	
	</script>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>
<hr>

<input type="button" value="정보 전송하기" id="btnSend">

</body>
</html>
