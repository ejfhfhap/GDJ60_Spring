<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>remove test</h1>

	<div id="result">
		<c:forEach begin="0" end="4" var="i" varStatus="j">
			<div id = "p${j.index}" class="items">
				<h3>${i}</h3>
				<!-- data- 속성에 임의로 값을 저장 할 수 있음 -->
				<button class = "btn" data-div-id="p${j.index}">DELETE</button>
			</div>
		</c:forEach>
	</div>
	<button id="deleteAll">DeleteAll</button>

	<script>
		let btn = document.getElementsByClassName("btn");
		const result = document.getElementById('result');
		const deleteAll = document.getElementById('deleteAll');

		deleteAll.addEventListener("click",()=>{
			let items = document.getElementsByClassName('items');

			while(items.length){
				items[0].remove();
			}

		})



		for(let i = 0;i<btn.length;i++){
			btn[i].addEventListener("click",()=>{
				// let temp = document.getElementById("p"+ i);
				// temp.remove();

				// html에서 저장한 아이디 값 가져옴
				let id = btn[i].getAttribute("data-div-id");
				document.getElementById(id).remove();
			})
		}
	</script>
</body>
</html>