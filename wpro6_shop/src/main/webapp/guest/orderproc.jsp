<%@page import="pack.order.OrderBean"%>
<%@page import="java.util.Hashtable"%>
<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="cartMgr" class="pack.order.CartMgr" scope="session" />
<jsp:useBean id="orderMgr" class="pack.order.OrderMgr" />
<jsp:useBean id="productMgr" class="pack.product.ProductMgr" />

<%
Hashtable hCart = cartMgr.getCartList();

Enumeration enu = hCart.keys();

if(hCart.isEmpty()) {
%>

	<script>
	alert("주문 내역이 없습니다.");
	location.href="orderlist.jsp";
	</script>
<%
}else{
	while(enu.hasMoreElements()){
		OrderBean orderBean = (OrderBean)hCart.get(enu.nextElement());
		orderMgr.insertOrder(orderBean); 	 // 주문 정보 DB에 저장 
		productMgr.reduceProduct(orderBean); // 주문 수량 만큼 현 재고량 빼기 작업
		cartMgr.deleteCart(orderBean);
	}
%>
	<script>
	alert("주문 처리가 잘 되었습니다.\n 고객님 감사합니다.");
	location.href="orderlist.jsp";
	</script>
<% 
}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>