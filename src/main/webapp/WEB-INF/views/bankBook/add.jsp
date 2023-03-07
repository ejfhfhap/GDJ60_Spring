<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<c:import url="../template/common_css.jsp"></c:import>
	<link href="summernote-bs5.css" rel="stylesheet">
    <script src="summernote-bs5.js"></script>
</head>
<body class = "bg-warning-subtle">
	<c:import url="../template/show.jsp"></c:import>
	<img alt="" src="../../resources/images/hanna.jpg">
	<c:import url="../template/show.jsp"></c:import>
	<!-- //http://localhost/resources/images/hanna.jpg
	//http://localhost/bankBook/add -->
	<div class="container-fluid my-5">
		<div class="row">
			<h2 class ="mx-auto text-center pb-5">add page</h2>
		</div>
		

	    <form action="./add" method="post" enctype="multipart/form-data">
 	  		<div class="row pb-5">
			 	  <fieldset class="col-1">
			 	 		<legend class="shadow-lg p-3 mb-5 bg-body-tertiary rounded">상품번호</legend>
			 	        bookNumber: <input type="text" name="bookNumber" id="" placeholder="number입력">
			 	  </fieldset>
			 
		          <fieldset class="col-1 ms-5">
		          		<legend class="shadow-lg p-3 mb-5 bg-body-tertiary rounded">상품명</legend>
		                bookName: <input type="text" name="bookName" id="">
		          </fieldset>
				
				  <fieldset class="col-2 ms-5">
		          		<legend class="shadow-lg p-3 mb-5 bg-body-tertiary rounded">이자율</legend>
		         		 bookRate: <input type="number" name="bookRate" id="">
		          </fieldset>
		          <!-- 이름을 클릭해도 클릭 가능하게 함 -->
		          <fieldset class="col-2">
		          	  <legend class="shadow-lg p-3 mb-5 bg-body-tertiary rounded">판매여부</legend>
		          	  <select class="form-select" aria-label="Default select example" name = "bookSale">
						  <option value="0">판매중</option>
						  <option selected value="1">판매중단</option>
					  </select>
					  
		          	  <!-- <label for="bs1">판매</label>
		          	  <input id="bs1" type="radio" name="bookSale" value="1" checked="checked">
		          	  
		          	  <label for="bs2">판매중단</label>
		         	  <input id="bs2" type="radio" name="bookSale" value="0"> -->
		  		  </fieldset>
		         	
		          <fieldset class="col-2">
		          	  <legend class="shadow-lg p-3 mb-5 bg-body-tertiary rounded">상세정보</legend>
		          	  
		          	  <div class="form-floating">
						  <textarea name = "bookDetail" class="form-control" placeholder="Leave a comment here" id="bookDetail" rows=20></textarea>
						  <label for="floatingTextarea">Comments</label>
					 </div>
		          </fieldset>
					
				  <div id="fileList">
					<!-- <fieldset class="col-2">
						<legend class="shadow-lg p-3 mb-5 bg-body-tertiary rounded">파일선택</legend>
						<div class="form-floating">
							<input type = "file" class="form-control" id="files" name="pic">
							<label for="files">이미지</label>
						</div>
					</fieldset> -->
					<button type="button" id = "btnAdd">ADD</button>
				  </div>

			         <!--  <select name="bookSale">
			          	<option value="1">판매</option>
			          	<option selected="selected" value="0">판매중단</option>
			          </select> -->
		  
     		 </div>
     		 

       		 <div class="row col-5 mx-auto">
 		          <input type="submit" class="btn btn-primary" value="등록">
       		 </div>
		 	<div class="progress" role="progressbar" aria-label="Success striped example" aria-valuenow="25" aria-valuemin="0" aria-valuemax="100">
  			<div class="progress-bar progress-bar-striped bg-success" style="width: 25%"></div>
		</div>
		<div class="progress" role="progressbar" aria-label="Success striped example" aria-valuenow="25" aria-valuemin="0" aria-valuemax="100">
  			<div class="progress-bar progress-bar-striped bg-success" style="width: 60%"></div>
		</div>
	     </form>
     </div>
     <c:import url="../template/common_js.jsp"></c:import>
	 <script src="../resources/js/fileManager.js"></script>
	 <script>
		setMax(3);
	//	$('#bookDetail').summernote();
	
	 </script>
</body>
</html>