<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보수정폼</title>
<script src="<c:url value="/javascript/jquery/jquery-3.6.0.js" />"></script>
<script src="<c:url value="/javascript/users.js" />"></script>
</head>
<body>
	<h1>회원 정보 수정</h1>
	<form id="loginupdate-form" name="loginForm" action="<c:url value="/users/loginupdate" />"
	method="POST">
	<input type="hidden" name="no" value="${ authUser.getNo() }">
	
	<label for"email">이메일</label>
	
	</form>
</body>
</html>