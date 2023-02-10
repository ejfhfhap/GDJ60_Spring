<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../resources/css/table.css">
</head>
<body> 
	<h2 class="title">list Page</h2>
	<div class="image">
		<img src="../resources/images/hanna.jpg" alt="">
	</div>

	<table class="tb2">
         <thead>
             <tr>
                 <th>bookNumber</th>
                 <th>bookName</th>
                 <th>bookRate</th>
                 <th>bookSale</th>
                 <th>bookDetail</th>
             </tr>
         </thead>
         <tbody>
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
     <a href="./add">상품등록</a>
</body>
</html>