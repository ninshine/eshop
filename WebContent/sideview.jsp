<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
</head>
<body>
<%String curUsername = null;
curUsername = (String)session.getAttribute("curUsername"); 
  if(curUsername==null){%>
<a href="login.jsp">Login</a><br>
<%}else{%>
Username:<%=curUsername %>
<br>Balance:$<%=session.getAttribute("curBalance").toString()%>
<br><a href="logout.jsp">Logout</a><br>
<%} %>
<a href="checkcart.jsp">ShoppingCart</a><br>
<a href="check.jsp">Check</a>
</body>
</html>