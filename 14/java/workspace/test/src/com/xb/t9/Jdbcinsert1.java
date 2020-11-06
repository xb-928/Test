package com.xb.t9;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Jdbcinsert1 {

	public static void main(String[] args) {
		try {
			//加载驱动
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			//建立连接
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/a","root","admin123");
			
			//创建执行sql语句的对象
			PreparedStatement preparedStatement = connection.prepareStatement
					("insert into area1 values(2,'芙蓉');");
			
			int an = preparedStatement.executeUpdate();
			System.out.println(an);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
