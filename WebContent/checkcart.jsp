<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="com.shnu.eshop.ProductLineItem" %> 
    <%@ page import="java.util.List" %> 
    <%@ page import="java.util.ArrayList" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
	<%
		List<ProductLineItem> cart = new ArrayList();
		cart = (List<ProductLineItem>)session.getAttribute("cart");
	if(cart==null||cart.isEmpty()){%>
		<jsp:forward page="checkcart_error.jsp"></jsp:forward>
	<%}else{%>
		<jsp:forward page="checkcart_result.jsp"></jsp:forward>
	<%} %>
	
	
</body>
</html>