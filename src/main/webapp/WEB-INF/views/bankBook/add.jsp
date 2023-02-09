<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<img alt="" src="../../resources/images/hanna.jpg">
	<!-- //http://localhost/resources/images/hanna.jpg
	//http://localhost/bankBook/add -->
	<h2>add page</h2>
	 <form action="./add" method="post">
	 	  <fieldset>
	 	 		<legend>상품번호</legend>
	 	        bookNumber: <input type="text" name="bookNumber" id="" placeholder="number입력">
	 	  </fieldset>
	 
          <fieldset>
          		<legend>상품명</legend>
                bookName: <input type="text" name="bookName" id="">
          </fieldset>
		
		  <fieldset>
          		<legend>이자율</legend>
         		 bookRate: <input type="number" name="bookRate" id="">
          </fieldset>
		  
		  
		  <!-- 이름을 클릭해도 클릭 가능하게 함 -->
          <fieldset>
          	  <legend>판매여부</legend>
          	  <label for="bs1">판매</label>
          	  <input id="bs1" type="radio" name="bookSale" value="1" checked="checked">
          	  
          	  <label for="bs2">판매중단</label>
         	  <input id="bs2" type="radio" name="bookSale" value="0">
  		  </fieldset>
         	 

	         <!--  <select name="bookSale">
	          	<option value="1">판매</option>
	          	<option selected="selected" value="0">판매중단</option>
	          </select> -->
  
          bookSale: <input type="c" name="bookSale" id="">
          bookDetail: <textarea name="bookDetail" id="" cols="10" rows="10"></textarea>
          <input type="submit" value="등록">
     </form>
</body>
</html>