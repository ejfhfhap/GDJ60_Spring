<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../template/common_css.jsp"></c:import>
</head>
<body>

	<h2>detail page</h2>
	
	<c:if test="${not empty bankBookDTO.bookNumber}">
		<h2>bookNumber = ${bankBookDTO.bookNumber}</h2>
		<h2>bookName = ${bankBookDTO.bookName }</h2>
		<h2>bookRate = ${bankBookDTO.bookRate}</h2>
		<h2>bookSale = ${bankBookDTO.bookSale}</h2>
		<h2>bookDetail = ${bankBookDTO.bookDetail}</h2>
		
		<div>
			<c:if test="${not empty bankBookDTO.bankBookImgDTO}">
				<img src="../resources/upload/bankBook/${bankBookDTO.bankBookImgDTO.fileName}">
			</c:if>
		</div>
		
		<a href = "./delete?bookNumber=${bankBookDTO.bookNumber}">삭제</a>
		<a href = "./update?bookNumber=${bankBookDTO.bookNumber}">업데이트</a>
	</c:if>
	<c:if test="${empty bankBookDTO.bookNumber}">
		<h4>데이터가 없습니다!!</h4>
	</c:if>
	
	<a href ="./list">목록으로</a>

	<!--  작성자 내용 작성일 -->
	<div class="my-5" id="commentList"> 

	</div>

	<div>
		<input type="hidden" id="bookNumber" value="${bankBookDTO.bookNumber}">
		<div class="mb-3">
			<textarea class="form-control" id="contents" rows="3"></textarea>
		</div>
		<button type="button" class="btn btn-primary mb-3" id="submit">댓글작성</button>
	</div>

	<!-- Button trigger modal
	<button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#contentModal">
		Launch demo modal
	</button> -->
	
	<!-- Modal -->
	<div class="modal fade" id="contentModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
			<h1 class="modal-title fs-5" id="exampleModalLabel">Modal title</h1>
			<button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
			</div>
			<div class="modal-body">
				<div class="form-floating">
					<textarea class="form-control" placeholder="Leave a comment here" id="contentss"></textarea>
					<label for="contentss">Comments</label>
				  </div>
			</div>
			<div class="modal-footer">
			<button type="button" class="btn btn-secondary" data-bs-dismiss="modal" id="modalClose">Close</button>
			<button type="button" class="btn btn-primary" id="contentsConfirm" data-comment-num ="">확인</button>
			</div>
		</div>
		</div>
	</div>


	<script src="/resources/js/bankBookReplay.js"></script>
	<c:import url="../template/common_js.jsp"></c:import>
</body>
</html>