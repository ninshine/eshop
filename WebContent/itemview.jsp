<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.mysql.jdbc.Driver" %>  
<%@ page import="java.sql.*" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
<table border="1">
		<tr>
			<td>No.</td>
			<td>Name</td>
			<td>Price</td>
			<td>Stock</td>
			<td>Add to cart</td>
		</tr>
<%  
//驱动程序名  
String driverName="com.mysql.jdbc.Driver";  
//数据库用户名  
String userName="root";  
//密码  
String userPasswd="ltz5623459";  
//数据库名  
String dbName="test";  
//表名  
String tableName="item";  
//联结字符串  
String url="jdbc:mysql://localhost/"+dbName+"?user="+userName+"&password="+userPasswd;  
Class.forName("com.mysql.jdbc.Driver").newInstance();  
Connection conn=DriverManager.getConnection(url);  
Statement stmt = conn.createStatement();  
ResultSet rs=stmt.executeQuery("select * from "+tableName);
int id = 0;
String name = null;
int price = 0;
int stock = 0;
int quantity = 1;
while(rs.next()){
	id = rs.getInt("id");
	name = rs.getString("name");
	price = rs.getInt("price");
	stock = rs.getInt("stock");
	%>
	
		<tr>
			<td><%=id %></td>
			<td><%=name %></td>
			<td><%=price %></td>
			<td><%=stock %></td>
			<td><a href="addtocart.do?id=<%=id%>&quantity=<%=quantity%>&name=<%=name%>&stock=<%=stock%>&price=<%=price%>">Add to cart</a></td><% }%>
		</tr>
	</table>
</body>
</html>