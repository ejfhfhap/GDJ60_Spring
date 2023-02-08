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
	<table border="1">
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
               		<td>${dto.bookNumber}</td>
               		<td><a href ="./detail?bookNumber=${dto.bookNumber}">${dto.bookName}</a></td>
               		<td>${dto.bookRate}</td>
               		<td>
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