<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.min.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		
		var cnt = 1;
		
		// 버튼 클릭시 파일입력 버튼 추가(input태그 이름변경)
		$("#addBtn").click(function(){
			$("#fileDiv").append("<input type='file' name='file"+cnt+"'>");
			cnt++;
		});
		
	});

</script>

</head>
<body>
		<h1>http://localhost:8088/fileUpload 호출 </h1>
		<h1>/views/fileUpload.jsp</h1>
		
		<fieldset>
			<legend> 다중파일 업로드 </legend>
			<form action="/upload" method="post" enctype="multipart/form-data">
				아이디 : <input type="text" name="userid"> <br>
				이름 : <input type="text" name="username"> <hr>
				<input type="button"  value="파일 추가" id="addBtn"><br>
				
				<div id="fileDiv"></div>
				
			    <hr>
			    <input type="submit" value=" 파일 업로드 ">
			</form>		
		</fieldset>
		
		
		
</body>
</html>