package utils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class JLabelMouseListener {

  public static void jLabel(JLabel jLabel,String text){
    jLabel.addMouseListener(new MouseAdapter() {
      //鼠标移到控件上
      @Override
      public void mouseEntered(MouseEvent e) {
        jLabel.setText("<html><u>"+text+"</u></html>");
        jLabel.setForeground(Color.blue);
      }

      //鼠标移开控件
      @Override
      public void mouseExited(MouseEvent e) {
        jLabel.setText(text);
        jLabel.setForeground(Color.black);
      }
    });

  }

}
