<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="../include/header.jsp"%>

<h1>/board/listAll.jsp</h1>

${result }

<div class="box">
	<div class="box-header with-border">
		<h3 class="box-title">ITWILL 게시판</h3>
	</div>

	<div class="box-body">
		<table class="table table-bordered">
			<tbody>
				<tr>
					<th style="width: 10px">BNO</th>
					<th>TITLE</th>
					<th>WRITER</th>
					<th>REGDATE</th>
					<th style="width: 40px">VIEWCNT</th>
				</tr>
				
				<c:forEach var="vo" items="${boardList }">
					<tr>
						<td>${vo.bno }</td>
						<td>
						<a href="/board/read">${vo.title }</td>
						<td>${vo.writer }</td>
						<td>
						<fmt:formatDate value="${vo.regdate }" dateStyle="short" pattern="yy-MM-dd"/>
						</td>
						<td><span class="badge bg-orange">${vo.viewcnt }</span></td>
					</tr>
				</c:forEach>
				
			</tbody>
		</table>
	</div>

	<div class="box-footer clearfix">
		<ul class="pagination pagination-sm no-margin pull-right">
			<li><a href="#">«</a></li>
			<li><a href="#">1</a></li>
			<li><a href="#">2</a></li>
			<li><a href="#">3</a></li>
			<li><a href="#">»</a></li>
		</ul>
	</div>
</div>


<script type="text/javascript">
	// JSP(java) / JSTL,EL / HTML / JavaScript
	// alert("${result}");
	var result = "${result}";
	
	if(result == "CREATEOK"){
		alert("글 쓰기 완료!");
	}
</script>


<%@ include file="../include/footer.jsp"%>
