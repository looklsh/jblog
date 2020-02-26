<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>개인 블로그</title>
<style>
* {
    padding: 0;
    margin: 0;
}
ul, li {
    list-style: none;
}
a {
    color: white;
    text-decoration: none;
}
#header {
    background-color: rgb(60, 60, 255);
    height: 100px;
    text-align: center;

    }
#header> h1 {
    color: white;
}

#header li {
    float: right;
    padding: 10px;
}

#picture img {
	float: right;
}

#picture {
	background-color: light gray;
}

footer{
        position: absolute;
        bottom: 0;
        width: 100%;
        height: 40px;
        background-color: gray;
    }
footer p{
        position: absolute;
        top: 50%; left: 50%;
        transform: translate(-50%, -50%);
        color: black;
        font-weight: bold;
</style>
</head>
<body>
    <header id="header">
        <h1>${authUser.userName }의 블로그입니다.</h1>
        <ul>
        	<c:choose>
        		<c:when test="${empty authUser}">
            		<li><a href="<c:url value="/user/logout"/>">로그아웃</a></li>
            		<li><a href="<c:url value="/user/login"/>">로그인</a></li>
				</c:when>
				<c:when test="${not empty authUser }">
					<li><a href="<c:url value="/user/logout"/>">로그아웃</a></li>
            		<li><a href="<c:url value="/${authUser.id}/admin/basic"/>">내블로그 관리</a></li>
				</c:when>
            </c:choose>
        </ul>
               
    </header>
    
    <div id="picture">
        	<img src="<c:url value="/images/realspring.jpg"/>" width="400px">
        	<label>카테고리</label>
        	
    </div>
	<footer>
		<p>${authUser.userName } is powered by JBlog &copy 2018</p>
	</footer>
</body>
	
</html>