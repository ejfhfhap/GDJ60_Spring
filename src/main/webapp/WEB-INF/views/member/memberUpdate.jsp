<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../template/common_css.jsp"></c:import>
</head>
<body>
<c:import url="../template/header.jsp"></c:import>
    <form action="/member/memberUpdate" method="post">
       <%--  <input type="hidden" name="id" value="${dto.id}"> --%>

        <label>name</label>
		<input type="text" id="name" name="name" class="form-control" value="${dto.name}">

        <label>address</label>
		<input type="text" id="address" name="address" class="form-control" value="${dto.address}" >

        <label>phone</label>
		<input type="text" id="phone" name="phone" class="form-control" value="${dto.phone}">

        <label>email</label>
		<input type="text" id="email" name="email" class="form-control" value="${dto.email}">

		


        <button type="submit" class="btn btn-outline-success mx-5" style="width:30%">submit</button>
        <!-- name: <input type="text" name="name" id="" value="${member.name}">
        address: <input type="text" name="address" id="" value="${member.address}">
        phone: <input type="text" name="phone" id="" value="${member.phone}">
        email: <input type="text" name="email" id="" value="${member.email}">
        <input type="submit" value="수정하기"> -->
    </form>
    <c:import url="../template/common_js.jsp"></c:import>
</body>
</html>