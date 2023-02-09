<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
	<title>Home</title>
	<link rel="stylesheet" type="text/css" href="./resources/css/main.css">
	
</head>
<body>
<h1>
	Hello world!  
</h1>
<iframe width="560" height="315" src="https://www.youtube.com/embed/HjGF1ga1ijc" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" allowfullscreen></iframe>
<br>
<!-- alt는 이미지가 없을때 나오는것 -->
<img alt="is hanna" src="/resources/images/hanna.jpg">
<img alt="is hanna2" src="./resources/images/hanna2.jpg">
<br>

<div>
	<a href = "/product/list?num=1&num=2&num=3">product List</a>
	<a href = "/bankBook/list">bankBook List</a>
</div>


<P>  The time on the server is ${serverTime}. </P>
</body>
</html>
