package com.xb.t9;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Jdbcinsert {

	public static void main(String[] args) {
		
		Connection connection=null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			//加载驱动，并建立连接
			connection = JDBprivate.getConnection();
			//创建执行sql语句的对象
			preparedStatement = connection.prepareStatement
					("insert into area(areaName,p_areaID) values('芙蓉区',5)");
			
			int an = preparedStatement.executeUpdate();
			System.out.println(an);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBprivate.close(resultSet, preparedStatement, connection);
		}
		
	}
}
