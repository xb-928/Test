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
			//��������������������
			connection = JDBprivate.getConnection();
			//����ִ��sql���Ķ���
			preparedStatement = connection.prepareStatement
					("insert into area(areaName,p_areaID) values('ܽ����',5)");
			
			int an = preparedStatement.executeUpdate();
			System.out.println(an);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBprivate.close(resultSet, preparedStatement, connection);
		}
		
	}
}
