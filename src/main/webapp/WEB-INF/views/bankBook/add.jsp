<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>add page</h2>
	 <form action="./add" method="post">
          bookNumber: <input type="text" name="bookNumber" id="" placeholder="number입력">
          bookName: <input type="text" name="bookName" id="">
          bookRate: <input type="number" name="bookRate" id="">
          <br>
          bookSale: <input type="number" name="bookSale" id="">
          bookDetail: <textarea name="bookDetail" id="" cols="10" rows="10"></textarea>
          <input type="submit" value="등록">
     </form>
</body>
</html>