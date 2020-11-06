package com.xb.t9;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;

public class JDBprivate {

		private static final String sql = "com.mysql.jdbc.Driver";
		private static final String url = "jdbc:mysql://localhost:3306/test";
		private static final String user = "root";
		private static final String password = "admin123";
	
		//加载驱动
		static {
			try {
				Class.forName(sql);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		//建立连接
		public static Connection getConnection() throws SQLException {
			Connection connection=null;
			try {
				connection = DriverManager.getConnection(url,user,password);
			} catch (SQLException e) {
				e.printStackTrace();
				throw e;
			}
			return connection;
		}
		
		public static void close(ResultSet resultSet,PreparedStatement preparedStatement,Connection connection) {
			if(resultSet != null) {
				try {
					resultSet.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(preparedStatement != null) {
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
		}
}
