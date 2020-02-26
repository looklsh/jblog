<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내 블로그 관리</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<link rel="stylesheet"
	href="<c:url value="/assets/bootstrap/css/bootstrap.css" />" />
<style>
* {
	padding: 0;
	margin: 0;
}

ul, li {
	list-style: none;
}

a {
	color: black;
	text-decoration: none;
}

#header {
	background-color: rgb(60, 60, 255);
	height: 100px;
	text-align: center;
}

#header>h1 {
	color: white;
}

#header li {
	float: right;
	padding: 10px;
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

}   
#basic li{
	
	float:left;
	padding: 15px;
}  
#tab {
	top: 200px;
	left: 10px;
	padding: 15px;
	float:left;
	position: absolute;
}
li a:link{
	color:black;
	font-weight: bold;
}
#addcate {
	top: 600px;
	left: 10px;
	padding: 15px;
	float:left;
	position: absolute;
	font-weight: bold;
}   

</style>	
</head>
<body>
	<header id="header">
        <h1><!-- ${authUser.userName }의 블로그입니다. -->${blog.blogTitle }</h1>
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
    
    <form modelAttribute="blogVo" method="post" action="<c:url value="/${authUser.id }/admin/basic"/>">
    	<div id="basic">
    		<ul>
    			<li><a href="<c:url value="/${authUser.id }/admin/basic"/>">기본설정</a></li>
    			<li><a href="<c:url value="/${authUser.id }/admin/category"/>">카테고리</a></li>
    			<li><a href="<c:url value="/${authUser.id }/admin/write"/>">글 작성</a></li>
    		</ul>
    	</div>
    	<br>
    	
    	<table id="tab" border="1" width="640">
		
		<tr>
			<th>번호</th>
			<th>카테고리명</th>
			<th>포스트 수</th>
			<th>설명</th>
			<th>삭제</th>
		</tr>
		
		<c:forEach items="${list }" var="vo">
			<tr>
				<td>${vo.cateNo }</td>
				<td>${vo.cateName }</td>
				<td>??</td>
				<td>${vo.description }</td>
				<td>
					<button id="deletecate">
						X
					</button>
				</td>
			</tr>
		</c:forEach>
	</table>
    </form>
    
    <form method="post" action="<c:url value="/${authUser.id }/admin/category"/>">
    	<div id="addcate">
    		<ul>새로운 카테고리 추가</ul>
    		<label>블로그 제목</label>
    		<input type="text" name="cateName" value="${category.cateName }"/><br>
    		<label>설명</label>
    		<input type="text" name="description" value="${category.description }"/><br>
    		<input type="submit" value="카테고리 추가">
    	</div>
    
    </form>
   
    <footer>
		<p>${blog.blogTitle } is powered by JBlog &copy 2018</p>
	</footer>
</body>
</html>
