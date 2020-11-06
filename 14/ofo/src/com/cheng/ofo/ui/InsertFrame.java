package com.cheng.ofo.ui;

import com.cheng.ofo.dao.Dao;
import com.cheng.ofo.model.User;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InsertFrame {
    private JPanel jPanel;
    //ID
    private JLabel textId;
    //姓名
    private JTextField textName;
    //余额
    private JTextField textBalance;
    //里程数
    private JTextField textMileage;

    private JButton insertButton;
    private JButton cancelButton;
    private JFrame frame;

    public InsertFrame() {
        //增加按钮的点击事件
        insertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = textName.getText();
                float balance = Float.parseFloat(textBalance.getText());
                float mileage = Float.parseFloat(textMileage.getText());
                if (Dao.insertUser(name, balance, mileage)) {
                    JOptionPane.showMessageDialog(frame, "新增成功");
                } else {
                    JOptionPane.showMessageDialog(frame, "新增失败");
                }
            }
        });
        //取消按钮的点击事件
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                UserFrame userFrame = new UserFrame();
                userFrame.createView();
            }
        });
    }


    /**
     * 创建视图
     */
    public void createView() {
        frame = new JFrame("增加界面");
        frame.setContentPane(jPanel);
        frame.setBounds(300, 300, 600, 600);
        frame.setVisible(true);
    }
}
