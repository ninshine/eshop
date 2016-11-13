package com.shnu.eshop;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

public class CheckProcess {
	
	private int balance = 0;
	private int total = 0;
	public boolean isCheckSuccess(CheckActionForm caf,HttpSession session){
		DBManager dbm = new DBManager();
		String tableName = "item";
		String sql = "select * from "+tableName;
		ResultSet rs = dbm.dbQuery(sql);
		List<Integer> rslist = new ArrayList();
		try {
			while(rs.next()){
				rslist.add(rs.getInt("id"));
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		List<ProductLineItem> cart = new ArrayList();
		cart = (List<ProductLineItem>) session.getAttribute("cart");
		String username = (String)session.getAttribute("curUsername");
		balance = (int) session.getAttribute("curBalance");
			for(ProductLineItem curpli:cart){
				curpli.calSubtotal();
				total += curpli.getSubtotal();// wait for development!
			}

			if(balance>=total){
				balance -= total;
				System.out.println("CheckProcess.balance --> "+balance);
				System.out.println("CheckProcess.total --> "+total);
				sql = "update user set balance = "+balance+" where username ='"+username+"'";
				dbm.dbUpdate(sql);
				System.out.println("CheckProcess.stmt.executeUpdate();");
				for(int rsl:rslist){
					System.out.println("a = "+rsl);
					for(ProductLineItem curpli:cart){
							System.out.println("curpli.getId() --> "+curpli.getId());
							System.out.println("rs.getInt(\"id\") --> "+rsl);
							if(curpli.getId()==rsl){
								sql = "update item set stock = stock - 1 where id ="+curpli.getId();//
								dbm.dbUpdate(sql);
							}
					}
				}
				cart.clear();
				session.setAttribute("cart", cart);
				session.setAttribute("curBalance", balance);
				System.out.println("CheckProcess.return true;");
				return true;
				}
				
			
		System.out.println("CheckProcess.return false;");
		return false;
	}
	
	public void calTotal(HttpSession session){
		List<ProductLineItem> cart = (List<ProductLineItem>)session.getAttribute("cart");
		for(ProductLineItem curpli:cart){
			total += curpli.getPrice();
		}
	}
	public int getTotal(){
		return total;
	}
}
