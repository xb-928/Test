package com.xb.t9;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcDemo1 {

	public static void main(String[] args) {
		
		Connection connection=null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		
		
		try {
			//��������������������
			connection = JDBprivate.getConnection();
			//����ִ��sql���Ķ���
			preparedStatement = connection.prepareStatement("select * from area where areaID = ?");
			//��sql����Ԥ����
			preparedStatement.setInt(1, 8);
			//ִ����䲢��������
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				int id = resultSet.getInt("areaID");
				String name = resultSet.getString("areaName");
				int p_id = resultSet.getInt("p_areaID");
				System.out.println(id+" "+name+" "+p_id);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBprivate.close(resultSet, preparedStatement, connection);
		}
		
	}
}
