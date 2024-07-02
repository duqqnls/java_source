<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>* 사용자 목록 *</h3>
<a href="insert.jsp">사용자 추가</a><br>
<table border="1">
	<tr>
		<th>아이디</th><th>이름</th><th>이메일</th>
	</tr>
	<c:forEach var="u" items="${list}">
	<tr>
		<td>${u.userid}</td>
		<td>${u.name}</td>
		<td>${u.email}</td>
	</tr>
	</c:forEach>
</table>
</body>
</html>