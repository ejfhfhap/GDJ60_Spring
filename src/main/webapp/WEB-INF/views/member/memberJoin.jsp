<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../template/common_css.jsp"></c:import>
<style>
	.redResult{
		color: red;
	}
	.blueResult{
		color: blue;
	}
</style>

</head>
<body>
	<c:import url="../template/header.jsp"></c:import>
	
	<h2>member add page</h2>
	<div class="container">
		<form id = "formBtn" class="row justify-content-center" action="./memberJoin" method="post">
		
			   <label for="inputId" class="form-label">ID</label>
			   <input name = "id" type="text" id="inputId" class="form-control" aria-describedby="idHelpBlock">
			   <div id="idMsg" class="form-text">
				  id를 입력 해 주세요
			   </div>
			   
			   <label for="inputPw1" class="form-label">PW</label>
			   <input name = "pw" type="password" id="inputPw1" class="form-control" aria-describedby="pwHelpBlock">
			   <div id="pwMsg" class="form-text">
				 pw를 입력 해 주세요
			   </div>

			   <label for="inputPw2" class="form-label">PW</label>
			   <input name = "pw" type="password" id="inputPw2" class="form-control" aria-describedby="pwHelpBlock">
			   <div id="rePwMsg" class="form-text">
				 pw를 한번 더 입력 해 주세요
			   </div>

			   <label for="inputName" class="form-label">NAME</label>
			   <input name = "name" type="text" id="inputName" class="form-control" aria-describedby="nameHelpBlock">
				<div id="nameMsg" class="form-text">
				 이름을 입력 해 주세요
			   </div>
	          
			   <div class="form-outline mb-3" style="width: 100%">
			     <label class="form-label" for="inputPhone">PHONE</label>
				  <input name = "phone" type="text" id="inputPhone" class="form-control" data-mdb-input-mask="+48 999-999-999" />
				</div>
				<div id="phoneMsg" class="form-text">
				  핸드폰을 입력 해 주세요
			   </div>
			   
			   <label for="inputEmail" class="form-label">EMAIL</label>
			   <input name = "email" type="email" id="inputEmail" class="form-control" aria-describedby="emailHelpBlock">
				<div id="emailMsg" class="form-text">
				 이메일을 입력 해 주세요
			   </div>
			   
			   <label for="inputAddress" class="form-label">ADDRESS</label>
			   <input name = "address" type="text" id="inputAddress" class="form-control" aria-describedby="addressHelpBlock">
				<div id="addressMsg" class="form-text">
				  주소를 입력 해 주세요
			   </div>
			   
	           <button class="col-3 btn btn-dark" type = "button" id = "btn">submit </button>
	    </form>
   	</div>
	<script src="../resources/js/memberJoin.js"></script>
    <c:import url="../template/common_js.jsp"></c:import>
</body>
</html>