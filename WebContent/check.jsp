<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.List" %>
     <%@ page import="com.shnu.eshop.ProductLineItem" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
   <%
   int total = 0;
   List<ProductLineItem> cart = null;
	cart = (List<ProductLineItem>)session.getAttribute("cart");
	if(cart==null||cart.isEmpty()){
		%>YOU CART IS EMPTY!<%
	}else{
   	for(ProductLineItem pli:cart){
			out.print("You have "+pli.getQuantity()+" \""+pli.getName()+"\", subtotal is $"+pli.getPrice()+".");
			total += pli.getPrice();
	%><br><%} %>
	<br>Total is $<%=total %>.
	<form name="shipping_form" action="check.do" method="post">
		<br>Shipping Address:<input type="text" name="shipping_addr">
		<br>Shipping Name:<input type="text" name="shipping_name">
		<br>Shipping Tel.:<input type="text" name="shipping_tel">
		<input type="hidden" name="balance">
		<br><br><a href="javascript:document.shipping_form.submit();" >CHECK</a>	
	</form><%} %>
	<br><a href="javascript:history.back(-1)">RETURN</a>
</body>
</html>