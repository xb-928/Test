package com.xb.t11;

import javax.swing.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class JButtonDemo extends JFrame {
  public JButtonDemo(){
    init();
  }
  public void init(){
    setTitle("事件处理");
    setLayout(null);
    setBounds(400,400,400,400);
    JButton jButton = new JButton("按钮");
    jButton.setBounds(0,0,100,35);
    add(jButton);
    jButton.addItemListener(new ItemListener() {
      @Override
      public void itemStateChanged(ItemEvent e) {

      }
    });
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
  public static void main(String[] args){
    JButtonDemo jButtonDemo = new JButtonDemo();
    jButtonDemo.setVisible(true);
  }
}
