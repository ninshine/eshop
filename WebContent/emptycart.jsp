<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ page import="java.util.List" %>
     <%@ page import="com.shnu.eshop.ProductLineItem"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
	<%List<ProductLineItem> cart;
	cart = (List<ProductLineItem>)session.getAttribute("cart");
	cart.clear(); 
	if(cart.isEmpty()){%>
	<jsp:forward page="emptycart_success.jsp"></jsp:forward>
	<%}else{ %>
	<jsp:forward page="emptycart_error.jsp"></jsp:forward>
	<%} %>
</body>
</html>