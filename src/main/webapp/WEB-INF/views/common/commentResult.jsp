<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
 <div class="row">
	<table class="table table-striped-columns">
		<tbody class ="row col-md-5">
			<c:forEach items="${dtos}" var="dto" varStatus="i">
				<%-- <c:if test="${i.first }">sadfsdf</c:if> --%>
				<tr>
					<td id="content${dto.num}">${dto.contents}</td>
					<td>${dto.regDate}</td>
					<td>${dto.writer}</td>
					<td>
						<c:if test="${member.id eq dto.writer}">
							<button type="button" class="btn btn-danger del" data-commentId-del="${dto.num}">DELETE</button>
						</c:if>
					</td>
					<td>
						<!-- <c:if test="${member.id eq dto.writer}">
							<button type="button" class="btn btn-danger" data-commentId-del="${dto.num}">UPDATE</button>
						</c:if> -->
						<button type="button" class="btn btn-danger viewUpdateForm" data-commentNum = "${dto.num}" data-bs-toggle="modal" data-bs-target="#contentModal">UPDATE</button>
					</td>
				</tr>



			</c:forEach>
		</tbody>
	</table>
</div>

<div class = "row">
  	 <nav aria-label="Page navigation example">
	  <ul class="pagination">
	  	<li class="page-item">
	      <a class="page-link page" href="#" aria-label="Previous" data-board-page="1">
	        <span aria-hidden="true">&lsaquo;</span>
	      </a>
	    </li>
	    
	    <li class="page-item ${pager.before?'disabled':''}">
	      <a class="page-link page" href="#" aria-label="Previous" data-board-page="${pager.startNum - 1}">
	        <span aria-hidden="true">&laquo;</span>
	      </a>
	    </li>
	    <c:forEach begin="${pager.startNum}" end="${pager.lastNum}" var="i" >
				<li class="page-item"><a class="page-link page" href="#" data-board-page="${i}">${i}</a></li>
	    </c:forEach>


	    <li class="page-item ${pager.after eq false ? 'disabled' : ''}">
	      <a class="page-link page" href="#" aria-label="Next" data-board-page="${pager.lastNum + 1}">
	        <span aria-hidden="true">&raquo;</span>
	      </a>
	    </li>
	    <li class="page-item">
	      <a class="page-link" href="#" aria-label="Next">
	        <span class="page" aria-hidden="true" data-board-page="${pager.totalPage}">&rsaquo;</span>
	      </a>
	    </li>
	  </ul>
	</nav>
</div>