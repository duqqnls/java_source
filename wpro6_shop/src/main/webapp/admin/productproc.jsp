<%@page import="pack.product.ProductMgr"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="ProductMgr" class="pack.product.ProductMgr" />

<%
request.setCharacterEncoding("utf-8");


// controller 역할 
String flag = request.getParameter("flag");
boolean result = false;

if(flag.equals("insert")){
	result = ProductMgr.insertProduct(request);
}else if(flag.equals("update")){
	result = ProductMgr.updateProduct(request); 
}else if(flag.equals("delete")){ 
	result = ProductMgr.deleteProduct(request.getParameter("no")); 
}else{
	response.sendRedirect("productmanager.jsp");
}

if(result){
%>
	<script>
		alert("정상 처리되었습니다.");
		location.href="productmanager.jsp";
	</script>
<% }else{ %>
	<script>
		alert("오류 발생되었습니다.");
		location.href="productmanager.jsp";
	</script>
<%	
}
%> 

