<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
HttpSession ses = request.getSession(false);
ses.invalidate();

response.sendRedirect("jsp9sessionlogin.html");

%>
