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
  		  
		  <fieldset>
		  	<legend>계좌 이름</legend>
	         bookName: <input type="text" name="bookName" value="${bankBookDTO.bookName}" id="">
		  </fieldset>
		  
		  <fieldset>
		  	<legend>이자율</legend>
	        bookRate: <input type="number" name="bookRate" value="${bankBookDTO.bookRate}" id="">
		  </fieldset>
		  
		  <fieldset>
		  	<legend>판매여부</legend>
		  	판매중<input type = "radio" name="bookSale" value="1" ${bankBookDTO.bookSale eq 1 ? 'checked':''}>
		  	판매중단<input type = "radio" name="bookSale" value="0" ${bankBookDTO.bookSale eq 0 ? 'checked':''}>
		  </fieldset>
		  
		  <fieldset>
		  	<legend>판매여부</legend>
		  	<select name="bookSale">
		  		<option ${bankBookDTO.bookSale eq 1 ? 'selected':''} value="1">판매중</option>
		  		<option ${bankBookDTO.bookSale eq 0 ? 'selected':''} value="0">판매중단</option>
		  	</select>
		  </fieldset>
		  
		  <fieldset>
		  	<legend>상세정보</legend>
		  	<label>bookDetail:</label>
	        <textarea name="bookDetail" id="" cols="10" rows="10">${bankBookDTO.bookDetail}</textarea>
		  </fieldset>

         
          <input type="submit" value="수정">
	</form>
</body>
</html>