package com.xb.Demo1;

import java.sql.*;

public class jdbcDemo1 {

  private static final String sql = "com.mysql.jdbc.Driver";
  private static final String url = "jdbc:mysql://localhost:3306/test";
  private static final String user = "root";
  private static final String password = "admin123";
  public static void main(String[] args) {
    try {
      //加载驱动
      Class.forName(sql);
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }
    try {
      //建立数据库连接
      Connection connection = DriverManager.getConnection(url,user,password);
      //创建预处理sql语句的对象
      String sqlStr = "select * from area";
      PreparedStatement statement = connection.prepareStatement(sqlStr);
      //执行sql语句
      ResultSet resultSet = statement.executeQuery(sqlStr);
      //执行结果集
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
