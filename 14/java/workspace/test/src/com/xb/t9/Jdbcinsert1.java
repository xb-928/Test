package com.xb.t9;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Jdbcinsert1 {

	public static void main(String[] args) {
		try {
			//��������
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			//��������
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/a","root","admin123");
			
			//����ִ��sql���Ķ���
			PreparedStatement preparedStatement = connection.prepareStatement
					("insert into area1 values(2,'ܽ��');");
			
			int an = preparedStatement.executeUpdate();
			System.out.println(an);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
