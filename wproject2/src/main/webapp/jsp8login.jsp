<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
	session = "true"
%>
<%
// 로그인 성공하면 loginok, 실패하면 loginfail로 이동하는 로직 처리 
String id = request.getParameter("id");
String pwd = request.getParameter("pwd");

if((id.equals("admin") && pwd.equals("111")) || 
	(id.equals("user") && pwd.equals("222"))){
	session.setAttribute("id", id); // 세션 생성
	response.sendRedirect("jsp8loginok.jsp");
	
	// 세션이 아니라 request를 사용한다면 
	request.setAttribute("id", id);
	request.getRequestDispatcher("jsp6invoked.jsp").forward(request, response);
}else {
	response.sendRedirect("jsp8loginfail.html");
}
	
%>
