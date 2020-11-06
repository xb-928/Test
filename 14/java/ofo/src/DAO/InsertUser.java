package DAO;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InsertUser extends JFrame {
  private JTextField textField1;
  private JTextField textField2;
  private JTextField textField3;
  private JButton jButton1;
  private JPanel jPanel;
  private JButton jButton2;
  private static JFrame frame;

  public InsertUser() {

    jButton1.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        String name = textField1.getText();
        String balance = textField2.getText();
        String mileage = textField3.getText();
        if (name.length()>0 && balance.length()>0 && mileage.length()>0) {
          int flag = JOptionPane.showConfirmDialog(jPanel,"确定增加吗？","提示",JOptionPane.YES_NO_OPTION);
          if (flag==0){
            if(Dao.insertUser(name,balance,mileage)) {
              JOptionPane.showMessageDialog(jPanel,"添加成功");
              frame.setVisible(false);
              Demo demo = new Demo();
            } else {
              JOptionPane.showMessageDialog(jPanel,"添加失败");
            }
          }
        }else {
          JOptionPane.showMessageDialog(jPanel,"请填写完整");
        }
      }
    });

    jButton2.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        frame.setVisible(false);
        Demo demo = new Demo();
      }
    });
  }

  public void createView() {
    frame = new JFrame("InsertUser");
    frame.setContentPane(new InsertUser().jPanel);
    frame.setBounds(300,200,0,0);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.pack();
    frame.setVisible(true);
  }

}
