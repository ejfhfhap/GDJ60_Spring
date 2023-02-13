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
 <h2> add page </h2>
 <div class="col-6">
 	<form action="./productAdd" method="post">
 		상품명<input type="text" placeholder = "상품명 입력" name = "productname" value = "내가 입력한 값">
 		상품정보<textarea name = "productdetail"></textarea>
 		<button type="submit">등록</button>
 		
 	</form>
 </div>
 <c:import url="../template/common_css.jsp"></c:import>
</body>
</html>