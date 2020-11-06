package com.xb.Demo1;

import javax.swing.*;
import java.awt.*;

public class GridLayoutDemo {
  public static void main(String[] args){
    JFrame jFrame = new JFrame("网格布局");

    jFrame.setBounds(300,300,600,600);
    //创建网格布局
    GridLayout gridLayout = new GridLayout(4,5);
    //设置父容器的布局管理器
    jFrame.setLayout(gridLayout);

    for(int i=0;i<10;i++){
      jFrame.add(new JRadioButton("课程"+i));
//      jFrame.add(new JButton("点击登录"));
//      jFrame.add(new JTextField());
    }
    jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    jFrame.setVisible(true);
  }
}
