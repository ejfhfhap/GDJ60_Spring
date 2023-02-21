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
<body class="bg-primary text-white bg-opacity-50">
	<c:import url="../template/header.jsp"></c:import>
	
	<div class="container">
 	<h2> member login</h2>
     <form class="row justify-content-center" action="./memberLogin" method="post">
		<label for="inputid" class="form-label">id</label>
		<input type="text" id="id" name="id" class="form-control" aria-describedby="passwordHelpBlock">
		<div id="id" class="form-text">
		  Your id must be 8-20 characters long, contain letters and numbers, and must not contain spaces, special characters, or emoji.
		</div>
		
		<label for="password" class="form-label">Password</label>
		<input type="password" id="password" name="pw" class="form-control" aria-describedby="passwordHelpBlock">
		<div id="password" class="form-text">
		  Your password must be 8-20 characters long, contain letters and numbers, and must not contain spaces, special characters, or emoji.
		</div>

        <button type="submit" class="btn btn-outline-success mx-5" style="width:30%">submit</button>
    </form>
    </div>
    <c:import url="../template/common_js.jsp"></c:import>
</body>
</html>