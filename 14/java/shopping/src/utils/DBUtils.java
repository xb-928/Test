package utils;

import java.sql.*;

public class DBUtils {

  private static final String UIR = "com.mysql.jdbc.Driver";
  private static final String URL = "jdbc:mysql://localhost:3306/user?useUnicode=true&characterEncoding=UTF-8";
  private static final String ROOT = "root";
  private static final String PASSWORD = "admin123";

  static {
    try {
      Class.forName(UIR);
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }
  }

  //建立连接
  public static Connection getConnection(){
    try {
      Connection connection = DriverManager.getConnection(URL,ROOT,PASSWORD);
      return connection;
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return null;
  }

  //关闭数据库
  public static void close(ResultSet resultSet, PreparedStatement preparedStatement,Connection connection){

    if (resultSet != null){
      try {
        resultSet.close();
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }

    if (preparedStatement != null){
      try {
        preparedStatement.close();
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }

    if (connection != null){
      try {
        connection.close();
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }

  }

}
