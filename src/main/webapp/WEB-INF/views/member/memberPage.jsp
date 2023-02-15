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
<div class = "container-fluid">
	<div class = "row">
		 <h2> member Page</h2>
	 </div>
	 <div class = "row">
		 <h2>name: ${dto.name}</h2>
		 <h2>address: ${dto.address}</h2>
	     <h2>phone: ${dto.phone}</h2>
		 <h2>email: ${dto.email}</h2>
	 	 <a href = "./memberUpdate" class = "btn btn-info">정보수정</a>
	 </div>
 </div>
    <c:import url="../template/common_js.jsp"></c:import>
</body>
</html>