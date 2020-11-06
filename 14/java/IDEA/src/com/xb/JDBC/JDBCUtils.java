package com.xb.JDBC;

import java.sql.*;

public class JDBCUtils {

  private static final String DRIVERNAME = "com.mysql.jdbc.Driver";
  private static final String URL = "jdbc:mysql://localhost:3306/user";
  private static final String USERNAME = "root";
  private static final String PASSWORD = "admin123";

  static{
    try {
      Class.forName(DRIVERNAME);
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }
  }

  public static Connection connection(){
    try {
      Connection connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
      return  connection;
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return null;
  }

  public static void close(ResultSet resultSet, PreparedStatement preparedStatement,Connection connection){
    if(resultSet != null){
      try {
        resultSet.close();
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }

    if(preparedStatement != null){
      try {
        preparedStatement.close();
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }

    if(connection != null){
      try {
        connection.close();
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }

  }
}
