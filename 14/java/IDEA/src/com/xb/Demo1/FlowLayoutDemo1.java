package com.xb.Demo1;

import javax.swing.*;
import java.awt.*;

public class FlowLayoutDemo1 {
  public static void main(String[] args){

    //创建父容器
    JFrame jFrame = new JFrame("流式布局");
    //设置父容器的大小
    jFrame.setBounds(300,200,500,300);
    //创建布局管理器
    FlowLayout flowLayout = new FlowLayout(FlowLayout.CENTER,20,20);
    //设置父容器的布局管理器
    jFrame.setLayout(flowLayout);
    for (int i=0;i<10;i++){
      jFrame.add(new JButton("登录"));
    }
    for(int i=0;i<5;i++){
      jFrame.add(new JLabel("lable"+i));
    }
    //设置关闭方法
    jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    //显示父容器
    jFrame.setVisible(true);
  }
}
