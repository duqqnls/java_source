<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
session.removeAttribute("idkey");
// session.invalidate(); 사용가능하나, 모든 정보가 다 지워짐 => 사용 비권장
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<script type="text/javascript">
alert("로그아웃 성공");
location.href="../guest/guest_index.jsp";
</script>
</body>
</html>