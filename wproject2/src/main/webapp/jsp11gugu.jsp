<%@page import="pack.Gugudan"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
** 지금까지 배운 방법으로 사용 **<br>
<%
int dan = Integer.parseInt(request.getParameter("dan"));
out.println(dan + "출력<br>");

// Gugudan gugudan = new Gugudan(); // 클래스의 포함관계. 객체가 요청 수 만큼 생성됨.
Gugudan gugudan = Gugudan.getInstance(); // 클래스의 포함관계. Singleton-Pattern 사용 (처럼 하면 객체가 1개만 생성)

int re[] = gugudan.computeGugu(dan);

for(int a = 0; a < 9; a++){
	out.println(dan + "*" + (a + 1) + "=" + re[a] + "&nbsp;&nbsp;"); 
}
// 위 방법의 단점 : 호출할 때마다 new를 하기 때문에, 인스턴스를 너무 많이 만듬 
%>
<hr>
** JSP 액션태그 중 useBean을 사용 **<br>
<jsp:useBean id="gugu" class = "pack.Gugudan" scope="page" /> <!-- Gugudan gugudan = new Gugudan(); -->
<%--
"page" : 현재 페이지 내에서 지역변수처럼 사용. 매 번 객체 생성
"Request" : HTTP 요청을 WAS가 받아서 웹 브라우저에게 응답할 때까지 변수가 유지되는 경우 사용. 매 번 객체 생성
"Session" : 웹 브라우저 별로 변수가 관리되는 경우 사용. 객체 1회만 생성
"Application" : 웹 어플리케이션이 시작되고 종료될 때까지 변수가 유지되는 경우 사용. 객체 1회만 생성
--%>
<%
int re2[] = gugudan.computeGugu(dan);

for(int a = 0; a < 9; a++){
	out.println(dan + "*" + (a + 1) + "=" + re2[a] + "&nbsp;&nbsp;"); 
}
%>
</body>
</html>