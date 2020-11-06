import dao.Dao;
import model.User;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.util.ArrayList;

public class UpdateDemo extends JFrame {
  private JTextField textField1;
  private JTextField textField2;
  private JTextField textField3;
  private JButton jButton1;
  private JButton jButton2;
  private JPanel jPanel;
  private JLabel jLabel;
  private JFrame frame;

  public UpdateDemo(int i) {
    ArrayList<User> list = Dao.selectUser();
    User user = list.get(i);
    jLabel.setText(String.valueOf(user.getId()));
    textField1.setText(user.getName());
    textField2.setText(String.valueOf(user.getBalance()));
    textField3.setText(String.valueOf(user.getMileage()));

    //修改
    jButton1.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        int id = Integer.parseInt(jLabel.getText());
        String name = textField1.getText();
        float balance = Float.parseFloat(textField2.getText());
        BigDecimal bigDecimal = new BigDecimal((float)balance);
        bigDecimal.setScale(1);
        float mileage = Float.parseFloat(textField3.getText());
        BigDecimal bigDecimal1 = new BigDecimal((float)mileage);
        bigDecimal1.setScale(1,BigDecimal.ROUND_HALF_UP);
        if (Dao.updateUser(id,name,balance,mileage)) {
          JOptionPane.showMessageDialog(jPanel,"修改成功！");
          frame.setVisible(false);
          SelectDemo selectDemo = new SelectDemo();
          selectDemo.init();
        } else {
          JOptionPane.showMessageDialog(jPanel,"修改失败！");
        }
      }
    });
    //返回
    jButton2.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        frame.setVisible(false);
        SelectDemo selectDemo = new SelectDemo();
        selectDemo.init();
      }
    });
  }


  public void init() {
    frame = new JFrame("UpdateDemo");
    frame.setContentPane(jPanel);
    frame.setBounds(300,150,0,0);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.pack();
    frame.setVisible(true);
  }

}
