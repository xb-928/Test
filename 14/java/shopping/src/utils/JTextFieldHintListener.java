package utils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class JTextFieldHintListener implements FocusListener {
  private String hintText;
  private JTextField jTextField;
  public JTextFieldHintListener(String hintText,JTextField jTextField){
    this.hintText = hintText;
    this.jTextField = jTextField;
    jTextField.setText(hintText);
    jTextField.setForeground(Color.gray);
  }

  @Override
  public void focusGained(FocusEvent e) {
    String account = jTextField.getText();
    if(account.equals(hintText)){
      jTextField.setText("");
      jTextField.setForeground(Color.black);
    }
  }

  @Override
  public void focusLost(FocusEvent e) {
    String account = jTextField.getText();
    if(account.equals("")){
      jTextField.setText(hintText);
      jTextField.setForeground(Color.gray);
    }
  }
}
