<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="<c:url value="/assets/bootstrap/css/bootstrap.css" />"/>
</head>
<body>
<div class="form-group">
	<c:import url="/WEB-INF/views/includes/header.jsp"/>
	
	<input type="text" name="search"/>
	<button>검색</button>

</div>
</body>
<script src="<c:url value="/assets/jquery/jquery-3.4.1.min.js" /> "/>
</script>
<script src="<c:url value="/assets/bootstrap/js/bootstrap.js"/>"/>
</script>
</html>