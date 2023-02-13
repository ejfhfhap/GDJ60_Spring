<%@page import="com.iu.s1.product.ProductDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../resources/css/table.css">
<c:import url="../template/common_css.jsp"></c:import>

</head>
<body>

	<c:import url="../template/header.jsp"></c:import>
	<h1>Product List</h1>

	<hr>
	<div class = "row col-6 ms-3">
		<table class="tb1 table table-striped-columns">
			<thead>
				<tr>
					<th>상품명</th>
					<th>평점</th>
				</tr>
			</thead>
			
			<tbody>
				<c:forEach items="${list}" var="dto">
					<tr>
						<td><a href = "./detail?productnum=${dto.productnum}">${pageScope.dto.productnum}</a></td>
						<td>${dto.productjumsu}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<a class="btn btn-danger" href="./productAdd">상품등록</a>
	<a class="btn btn-danger" href="./update">상품 업데이트</a>
	<a class="btn btn-danger" href = "./delete.do">member delete</a>

</body>
</html>