package com.utte.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConnection {
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.driver.OracleDriver"); //driverManager에서 사용할 forName()에 맞는 객체를 생성
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@20.194.19.37:1521:movieDB","scott","1234");//클래스객체생성
		return conn;
	}
}
