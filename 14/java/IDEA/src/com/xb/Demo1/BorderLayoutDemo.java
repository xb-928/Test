package com.xb.Demo1;

import javax.swing.*;
import java.awt.*;

public class BorderLayoutDemo {
  public static void main(String[] args){
    JFrame jFrame = new JFrame("边界布局");
    //创建边界布局
    BorderLayout borderLayout = new BorderLayout();
    //设置父容器布局
//    jFrame.getContentPane().setLayout(borderLayout);
    jFrame.getContentPane().setLayout(borderLayout);
    //创建控件
    JButton jButton1 = new JButton("东");
    JButton jButton2 = new JButton("南");
    JButton jButton3 = new JButton("西");
    JButton jButton4 = new JButton("北");
    JButton jButton5 = new JButton("中");

    //添加控件到父容器
    jFrame.add(jButton1,BorderLayout.EAST);
    jFrame.add(jButton2,BorderLayout.SOUTH);
    jFrame.add(jButton3,BorderLayout.WEST);
    jFrame.add(jButton4,BorderLayout.NORTH);
    jFrame.add(jButton5,BorderLayout.CENTER);

    //设置关闭模式
    jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    //设置父容器的大小、位置
    jFrame.setBounds(400,300,500,400);

    //设置父容器为可见
    jFrame.setVisible(true);
  }
}
