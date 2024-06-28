<%@page import="pack.SangpumBean"%>
<%@page import="pack.ConnClass3"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
// 입력 자료를 전송 받아 insert하는 로직 
request.setCharacterEncoding("utf-8");
// String sang = request.getParameter("sang"); 에 대신 품빈 사용
//..
%>

<jsp:useBean id = "SangpumBean" class="pack.SangpumBean" />
<jsp:setProperty property = "*" name = "SangpumBean" />
<%
// 수신 데이터 검증 필요 ...

%>
<jsp:useBean id="connClass3" class="pack.ConnClass3" />

<%
connClass3.insertData(SangpumBean);

// 상품 추가 후 상품 목록보기로 이동
// 새로고침해도 추가가 되지 않는다. (차이 1)
response.sendRedirect("jsp16paging.jsp");


// request.getRequestDispatcher("jsp16paging.jsp").forward(request, response);
// 28라인의 주의 : 추가, 수정, 삭제 후 목록 보기 할 때는 forwarding 하지 않는다. (차이 2)
%>