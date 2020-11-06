package dao;

import java.sql.*;

public class DBUtils {
  static {
    try {
      Class.forName("com.mysql.jdbc.Driver");
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }
  }

  public static Connection getConnection() {
    try {
      return DriverManager.getConnection("jdbc:mysql://localhost:3306/db_ofo_users?characterEncoding=utf8", "root", "admin123");
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return null;
  }

  public static void close(ResultSet resultSet, PreparedStatement preparedStatement, Connection connection) {
    try {
      if (resultSet != null) {
        resultSet.close();
      }
      if (preparedStatement != null) {
        preparedStatement.close();
      }
      if (connection != null) {
        connection.close();
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

}
