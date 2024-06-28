<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String id = request.getParameter("id"); // html파일에서 id가 넘어온다.
// setAttribute 하는 3가지 방법
// request.setAttribute("idkey", id); 		// 현재 jsp파일에서만 유효
// application.setAttribute("idkey", id);  // 현재 서비스 중 모두에게 유효 
// session.setAttribute("idkey", id);		// 세션을 참조하는 파일에서만 유효 
 
// Servlet인 경우 HttpSession session = request.getSession(true);
// session.setAttribute("idkey", "id");
// JSP에서 Session 사용방법 
session.setAttribute("idkey", id);
session.setMaxInactiveInterval(10); // 10안 써주면 기본값은 30분임 

// 0. 참고로 session은 중복 불가
// 1. 서버가 클라이언트 컴퓨터에 session-id를 쿠키에 저장해둠.
// 2. 다음부터는 클라이언트가 서버에 정보요청시 session-id가 담긴 쿠키를 들고 간다.
%> 

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>* Session 연습 *</h2>
<form action = "jsp7session2.jsp" method = "get">
보고 싶은 영화 선택 : <br>
<input type = "radio" name = "movie" value = "원더랜드" checked = "checked">원더랜드 
&nbsp;&nbsp;
<input type = "radio" name = "movie" value = "퓨리오사">퓨리오사 
&nbsp;&nbsp;
<input type = "radio" name = "movie" value = "설계자">설계자 
<input type = "submit" value = "결과보기">
</form>
</body>
</html>