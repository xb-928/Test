package com.xb.t9;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Jdbc {

	private static final String sql = "com.mysql.jdbc.Driver";
	private static final String url = "jdbc:mysql://localhost:3306/test";
	private static final String user = "root";
	private static final String password = "admin123";
	public static void main(String[] args) {
		
		try {
			//��������
			Class.forName(sql);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			//�������ݿ�����
			Connection connection = DriverManager.getConnection(url,user,password);
			//����Ԥ����sql���Ķ���
			String sqlStr = "select * from area";
			PreparedStatement statement = connection.prepareStatement(sqlStr);
			//ִ��sql���
			ResultSet resultSet = statement.executeQuery(sqlStr);
			//ִ�н����
			while(resultSet.next()) {
				int areaID = resultSet.getInt("areaID");
				String areaName = resultSet.getString("areaName");
				int p_areaID = resultSet.getInt("p_areaID");
				System.out.println(areaID+"\t"+areaName+"\t"+p_areaID);
			}
			connection.close();
			statement.close();
			resultSet.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
