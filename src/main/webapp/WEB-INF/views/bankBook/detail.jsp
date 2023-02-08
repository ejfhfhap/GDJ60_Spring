<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>detail page</h2>
	
	<c:if test="${not empty bankBookDTO.bookNumber}">
		<h2>bookNumber = ${bankBookDTO.bookNumber}</h2>
		<h2>bookName = ${bankBookDTO.bookName }</h2>
		<h2>bookRate = ${bankBookDTO.bookRate}</h2>
		<h2>bookSale = ${bankBookDTO.bookSale}</h2>
		<h2>bookDetail = ${bankBookDTO.bookDetail}</h2>
		<a href = "./delete?bookNumber=${bankBookDTO.bookNumber}">삭제</a>
	</c:if>
	<c:if test="${empty bankBookDTO.bookNumber}">
		<h4>데이터가 없습니다!!</h4>
	</c:if>
	
	<a href ="./list">목록으로</a>
</body>
</html>