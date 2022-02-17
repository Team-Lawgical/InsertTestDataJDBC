package com.asiana.lawgic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
	private static Connection conn;
	public static Connection getConnection(){
		if(conn!=null){
			return conn;
		}
		String url="jdbc:oracle:thin:@127.0.0.1:1521:XE";
		String user="hr";
		String password="hr";
		try {
			conn=DriverManager.getConnection(url, user, password);
			System.out.println("1,2,conn ok");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}

}
