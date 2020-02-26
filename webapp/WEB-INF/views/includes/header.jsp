<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    

<h1>JBLOG</h1>
<ul>
	<c:choose>
		<c:when test="${empty authUser }">
			<li><a href = "<c:url value="/user/login"/>">로그인</a></li>
			<li><a href = "<c:url value="/user/join"/>">회원 가입</a></li>
		</c:when>
		
		<c:otherwise>
			<li><a href = "<c:url value="/user/logout"/>">로그아웃</a></li>
			<li><a href = "<c:url value="/${authUser.id }"/>">내 블로그</a></li>
		</c:otherwise>
	</c:choose>
</ul>

