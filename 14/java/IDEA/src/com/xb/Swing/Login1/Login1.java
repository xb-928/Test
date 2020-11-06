package com.xb.Swing.Login1;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Login1 {
  private JTextField jTextField;
  private JPasswordField jPasswordField;
  private JButton jButton;
  private JPanel jpanel;
  private JLabel jLabel1;
  private JLabel jLabel2;
  private JButton jButton2;
  private static JFrame frame;

  public Login1() {
    jButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        String uname = jTextField.getText();
        String pwd = jPasswordField.getText();
        try {
          insert(uname,pwd);
        } catch (SQLException e1) {
          e1.printStackTrace();
        }
      }
    });
    jButton2.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        String uname = jTextField.getText();
        String pwd = jPasswordField.getText();
        login(uname,pwd);
      }
    });
  }

  public static void main(String[] args) {
    frame = new JFrame("Login1");
    frame.setContentPane(new Login1().jpanel);
    frame.setBounds(300,300,0,0);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.pack();
    frame.setVisible(true);
  }

  public boolean insert(String userName,String passWord) throws SQLException {
    Connection connection = LoginUtils.connection();
    String sql = "select * from user where username = ?";
    PreparedStatement preparedStatement = connection.prepareStatement(sql);
    preparedStatement.setString(1,userName);
    ResultSet resultSet = preparedStatement.executeQuery();
    if(resultSet.next()){
      JOptionPane.showMessageDialog(jpanel,"用户名已存在");
      return false;
    }else{
      String insertSql = "insert into user(username,password) value(?,?) ";
      preparedStatement = connection.prepareStatement(insertSql);
      preparedStatement.setString(1,userName);
      preparedStatement.setString(2,passWord);
      int num = preparedStatement.executeUpdate();
      if(num > 0){
        JOptionPane.showMessageDialog(jpanel,"注册成功");
        return true;
      }
    }
    return false;
  }

  public boolean login(String userName,String password){
    Connection connection = LoginUtils.connection();
    String sql = "select * from user";
    try {
      PreparedStatement preparedStatement = connection.prepareStatement(sql);
      ResultSet resultSet = preparedStatement.executeQuery();
      while(resultSet.next()){
        String student = resultSet.getString("student");
        String name = resultSet.getString("username");
        String pwd = resultSet.getString("password");
        if(userName.equals(name) && password.equals(pwd)){
          JOptionPane.showMessageDialog(jpanel,"欢迎"+student+"同学");
          return true;
        }else{
          JOptionPane.showMessageDialog(jpanel,"用户名或密码错误！");
        }
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return false;
  }
}
