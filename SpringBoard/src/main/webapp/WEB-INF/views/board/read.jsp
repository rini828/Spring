<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../include/header.jsp"%>

<h1>/board/read.jsp</h1>

<!-- 본문보기 시작-->
<div class="box box-primary">
	<div class="box-header with-border">
		<h3 class="box-title">ITWILL 게시판 본문보기</h3>
	</div>

	<form role="form" method="post"> 
		<input type="hidden" name="bno" value="${resultVO.bno }">
	</form>
	
		<div class="box-body">
			<div class="form-group">
				<label for="exampleInputEmail1">작성자</label>
				 <input type="text" class="form-control" id="exampleInputEmail1" name="writer"
				        value ="${resultVO.writer }" readonly="readonly">
			</div>
			<div class="form-group">
				<label for="exampleInputEmail1">제  목</label>
				 <input type="text" class="form-control" id="exampleInputEmail1" name="title"
				        value="${resultVO.title }" readonly >
			</div>
			<div class="form-group">
				<label for="exampleInputEmail1">내  용</label>
				<textarea class="form-control" rows="3" 
				             name="content" readonly="readonly">${resultVO.content }</textarea>
			</div>

		</div>

		<div class="box-footer">
			<button type="button" class="btn btn-warning">수정</button>
			<button type="submit" class="btn btn-danger">삭제</button>
			<button type="submit" class="btn btn-primary">목록</button>
		</div>
	
</div>

<!-- 본문보기 끝 -->

<script type="text/javascript">
 	$(document).ready(function(){
 		
 		//목록 버튼 클릭시 목록으로 페이지 이동
 		$(".btn-primary").click(function(){
 			location.href='/board/listAll'; 			
 		});
 		
 		var formObj = $('form[role="form"]');
 		//alert(formObj);
 		console.log(formObj);
 		
 		// 수정 버튼 클릭시, 글번호 정보를 가지고 submit
 		// 이동하는 페이지주소 변경, 전달방식 변경POST->GET 
 		$(".btn-warning").click(function(){
 			formObj.attr("action","/board/modify");
 			formObj.attr("method","GET");
 			formObj.submit(); 			
 		});
 		
 		// 삭제 버튼 클릭시, 글번호를 사용해서 삭제 처리
 		$(".btn-danger").click(function(){
 			formObj.attr("action","/board/remove");
 			formObj.submit();
 		});
 		
 		
 		
 	});

</script>



<%@ include file="../include/footer.jsp"%>
