<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ page import="com.shnu.eshop.ProductLineItem" %> 
    <%@ page import="java.util.List" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
   <%
   List<ProductLineItem> cart;
	cart = (List<ProductLineItem>)session.getAttribute("cart");
   int total = 0;
   	for(ProductLineItem pli:cart){
			out.print("You have "+pli.getQuantity()+" \""+pli.getName()+"\", subtotal is $"+pli.getPrice()+".");
			total += pli.getPrice();
	%><br><%} %>
	<br>Total is $<%=total %>.
	<br><a href="javascript:history.back(-1)">RETURN</a>
	<br><a href="emptycart.jsp">EMPTY THE CART</a>
	<br><a href="check.jsp">CHECK</a>
</body>
</html>