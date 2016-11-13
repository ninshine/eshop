package com.shnu.eshop;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;

public class DBManager {
	public void dbUpdate(String sql){
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
		try{
			Class.forName(driverName);
			Connection conn=DriverManager.getConnection(url);
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(sql);
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	public ResultSet dbQuery(String sql){
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
		ResultSet rs = null;
		try{
			Class.forName(driverName);
			Connection conn=DriverManager.getConnection(url);
			Statement stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return rs;
	}
}
