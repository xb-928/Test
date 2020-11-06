package com.xb.Demo1;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends BaseJFrame{

  public Login(String title) {
    super(title);
  }

  public static void main(String[] args){
    Login login = new Login("登录界面");
    Login login1 = new Login("用户界面");
    Login login2 = new Login("注册界面");
    //父容器的布局为null
    login.setLayout(null);
    login1.setLayout(null);
    login2.setLayout(null);
    //创建login中的组件
    JButton jButton = new JButton("登录");
    JButton jButton1 = new JButton("注册");
    JLabel jLabel = new JLabel("用户名：");
    JLabel jLabel1 = new JLabel("密码：");
    JTextField jTextField = new JTextField();
    String text = jTextField.getText();
    JPasswordField jPasswordField = new JPasswordField();
    String pwd = jPasswordField.getText();
    //创建login1中的组件
    JLabel jLabel2 = new JLabel("用户名：");
    JLabel jLabel3 = new JLabel("密码：");
    JButton jButton3 = new JButton("回到登录界面");
    //创建login2中的组件
    JLabel jLabel4 = new JLabel("输入用户名：");
    JLabel jLabel5 = new JLabel("输入密码：");
    JLabel jLabel6 = new JLabel("确认密码：");
    JTextField jTextField1 = new JTextField();
    JPasswordField jPasswordField1 = new JPasswordField();
    JPasswordField jPasswordField2 = new JPasswordField();
    JButton jButton2 = new JButton("完成");
    //设置login中组件的位置
    jLabel.setBounds(30,30,80,30);
    jLabel1.setBounds(30,75,80,30);
    jTextField.setBounds(120,30,150,30);
    jPasswordField.setBounds(120,75,150,30);
    jButton.setBounds(30,120,60,30);
    jButton1.setBounds(180,120,60,30);
    //设置login1中组件的位置
    jButton3.setBounds(60,120,150,40);
    jLabel2.setBounds(30,30,250,30);
    jLabel3.setBounds(30,70,250,30);
    //设置login2中组件的位置
    jLabel4.setBounds(30,30,80,30);
    jLabel5.setBounds(30,75,80,30);
    jLabel6.setBounds(30,120,80,30);
    jTextField1.setBounds(120,30,150,30);
    jPasswordField1.setBounds(120,75,150,30);
    jPasswordField2.setBounds(120,120,150,30);
    jButton2.setBounds(120,170,150,40);

    //添加事件
    jButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        login.openNewFrame(login1);
      }
    });
    jButton1.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        login.openNewFrame(login2);
      }
    });
    jButton2.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        login2.openNewFrame(login);
      }
    });
    jButton3.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        login1.openNewFrame(login);
      }
    });
    //添加login中的按钮
    login.add(jButton);
    login.add(jButton1);
    login.add(jLabel);
    login.add(jLabel1);
    login.add(jTextField);
    login.add(jPasswordField);
    //添加login1中的按钮
    login1.add(jButton3);
    login1.add(jLabel2,null);
    login1.add(jLabel3,null);
    //添加login2 中的按钮
    login2.add(jButton2);
    login2.add(jLabel4);
    login2.add(jLabel5);
    login2.add(jLabel6);
    login2.add(jPasswordField2);
    login2.add(jTextField1);
    login2.add(jPasswordField1);
    //设置为可见
    login.setVisible(true);

  }

}
