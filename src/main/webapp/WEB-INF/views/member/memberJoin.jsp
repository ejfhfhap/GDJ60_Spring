<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>member add page</h2>
	<form action="./memberJoin" method="post">
           id <input type="text" name="id" id="">
           pw <input type="password" name="pw" id="">
           name <input type="text" name="name">
           <br>
           phone <input type="text" name="phone">
           email <input type="text" name="email">
           address <input type="text" name="address">
           <button type = "submit">submit </button>
    </form>
</body>
</html>