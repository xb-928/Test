package utils;

import ui.LoginDemo;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BaseJFrame extends JFrame {

  public BaseJFrame(){
    setResizable(false);
    setLayout(null);
    setBounds(500,150,900,800);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }

  //跳转界面
  public void openNewFrame(JFrame jFrame){
    this.setVisible(false);
    jFrame.setVisible(true);
  }

  //点击文字跳转界面
  public static void jLabelOpenLoginDemo(BaseJFrame jFrame,JLabel jLabel){
    jLabel.addMouseListener(new MouseAdapter() {
      //鼠标点击
      @Override
      public void mouseClicked(MouseEvent e) {
        jFrame.openNewFrame(LoginDemo.getInstance());
      }
    });
  }

  //点击将光标移到jPanel中
  public static void clicked(BaseJFrame baseJFrame,JPanel jPanel){
    baseJFrame.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
        jPanel.grabFocus();
      }
    });
  }

}
