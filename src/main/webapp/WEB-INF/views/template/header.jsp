<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<nav class="navbar bg-dark navbar-expand-lg bg-body-tertiary" data-bs-theme="dark">
  <div class="container-fluid">
  	<a class=navbar_brand href = "/"><img src="/resources/images/logo.png" alt=""></a>
  	<button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarScroll" aria-controls="navbarScroll" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarScroll">
    	<ul class="navbar-nav me-auto mb-2 mb-lg-0">
			<li class="nav-item"><a class="nav-link active" href = "#">공지사항</a></li>
			<li class="nav-item"><a class="nav-link active" href = "/product/list">제품</a></li>
			<li class="nav-item"><a class="nav-link active" href = "/bankBook/list">저축상품</a></li>
			<li class="nav-item"><a class="nav-link active" href = "#">기타메뉴</a></li>
		</ul>
		
		<ul class="navbar-nav">
			
			<c:if test="${empty member}">
				<li class="nav-item"><a class="nav-link fs-6" href = "/member/memberLogin">Login</a></li>
				<li class="nav-item"><a class="nav-link" href = "/member/memberAgree">Join</a></li>
			</c:if>
			<c:if test="${not empty member}">
				<li class="nav-item"><a class="nav-link fs-6" href = "/member/memberPage">MyPage</a></li>
				<li class="nav-item"><a class="nav-link" href = "/member/memberLogout">Logout</a></li>
			</c:if>

			
			<li class="nav-item"><a class="nav-link" href = "#">Ko</a></li>
			<li class="nav-item"><a class="nav-link" href = "#">En</a></li>
			<li class="nav-item"><a class="nav-link" href = "#">Jp</a></li>
			<li class="nav-item"><a class="nav-link" href = "#">Cn</a></li>
		</ul>
    </div>
  </div>
</nav>

