package com.shnu.eshop;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class UserManager {
	public static String loginUsername = null;
	public void login(String username, String password, HttpServletRequest request){
		@SuppressWarnings("unused")
		String driverName="com.mysql.jdbc.Driver";  
		//数据库用户名  
		String userName="root";  
		//密码  
		String userPasswd="ltz5623459";  
		//数据库名  
		String dbName="test";  
		//表名  
		String tableName="user";  
		//联结字符串  
		String url="jdbc:mysql://localhost/"+dbName+"?user="+userName+"&password="+userPasswd;
		int flag = 0;
		String curUsername = null;
		String curPassword = null;
		int curBalance = 0;
		HttpSession session=request.getSession();
		try{
			Class.forName("com.mysql.jdbc.Driver").newInstance();  
			Connection conn=DriverManager.getConnection(url);  
			Statement stmt = conn.createStatement();  
			ResultSet rs=stmt.executeQuery("select * from "+tableName);
			while(rs.next()){
				curUsername = rs.getString("username");
				curPassword = rs.getString("password");
				curBalance = rs.getInt("balance");
				if(username.equals(curUsername)&&password.equals(curPassword)){
					session.setAttribute("curUsername", curUsername);
					session.setAttribute("curBalance", curBalance);
					flag = 1;
					session.setAttribute("balance", curBalance);
				}else if(username.equals(curUsername)&&!password.equals(curPassword)){
					throw new PasswordWrongException();
				}
			}
		}catch(SQLException | InstantiationException | IllegalAccessException | ClassNotFoundException e){
			e.printStackTrace();
		}
		if(flag==0){
			throw new UserNotFoundException();
		}
	}
}

