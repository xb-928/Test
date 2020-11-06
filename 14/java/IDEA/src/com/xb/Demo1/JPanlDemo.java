package com.xb.Demo1;

import javax.swing.*;
import java.awt.*;

public class JPanlDemo {
  public static void main(String[] args){
    //创建父容器
    JFrame jFrame = new JFrame("JPanel");
    //设置父容器的布局为borderLayout
    BorderLayout borderLayout = new BorderLayout();
    jFrame.getContentPane().setLayout(borderLayout);
    //创建子容器
    JPanel jPanel = new JPanel();
    //设置子容器的布局为网格布局
    GridLayout gridLayout = new GridLayout();
    jPanel.setLayout(gridLayout);
    //设置行数
    gridLayout.setRows(2);
    //设置垂直间距
    gridLayout.setVgap(10);
    //设置水平间距
    gridLayout.setHgap(-100);
    //创建子容器的控件
    JLabel jLabel = new JLabel("用户名：");
    JTextField jTextField = new JTextField();
    JLabel jLabel1 = new JLabel("密码：");
    JPasswordField jPasswordField = new JPasswordField();
    //添加子控件到JPanel
    jPanel.add(jLabel);
    jPanel.add(jTextField);
    jPanel.add(jLabel1);
    jPanel.add(jPasswordField);
    //添加子容器到父容器，并设置为中间位置
    jFrame.add(jPanel,BorderLayout.CENTER);
    //创建子容器
    JPanel jPanel1 = new JPanel();
    //设置子容器的布局为流式布局
    FlowLayout flowLayout = new FlowLayout();
    jPanel1.setLayout(flowLayout);
    //创建jPanel1的控件
    JButton jButton = new JButton("登录");
    JButton jButton1 = new JButton("注册");
    //将控件添加到jPanel1
    jPanel1.add(jButton);
    jPanel1.add(jButton1);
    //将jPanel1添加到父容器
    jFrame.add(jPanel1,BorderLayout.SOUTH);
    //设置关闭模式
    jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    //设置父容器的大小及位置
    jFrame.setBounds(300,300,300,160);
    //设置为可见
    jFrame.setVisible(true);
  }
}
