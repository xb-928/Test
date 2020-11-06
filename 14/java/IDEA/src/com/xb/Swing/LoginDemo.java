package com.xb.Swing;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.sql.*;

public class LoginDemo extends JFrame {

  JTextField jTextField;
  JPasswordField jPasswordField;
  Connection connection = null;
  PreparedStatement preparedStatement = null;
  ResultSet resultSet = null;

  public LoginDemo(){
    super("登录界面");
    init();
  }

  public void init(){
    //设置为绝对布局
    setLayout(null);
    //设置位置
    setBounds(300,300,500,500);
    //设置默认关闭模式
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    //创建文本
    JLabel jLabel = new JLabel("用户名：");
    JLabel jLabel1 = new JLabel("密码：");

    //设置文本的大小
    jLabel.setBounds(50,50,60,30);
    jLabel1.setBounds(50,100,60,30);

    //创建文本框
    jTextField = new JTextField();
    jTextField.setBounds(120,50,200,30);

    //创建密码框
    jPasswordField = new JPasswordField();
    jPasswordField.setBounds(120,100,200,30);

    //创建按钮
    JButton jButton = new JButton("登录");
    jButton.setBounds(140,150,150,30);
    jButton.addActionListener(new AbstractAction() {
      @Override
      public void actionPerformed(ActionEvent e) {
        String uname = jTextField.getText();
        String pwd = jPasswordField.getText();
        if(login(uname,pwd)){
          jButton.setText("登录成功!");
        }else {
          jButton.setText("用户名或密码错误!");
        }
      }
    });

    //添加控件
    add(jLabel);
    add(jLabel1);
    add(jTextField);
    add(jPasswordField);
    add(jButton);

  }

  public boolean login(String userName,String password){
    //加载驱动
    try {
      Class.forName("com.mysql.jdbc.Driver");
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }
    //建立连接
    try {
      connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/user","root","admin123");
      String sql = "select pwd from user where name = ?";
      preparedStatement = connection.prepareStatement(sql);
      preparedStatement.setString(1,userName);
      resultSet = preparedStatement.executeQuery();
      while(resultSet.next()){
        String pwd = resultSet.getString("pwd");
        if(pwd.equals(password)){
          return true;
        }
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }finally {
      close();
    }
    return false;
  }

  public void close(){
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

  public static void main(String[] args){
    LoginDemo loginDemo = new LoginDemo();
    loginDemo.setVisible(true);
  }
}
