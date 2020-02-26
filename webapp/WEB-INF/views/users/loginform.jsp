<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>My Homepage</title>

<link type="text/css" 
	rel="stylesheet" 
	href="<%= request.getContextPath() %>/css/users.css"/>
</head>
<body>
<c:import url="/WEB-INF/views/includes/header.jsp"/>
	<form id="login-form" 
		name="loginform" 
		method="POST" 
		action="<c:url value="/user/login"/>">
		
		<label class="block-label" for="id">아이디</label><br> 
		<input id="id" name="id" type="text" value=""><br> 

		<label class="block-label">패스워드</label><br> 
		<input name="password" type="password" value=""><br>

		<input type="submit" value="로그인">
	</form>
    
</body>
</html>