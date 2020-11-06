package DAO;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.*;

public class Utils extends JFrame {

  static {
    try {
      Class.forName("com.mysql.jdbc.Driver");
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }
  }

  public static Connection getConnection(){
    try {
      return DriverManager.getConnection("jdbc:mysql://localhost:3306/db_ofo_users?characterEncoding=utf8","root","admin123");
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return null;
  }

  public static void close(ResultSet resultSet, PreparedStatement preparedStatement,Connection connection) {
    if (resultSet!=null){
      try {
        resultSet.close();
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
    if (preparedStatement!=null){
      try {
        preparedStatement.close();
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
    if (connection!=null){
      try {
        connection.close();
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
  }

  //窗口关闭方法
  public static void windowClose(JFrame jFrame) {
    jFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    jFrame.addWindowListener(new WindowAdapter() {
      @Override
      public void windowClosing(WindowEvent e) {
        int flag = JOptionPane.showConfirmDialog(jFrame,"确定关闭吗？","提示",JOptionPane.YES_NO_CANCEL_OPTION);
        if (flag==0){
          jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
      }
    });
  }

}
