package utils;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class WindowClose extends JFrame {


  //窗口关闭提示
  public static void windowClose(JFrame jFrame){
    jFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    jFrame.addWindowListener(new WindowAdapter() {
      @Override
      public void windowClosing(WindowEvent e) {
        Object[] options = {"确认","取消"};
        int flag = JOptionPane.showOptionDialog(jFrame,"确认关闭吗？","提示",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null,options,options[0]);
        if(flag == JOptionPane.YES_OPTION){
          System.exit(0);
        }else {
          return;
        }
      }
    });
  }

}
