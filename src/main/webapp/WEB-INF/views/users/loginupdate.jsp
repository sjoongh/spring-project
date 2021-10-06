<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>회원 정보 수정</title>
	<script src="<c:url value="/javascript/jquery/jquery-3.6.0.js" />"></script>
	<script src="<c:url value="/javascript/users.js" />"></script>
	<link rel="stylesheet" 
	href="<c:url value="/css/user.css" />">
</head>
<body>
	<div id="container">
		<jsp:include page="/WEB-INF/views/includes/header.jsp" />
		<jsp:include page="/WEB-INF/views/includes/navigation.jsp" />
		<div id="wrapper">
			<div id="content">
				<h1>회원 정보 수정</h1>
				
				<form
					id="modify-form"
					name="updateForm" 
					action="<c:url value="/users/modify"/>"
					method="POST">
					<input type="hidden" name="no" value="${authUser.getNo() }">
					
					<label for"email">이메일</label>
					<input name="email" type="text"	value="${authUser.getEmail() }" disabled><br>
					
					<label for="name">이름</label>
					<input name="name" type="text" value="${authUser.getName() }"><br>
				
					<label for="password">비밀번호</label>
					<input name="password" type="password" placeholder="새로운 비밀번호를 입력하십시오">
				
					<label for="gender">성별</label>
					<c:choose>
						<c:when test='${authUser.gender == "M" }'>
							<input type="radio" name="gender" value="M" checked>남성</radio>
							<input type="radio" name="gender" value="F">여성</radio>
						</c:when>
						<c:otherwise>
							<input type="radio" name="gender" value="M">남성</radio>
							<input type="radio" name="gender" value="F" checked>여성</radio>
						</c:otherwise>
					</c:choose>
						
					<input type="submit" value="저장"> 
				
				</form>
			</div>
		</div>
		<%@ include file="/WEB-INF/views/includes/footer.jsp" %>
	</div>
</body>
</html>