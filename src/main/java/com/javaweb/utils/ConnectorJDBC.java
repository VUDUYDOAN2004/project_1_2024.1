package com.javaweb.utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectorJDBC {
	static final String DB_URL = "jdbc:mysql://localhost:3306/clothingweb";
	static final String USER = "root";
	static final String PASSWORD = "";
	
	public static Connection getConnection() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return conn;
	}
}
