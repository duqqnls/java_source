<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="java.time.LocalTime"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ include file = "jsp3top.jsp" %>
<h1>* include 연습 *</h1>
include 지시어 : 여러 jsp 파일에서 공통으로 사용할 부분을 별도 파일로 작성 후 필요할 때 포함해서 사용한다.
<pre>
여기는
 본 문 이야
</pre>
<%@ include file = "jsp3bottom.jsp" %>
</body>
</html> 