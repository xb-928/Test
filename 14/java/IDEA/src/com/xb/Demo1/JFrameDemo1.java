package com.xb.Demo1;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class JFrameDemo1 {

    public static void main(String[] args){
      JFrame jFrame = new JFrame();
      jFrame.setTitle("登录界面");
      jFrame.setBounds(650,400,400,400);
      //设置为绝对布局
      jFrame.setLayout(null);
      //添加用户名提示文字
      JLabel jLabel1 = new JLabel("用户名：");
      jLabel1.setBounds(30,30,60,30);
      //添加用户名输入框
      JTextField jTextField = new JTextField();
      jTextField.setBounds(90,30,250,30);
      //添加密码提示文字
      JLabel jLabel2 = new JLabel("密码：");
      jLabel2.setBounds(30,70,60,30);
      //添加密码输入框
      JPasswordField jPasswordField = new JPasswordField();
      jPasswordField.setBounds(90,70,250,30);
      //添加按钮组件
      JButton jButton = new JButton("登录");
      jButton.setBounds(100,120,200,30);
      jFrame.add(jLabel1);
      jFrame.add(jTextField);
      jFrame.add(jLabel2);
      jFrame.add(jPasswordField);
      jFrame.add(jButton);
      //添加点击事件
      jButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          jButton.setText("正在登录");
          String userName = jTextField.getText();
          String password = jPasswordField.getText();
          //进行登录
          if(sql(userName,password)){
            jButton.setText("登录成功");
          }else{
            jButton.setText("密码或用户名不正确！");
          }
        }
      });
      jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
      jFrame.setVisible(true);
    }
    private static boolean sql(String username,String password){
      try {
        //加载驱动
        Class.forName("com.mysql.jdbc.Driver");
      } catch (ClassNotFoundException e) {
        e.printStackTrace();
      }
      try {
        //建立连接
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/user","root","admin123");
        //创建预处理sql语句的对象
        PreparedStatement preparedStatement = connection.prepareStatement("select * from user;");
        //获取处理集
        ResultSet resultSet = preparedStatement.executeQuery();
        while(resultSet.next()){
          String name = resultSet.getString("name");
          String pwd = resultSet.getString("password");
          if(username.equals(name) && password.equals(pwd)){
            return true;
          }
        }
        resultSet.close();
        preparedStatement.close();
        connection.close();
      } catch (SQLException e) {
        e.printStackTrace();
      }
      return false;
    }


}
