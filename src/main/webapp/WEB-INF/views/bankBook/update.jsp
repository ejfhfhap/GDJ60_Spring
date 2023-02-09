<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>상품수정 page</h1>
	
	<form action="./update" method = "post">
		  <input type="hidden" name="bookNumber" value="${bankBookDTO.bookNumber}" id="">
          bookName: <input type="text" name="bookName" value="${bankBookDTO.bookName}" id="">
          bookRate: <input type="number" name="bookRate" value="${bankBookDTO.bookRate}" id="">
          <br>
          bookSale: <input type="number" name="bookSale" value="${bankBookDTO.bookSale}" id="">
          bookDetail: <textarea name="bookDetail" id="" cols="10" rows="10">${bankBookDTO.bookDetail}</textarea>
          <input type="submit" value="수정">
	</form>
</body>
</html>