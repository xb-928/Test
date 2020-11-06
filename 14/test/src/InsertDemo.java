import dao.Dao;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InsertDemo {
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JLabel jLabel;
    private JPanel jPanel;
    private JButton jButton2;
    private JButton jButton1;
    private JFrame frame;

    public InsertDemo() {
        //返回
        jButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                SelectDemo selectDemo = new SelectDemo();
                selectDemo.init();
            }
        });
        //确定增加
        jButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = textField1.getText();
                String balance = textField2.getText();
                String mileage = textField3.getText();
                if (name.length()>0 && balance.length()>0 && mileage.length()>0) {
                    if (Dao.insertUser(name,balance,mileage)) {
                        JOptionPane.showMessageDialog(frame,"添加数据成功!");
                        frame.setVisible(false);
                        SelectDemo selectDemo = new SelectDemo();
                        selectDemo.init();
                    } else {
                        JOptionPane.showMessageDialog(frame,"添加失败！");
                    }
                } else {
                    JOptionPane.showMessageDialog(frame,"请填写将数据完整");
                }
            }
        });
    }

    public void init() {
        frame = new JFrame("InsertDemo");
        frame.setContentPane(jPanel);
        frame.setBounds(300,100,0,0);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
