<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>저축상품</title>
	<c:import url="../template/common_css.jsp"></c:import>
	<link rel="stylesheet" href="./resources/css/table.css">
	
</head>
<body> 
		<c:import url="../template/header.jsp"></c:import>
		
	<div class="container-fluid my-5">
		
		<div class="row mb-4">
			<h2 class="col-md-7 mx-auto text-center border-bottom border-dark pb-4">list Page</h2>
		</div>
		
		<div class="row col-md-7 mx-auto">	
		<table class="table table-hover">
	         <thead>
	             <tr>
	                 <th>bookNumber</th>
	                 <th>bookName</th>
	                 <th>bookRate</th>
	                 <th>bookSale</th>
	                 <th>bookDetail</th>
	             </tr>
	         </thead>
	         <tbody class = "table-group-divider">
	           	<c:forEach items="${bankBookDTOs}" var="dto">
	                 <tr>
	               		<td class = "bor_ri">${dto.bookNumber}</td>
	               		<td class = "bor_ri"><a href ="./detail?bookNumber=${dto.bookNumber}">${dto.bookName}</a></td>
	               		<td class="tdl_td bor_ri">${dto.bookRate}</td>
	               		<td class="tdl_td bor_ri">
	               			<%-- <c:if test="${dto.bookSale eq 1}">판매중</c:if>
	               			<c:if test="${dto.bookSale eq 0}">판매중단</c:if>  --%>
	               			
	               			<c:choose>
	               				<c:when test="${dto.bookSale eq 1}">판매중</c:when>
	               				<c:when test="${dto.bookSale eq 0}">판매중단</c:when>
	               				<c:otherwise></c:otherwise>
	               			</c:choose>
	               		</td>
	               		
	               		<td>${dto.bookDetail}</td>
	          		 </tr>
				</c:forEach>
	         </tbody>
	         
	        
	     </table>
	     
	     <!-- pagining -->
	      <div class = "row">
		        	 <nav aria-label="Page navigation example">
					  <ul class="pagination">
					  	<li class="page-item">
					      <a class="page-link" href="./list?page=1&kind=${pager.kind}&search=${pager.search}" aria-label="Previous">
					        <span aria-hidden="true">&lsaquo;</span>
					      </a>
					    </li>
					    
					    <li class="page-item ${pager.before?'disabled':''}">
					      <a class="page-link" href="./list?page=${pager.startNum - 1}&kind=${pager.kind}&search=${pager.search}" aria-label="Previous">
					        <span aria-hidden="true">&laquo;</span>
					      </a>
					    </li>
					    <c:forEach begin="${pager.startNum}" end="${pager.lastNum}" var="i">
    						    <li class="page-item"><a class="page-link" href="./list?page=${i}&kind=${pager.kind}&search=${pager.search}">${i}</a></li>
					    </c:forEach>


					    <li class="page-item ${pager.after eq false ? 'disabled' : ''}">
					      <a class="page-link" href="./list?page=${pager.lastNum + 1}&kind=${pager.kind}&search=${pager.search}" aria-label="Next">
					        <span aria-hidden="true">&raquo;</span>
					      </a>
					    </li>
					    <li class="page-item}">
					      <a class="page-link" href="./list?page=${pager.totalPage}&kind=${pager.kind}&search=${pager.search}" aria-label="Next">
					        <span aria-hidden="true">&rsaquo;</span>
					      </a>
					    </li>
					  </ul>
					</nav>
			</div>
				
				<!-- 검색창 -->
				<div class = "row">
					  <form class="row g-3" action="./list" method="get">
						  <div class="col-auto">
						    <label for="kind" class="visually-hidden">Kind</label>
						    <select name="kind" class="form-select" id="kind" aria-label="Default select example">
							  <option value="title">상품명</option>
							  <option value="content">상품내용</option>
							</select>
						  </div>
						  <div class="col-auto">
						    <label for="search" class="visually-hidden">Search</label>
						    <input type="text" class="form-control" name="search" id="search" placeholder="검색어를 입력 하세요.">
						  </div>
						  <div class="col-auto">
						    <button type="submit" class="btn btn-primary mb-3">검색</button>
						  </div>
					</form>
				</div>
	     </div>
         <div class = "row col-md-7 mx-auto">
   	     	<a href="./add" class="col-3">상품등록</a>
    	 </div>
     </div>

     <c:import url="../template/common_js.jsp"></c:import>
</body>
</html>