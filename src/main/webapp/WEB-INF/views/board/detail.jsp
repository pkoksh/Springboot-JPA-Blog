<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../layout/header.jsp"%>
<div class="container">
	<div>
		<button class="btn btn-secondary" onclick="history.back()">돌아가기</button>
		<button id="update" class="btn btn-warning">수정</button>
		<button id="delete" class="btn btn-danger">삭제</button>
	</div>
	<div class="form-group">
		<h3>${board.title }</h3> 
		
	</div>
	<div class="form-group">
		<div>
			${board.content }
		</div>
	</div>
</div>
<script src="/js/board.js"></script>
<%@include file="../layout/footer.jsp"%>


