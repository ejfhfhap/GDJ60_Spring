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
	<c:import url="../template/header.jsp"></c:import>
	
	<h2>member add page</h2>
	<div class="container">
		<form class="row justify-content-center" action="./memberJoin" method="post">
		
			   <label for="inputId" class="form-label">ID</label>
			   <input name = "id" type="text" id="inputId" class="form-control" aria-describedby="idHelpBlock">
			   <div id="idHelpBlock" class="form-text">
				  id를 입력 해 주세요
			   </div>
			   
			   <label for="inputPw" class="form-label">PW</label>
			   <input name = "pw" type="password" id="inputPw" class="form-control" aria-describedby="pwHelpBlock">
			   <div id="pwHelpBlock" class="form-text">
				 pw를 입력 해 주세요
			   </div>
			   
			   <label for="inputName" class="form-label">NAME</label>
			   <input name = "name" type="text" id="inputName" class="form-control" aria-describedby="nameHelpBlock">

	          
			   <div class="form-outline mb-3" style="width: 100%">
			     <label class="form-label" for="phone">PHONE</label>
				  <input name = "phone" type="text" id="phone" class="form-control" data-mdb-input-mask="+48 999-999-999" />
				</div>
	
			   <label for="inputEmail" class="form-label">EMAIL</label>
			   <input name = "email" type="email" id="inputEmail" class="form-control" aria-describedby="emailHelpBlock">

			   
			   <label for="inputAddress" class="form-label">ADDRESS</label>
			   <input name = "address" type="text" id="inputAddress" class="form-control" aria-describedby="addressHelpBlock">

			   
	           <button class="col-3 btn btn-dark" type = "submit">submit </button>
	    </form>
   	</div>
    <c:import url="../template/common_js.jsp"></c:import>
</body>
</html>