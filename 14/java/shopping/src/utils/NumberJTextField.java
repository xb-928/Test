package utils;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class NumberJTextField {

  //只能输入数字的文本框
  public static void numberJTextField(JTextField jTextField){
    jTextField.addKeyListener(new KeyAdapter() {
      @Override
      public void keyTyped(KeyEvent e) {
        if ((e.getKeyChar() >= e.VK_0 && e.getKeyChar() <= e.VK_9)){
          return;
        }else{
          e.consume();
        }
      }
    });
  }
}
