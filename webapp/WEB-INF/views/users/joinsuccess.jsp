<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>가입성공</title>
<link type="text/css" rel="stylesheet" href="<%= request.getContextPath() %>/css/users.css"/>
</head>
<body>
	<h1>회원가입 성공</h1>
	<p class="jr-success">
		"감사합니다. 회원 가입 및 블로그가 성공적으로 만들어 졌습니다."
	</p>
	<p>
		<a href="<c:url value="/members/login"/>">로그인하기</a>
	</p>

</body>
</html>