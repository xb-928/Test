package DAO;


import Moule.Entity;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class UpdateDemo extends JFrame {

  public UpdateDemo(int i){
    init(i);
  }

  public void init(int i) {
    JFrame jFrame = new JFrame();
    jFrame.setBounds(700,200,500,400);
    //显示在屏幕的正中央
    jFrame.setLocationRelativeTo(null);
    jFrame.setLayout(null);
    jFrame.setResizable(false);
    JLabel jLabel = new JLabel("编号");
    jLabel.setBounds(50,50,60,30);
    JLabel jLabel1 = new JLabel("姓名");
    jLabel1.setBounds(50,90,60,30);
    JLabel jLabel2 = new JLabel("账户余额");
    jLabel2.setBounds(50,130,100,30);
    JLabel jLabel3 = new JLabel("骑行里程");
    jLabel3.setBounds(50,170,100,30);
    JLabel jLabel4 = new JLabel();
    jLabel4.setBounds(150,50,150,30);
    JTextField jTextField1 = new JTextField();
    jTextField1.setBounds(150,90,150,30);
    JTextField jTextField2 = new JTextField();
    jTextField2.setBounds(150,130,150,30);
    JTextField jTextField3 = new JTextField();
    jTextField3.setBounds(150,170,150,30);
    JButton jButton = new JButton("修改");
    jButton.setBounds(100,220,60,30);
    JButton jButton1 = new JButton("返回");
    jButton1.setBounds(300,220,60,30);
    //获取选中的数据并显示在文本框里
    List<Entity> list = Dao.getSelect();
    Entity entity = list.get(i);
    jLabel4.setText(String.valueOf(entity.getId()));
    jTextField1.setText(entity.getName());
    jTextField2.setText(String.valueOf(entity.getBalance()));
    jTextField3.setText(String.valueOf(entity.getMileage()));
    //修改的点击事件
    jButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        int id = Integer.parseInt(jLabel4.getText());
        String name = jTextField1.getText();
        Float balance = Float.valueOf(jTextField2.getText());
        Float mileage = Float.valueOf(jTextField3.getText());
        if(Dao.updateUser(id,name,balance,mileage)) {
          JOptionPane.showMessageDialog(jFrame,"修改成功");
          jFrame.setVisible(false);
          Demo demo = new Demo();
        } else {
          JOptionPane.showMessageDialog(jFrame,"修改失败");
        }
      }
    });
    //返回的点击事件
    jButton1.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        jFrame.setVisible(false);
      }
    });
    jFrame.add(jLabel);
    jFrame.add(jLabel4);
    jFrame.add(jLabel1);
    jFrame.add(jTextField1);
    jFrame.add(jLabel2);
    jFrame.add(jTextField2);
    jFrame.add(jLabel3);
    jFrame.add(jTextField3);
    jFrame.add(jButton);
    jFrame.add(jButton1);
    jFrame.setVisible(true);
  }


}
