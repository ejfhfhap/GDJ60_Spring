<%@page import="com.iu.s1.product.ProductDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>detail page</h2>
	<% 
		ProductDTO productDTO = (ProductDTO)request.getAttribute("dto");
	%>
	<h1><%= productDTO.getProductname() %></h1>
	<h1><%= productDTO.getProductdetail() %></h1>
	
	<hr>
	
	<h3>${dto.PRODUCT_NAME}</h3>
	<h3>${dto.PRODUCT_DETAIL}</h3>
	<h3>${dto.PRODUCT_RATE * dto.PRODUCT_RATE}</h3>
	
</body>
</html>