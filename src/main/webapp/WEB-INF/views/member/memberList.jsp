<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>member List</h2>
	<table>
		<thead>
			<tr>
				<td>id</td><td>pw</td><td>name</td>
				<td>address</td><td>phone</td><td>email</td>
			</tr>
		</thead>
		
		<tbody>
			<c:forEach items="${memberDTOs}" var="dto">
				<tr>
					<td>${dto.id}</td><td>${dto.pw}</td><td>${dto.name}</td>
					<td>${dto.address}</td><td>${dto.phone}</td><td>${dto.email}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<a href = "./memberJoin">member Add</a>
	<a href = "./memberLogin">member Login</a>
</body>
</html>