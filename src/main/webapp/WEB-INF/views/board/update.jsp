<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<c:import url="../template/common_css.jsp"></c:import>
	<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.js"></script>
</head>
<body class = "bg-warning-subtle">
	<img alt="" src="../../resources/images/hanna.jpg">
	<div class="container-fluid my-5">
	
		<div class="row">
			<h2 class ="mx-auto text-center pb-5">${boardName} update page</h2>
		</div>
		

	    <form action="./update" method="post" enctype="multipart/form-data">
			<input type="hidden" name="num" value="${dto.num}">
 	  		<div class="row pb-5">
			 	  <fieldset class="col-1">
			 	 		<legend class="shadow-lg p-3 mb-5 bg-body-tertiary rounded">작성자</legend>
			 	        writer: <input type="text" name="writer" id="writer" placeholder="" readonly="readonly" value="${dto.writer}">
			 	  </fieldset>
			 
		          <fieldset class="col-1 ms-5">
		          		<legend class="shadow-lg p-3 mb-5 bg-body-tertiary rounded">제목</legend>
		                title: <input type="text" name="title" id="title" placeholder="제목입력" value="${dto.title}">
		          </fieldset>
				
				  <fieldset class="col-2 ms-5">
		          		<legend class="shadow-lg p-3 mb-5 bg-body-tertiary rounded">내용</legend>
		          		 contents:<textarea name="contents" id="contents" rows="" cols="">${dto.contents }</textarea>
		          </fieldset>
		          				
				  <div id="fileList">
				  
					<c:forEach items="${dto.boardFileDTOs}" var="fileDTO">
					<div class="input-group mb-3">
						
						<div class="input-group-text">
						  <input class="form-check-input mt-0 deleteCheck" type="checkbox" name="fileNums" value="${fileDTO.fileNum}" aria-label="Checkbox for following text input">
						</div>
							<input type="text" disabled value="${fileDTO.oriName}" class="form-control" aria-label="Text input with checkbox">

				  		</div>
				  </c:forEach>

						<!-- <div id = fileBtn>
							 <div class="mb-3" id = files+${i}>
								<input type = "file" class="form-control" name="pic">
								<label for="files">이미지</label>
								<button type="button">X</button>
							</div> 
						</div> -->
					<button type="button" id = "btnAdd">ADD</button>
				  </div>

			         <!--  <select name="bookSale">
			          	<option value="1">판매</option>
			          	<option selected="selected" value="0">판매중단</option>
			          </select> -->
		  
     		 </div>
     		 

       		 <div class="row col-5 mx-auto">
 		          <input type="submit" class="btn btn-primary" value="글쓰기">
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
		setMax(5);
		setCount(${dto.boardFileDTOs.size()});
		addFileBtn(5 - ${dto.boardFileDTOs.size()});
		$('#contents').summernote();
	 </script>
</body>
</html>