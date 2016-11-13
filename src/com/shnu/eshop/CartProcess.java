package com.shnu.eshop;

import com.mysql.jdbc.Driver; 
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

@SuppressWarnings("unused")
public class CartProcess {
	private int id = 0;
	private String name = null;
	private int price = 0;
	private int stock = 0;
	private int quantity = 0;
	
	private String driverName="com.mysql.jdbc.Driver";  
	//数据库用户名  
	private String userName="root";  
	//密码  
	private String userPasswd="ltz5623459";  
	//数据库名  
	private String dbName="test";  
	//表名  
	private String tableName="item";  
	//联结字符串  
	private String url="jdbc:mysql://localhost/"+dbName+"?user="+userName+"&password="+userPasswd;  
	
	public boolean isAdd(AddToCartActionForm atcaf,HttpSession session){
		//驱动程序名  
		int id = 0;
		int quantity = 0;
		id = atcaf.getId();
		quantity = atcaf.getQuantity();
		ProductLineItem curpli;
		List<ProductLineItem> cart = new ArrayList<>();
		try{
				Class.forName("com.mysql.jdbc.Driver").newInstance();  
				Connection conn=DriverManager.getConnection(url);  
				Statement stmt = conn.createStatement();  
				ResultSet rs=stmt.executeQuery("select * from "+tableName);
				while(rs.next()){
					this.id = rs.getInt("id");
					name = rs.getString("name");
					price = rs.getInt("price");
					stock = rs.getInt("stock");
					if(id==this.id&&stock>=quantity){
						curpli = new ProductLineItem(id,name,price,quantity);
						cart.add(curpli);
						session.setAttribute("cart", cart);
						return true;
					}
				}
			}catch(SQLException | InstantiationException | IllegalAccessException | ClassNotFoundException e){
				e.printStackTrace();
			}
		return false;
	}
}
	
	
