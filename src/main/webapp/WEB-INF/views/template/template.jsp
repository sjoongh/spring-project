<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Template</title>
<script language="javascript" 
	type="text/javascript" 
	src="<%= request.getContextPath() %>/javascript/jquery/jquery-3.6.0.js"></script>
<link rel="stylesheet" 
	href="<%= request.getContextPath() %>/css/main.css" />
</head>
<body>
	<div id="container">
		<!-- 동적 include방식, 페이지가 호출 될때마다 포함하는 자식페이지의 내용을 포함해서 재컴파일 수행
			컴파일 완료된 각기 다른 class파일을 이용해서 view 생성, 
			때문에 include되는 jsp파일의 변수 사용 불가
			부모 페이지에서 include한 파일의 변수 사용시 따로 부모페이지에서 지정해야함
			중복되는 화면을 하나의 JSP페이지로 만들어 중복 제거 -->
		<!--  기본적으로는 동적 include사용, 화면의 레이아웃의 일부분을 모듈화할 때 주로 사용
			모듈 : 코드를 재사용, 정적은 한번만 컴파일 되므로 재사용 용도로는 사용하기 어렵다 -->
		<jsp:include page="/WEB-INF/views/includes/header.jsp" />
		<jsp:include page="/WEB-INF/views/includes/navigation.jsp" />
		<div id="wrapper">
			<div id="content">
				<h1>My Portal</h1>
				<p>Spring Framework로 만든 홈페이지입니다.</p>
			</div>
		</div>
		<!-- 정적 include방식, 포함되는 JSP페이지를 로드하고 그것을 java로 변경 후 
			여러 페이지를 합쳐서 컴파일(하나의 페이지) 진행, 때문에 별도의 변수 선언없이 부모페이지 변수 사용 가능 
			여러 JSP파일에 걸쳐 선언되는 중복 변수나 중복 로직을 제거 -->
		<!-- 작은 양의 파일 AND 다수의 JSP페이지에서 공통으로 사용되는 코드나 저작권과 같은 문장을 포함 
			정적 include -->
		<%@ include file="/WEB-INF/views/includes/footer.jsp" %>
	</div>
</body>
</html>