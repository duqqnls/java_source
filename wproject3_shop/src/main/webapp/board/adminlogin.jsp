<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
String id = request.getParameter("id");
String pwd = request.getParameter("pwd");

if(id.equals("yeobin") && pwd.equals("123")){
	// 로그인에 성공했으므로 세션을 생성 (또는 JWT 사용) * 기본값인 30분간 유효 *
	session.setAttribute("adminOk", id);
	out.println("로그인 성공 !<br>");
}else{
	out.println("로그인 실패 !<br>");
}
%>

<a href="javascript:window.close()">[창 닫기]</a>
</body>
</html>