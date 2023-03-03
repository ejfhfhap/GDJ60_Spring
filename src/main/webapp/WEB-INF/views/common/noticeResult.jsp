<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
 <div class="row">
	<table class="table table-hover">
		<tbody class ="row col-md-5">
			<c:forEach items="${dtos}" var="dto" varStatus="i">
				<c:if test="${i.first }">sadfsdf</c:if>
				<tr>
					<td>${dto.num}</td>
					<td>		
						<a href = "./detail?num=${dto.num}">${dto.title}</a>
					</td>
					<c:if test="${boardName eq 'notice'}"><td>관리자</td></c:if>
					<c:if test="${boardName eq 'qna'}"><td>${dto.writer}</td></c:if>
					<td>${dto.regDate}</td>
					<td>${dto.hit}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>