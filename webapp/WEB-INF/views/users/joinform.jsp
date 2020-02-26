<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>가입폼</title>
</head>
<body>
<c:import url="/WEB-INF/views/includes/header.jsp"/>
	<h1>회원가입</h1>

	<script src="<c:url value="/assets/jquery/jquery-3.4.1.min.js"/>">
		
	</script>

	<form modelAttribute="userVo" id="join-form" name="registerForm"
		action="<c:url value="/user/join"/>" method="POST">
		<input type="hidden" name="a" value="join"> <label for="name">이름</label><br>
		<input name="userName" type="text" placeholder="이름을 입력하십시오"><br>

		<label for="text">아이디</label><br> <input name="id" type="text"
			placeholder="아이디를 입력하십시오">
		<button id="btnCheckId" type="button">id 중복 체크</button>
		<br> <input name="chkDupId" type="hidden" value="0"> <label
			for="password">패스워드</label><br> <input type="password"
			name="password" placeholder="비밀번호를 입력하십시오."><br> <label
			for="text">약관 동의</label><br> <input type="checkbox"
			name="promise">서비스약관에 동의합니다<br> <input type="submit"
			value="회원가입">


	</form>

</body>

<script>
	$(document).ready(function() {
		$("#btnCheckId").on("click", function(event) {
			var id = document.registerForm.id.value.trim();
			if (id.length == 0) {
				alert("아이디를 입력해주세요");
				return;
			}
			$.ajax({
				url : "<c:url value="/user/checkId"/>",
				type : "GET",
				data : {
					id : id
				},
				datatype : "json",
				success : function(result) {
					console.log("Result:", result);

					if (result.exists) {

						alert("다른 아이디로 가입해 주세요");
					} else {
						//	chkDupId value = 1
						var dup = document.registerForm.chkDupId;
						dup.value = 1;
						alert("사용할 수 있는 아이디 입니다");
					}
				},
				error : function(request, status, error) {
					console.error("Error:", error);
				}
			});
		});
		$(document.registerForm).on("submit", checkForm);
	});

	function checkForm() {
		var frm = document.registerForm;
		//console.log("약관동의:", frm.promise.checked);
		/*
		if(!checkUserName(frm)){
			return false;
		}
		if(!checkIds(frm)){
			return false;
		}
		 */
		
		if(!checkUsername(frm)){
			return false;
		}
		 
		if (!checkIds(frm)) {
			return false;
		}

		if (!checkIdco(frm)) {
			//	chkDupId를 확인
			//	1이면 확인 했다는 뜻 -> true
			//	그렇지 않으면 확인 안했다는 뜻 -> alert("중복 체크 해주세요")
			//var chkDupId = document.registerForm.chkDupId.value;
			//if(chkDupId == "0"){
			alert("아이디 중복체크를 해주세요");
			return false;
			//}else{
			//	return true;
			//}

		}

		if (!checkPassword(frm)) {
			return false;
		}

		if (!checkPromise(frm)) {
			alert("약관에 동의해주세요");
			return false;
		}
		
		function checkUsername(frm){
			var userName = frm.userName.value.trim();
			if(userName.length == 0){
				alert("이름을 입력해주세요");
				frm.userName.focus();
				return false;
			}
			return true;
		}

		function checkIds(frm) {
			var id = frm.id.value.trim();
			if (id.length == 0) {
				alert("아이디를 입력해주세요");
				frm.id.focus();
				return false;
			}
			return true;
		}

		function checkIdco(frm) {
			var chkDupId = frm.chkDupId.value;
			console.log("chkDupId:", chkDupId);
			//if(chkDupId == "0"){
			//	return false;
			//}else{
			//	return true;
			//}
			return chkDupId != "0";
		}

		function checkPromise(frm) {

			console.log("약관동의:", frm.promise.checked);
			/*
			var checkCount = 0;
			
			for(var i = 0; i < frm.promise.length; i++){
				var cb = frm.promise[i];
				if(cb.checked){
					checkCount ++;
				}
			}
			if(checkCount == 0){
				alert("약관에 동의해주세요");
			}
			return checkCount !=0;
			 */
			return frm.promise.checked;
		}

		function checkPassword(frm) {

			var password = frm.password.value;
			if (password.trim().length == 0) {
				alert("패스워드를 입력해주세요");
				frm.password.focus();
				return false;
			}
			return true;

		}
		
		return true; //	return true로 
	}
</script>
</html>