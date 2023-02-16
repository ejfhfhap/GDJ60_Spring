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
						<td><a href = "./detail?productnum=${dto.productnum}">${pageScope.dto.productname}</a></td>
						<td>${dto.productdetail}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		
		<div>
			<nav aria-label="Page navigation example">
			  <ul class="pagination">
			    <li class="page-item"><a class="page-link" href="./list?page=${pager.startNum - 1}&kind=${pager.kind}&search=${pager.search}">Previous</a></li>
					<c:forEach begin="${pager.startNum}" end="${pager.lastNum}" var="i" >
				    	<li class="page-item"><a class="page-link" href="./list?page=${i}&kind=${pager.kind}&search=${pager.search}">${i}</a></li>
					</c:forEach>
  			    <li class="page-item"><a class="page-link" href="./list?page=${pager.lastNum + 1}&kind=${pager.kind}&search=${pager.search}">Next</a></li>
			  </ul>
			</nav>
		</div>
			<form action="./list" method="get">
		  	  <div class="mb-3 row">
				<select name = "kind" class="form-select form-select-sm" aria-label=".form-select-sm example">
				  <option value="name">상품 이름으로 검색</option>
				  <option value="detail">상품 설명으로 검색</option>
				</select>
			  </div>
			  <div class="mb-3 row">
			    <label for="search" class="col-sm-2 col-form-label">내용</label>
			    <div class="col-sm-10">
			      <input name = "search" type="text" class="form-control" id="search">
			   </div>
			   <input type="submit" value="검색하기">
			 </form>
  		</div>
	</div>
	<a class="btn btn-danger" href="./productAdd">상품등록</a>
	<a class="btn btn-danger" href="./update">상품 업데이트</a>
	<a class="btn btn-danger" href = "./delete.do">member delete</a>

</body>
</html>