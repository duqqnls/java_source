<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="logincheck.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>user 상세 보기</title>
<script type="text/javascript">
window.onload = function(){
	document.querySelector("#btnUpdate").onclick = function(){
		if(confirm("진짜 수정할까요?")){
			form.action = "updateform.m2";
			form.submit();
		}
	}
	
	document.querySelector("#btnDelete").onclick = function(){
		if(confirm("진짜 삭제할까요?")){
			form.action = "delete.m2";
			form.submit();
		}
	}
	
	document.querySelector("#btnList").onclick = function(){		
			form.action = "list.m2";
			form.submit();
		
	}
}
</script>
</head>
<body>
<h2>~~ 사용자 상세보기 ~~</h2>
<table border="1">
	<tr>
		<td>아 이 디</td>
		<td>${user.userid }</td>
	</tr>
	<tr>
		<td>비밀번호</td>
		<td>${user.password }</td>
	</tr>
	<tr>
		<td>사 용 자</td>
		<td>${user.name }</td>
	</tr>
	<tr>
		<td>이 메 일</td>
		<td>${user.email }</td>
	</tr>
	<tr>
		<td colspan="2">
			<button id="btnUpdate">수정</button>
			<button id="btnDelete">삭제</button>
			<button id="btnList">목록보기</button>
		</td>
	</tr>
</table>
<form name="form" method="post">
	<input type="hidden" name="userid" value="${user.userid }">
</form>
</body>
</html>