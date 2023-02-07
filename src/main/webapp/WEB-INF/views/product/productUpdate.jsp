<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>update page</h2>
	<form action = "./update" method = "post">
        PRODUCT_NUM <input type="text" name="productnum" id="">
        PRODUCT_NAME <input type="password" name="productname" id="">
        <br>
        PRODUCT_DETAIL <input type="text" name="productdetail" id="">
        PRODUCT_RATE <input type="text" name="productjumsu" id="">
        <button type = "submit">submit</button>
    </form>
</body>
</html>