package com.xb.JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCDemo {

  public void login(String UserName,String PassWord){
    Connection connection = JDBCUtils.connection();
    String sql = "select pwd from user where name = ?;";
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    try {
      preparedStatement = connection.prepareStatement(sql);
      preparedStatement.setString(1,UserName);
      resultSet = preparedStatement.executeQuery();
      while(resultSet.next()){
        String pwd = resultSet.getString("pwd");
        if(PassWord.equals(pwd)){
          System.out.println("登录成功！");
          return;
        }else{
          System.out.println("密码错误！");
        }
      }
      System.out.println("账号错误！");
    } catch (SQLException e) {
      e.printStackTrace();
    }finally{
      JDBCUtils.close(resultSet,preparedStatement,connection);
    }
  }

  public static void main(String[] args){
    JDBCDemo jdbcDemo = new JDBCDemo();
    jdbcDemo.login("admin","23");
  }
}
