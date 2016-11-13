<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="com.shnu.eshop.UserManager" %>
    <%@ page import="java.util.List" %>
    <%@ page import="com.shnu.eshop.ProductLineItem"%>
    <%@ page import="javax.servlet.http.HttpSession"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
	<%
	List<ProductLineItem> cart;
	cart = (List<ProductLineItem>)session.getAttribute("cart");
	session.setAttribute("curUsername", null);
	cart.clear();
	session.setAttribute("cart", cart);
	%>
	YOU HAVE LOGGED OUT.
	<br><a href="sideview.jsp">RETURN</a>
</body>
</html>