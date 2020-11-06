package com.cheng.ofo.ui;

import com.cheng.ofo.dao.Dao;
import com.cheng.ofo.model.User;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditFrame {
    private JPanel jPanel;
    //ID
    private JLabel textId;
    //姓名
    private JTextField textName;
    //余额
    private JTextField textBalance;
    //里程数
    private JTextField textMileage;

    private JButton editButton;
    private JButton cancelButton;
    private User user;
    private JFrame frame;

    /**
     * 构造方法
     *
     * @param user User对象
     */
    public EditFrame(User user) {
        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id = Integer.parseInt(textId.getText());
                String name = textName.getText();
                float balance = Float.parseFloat(textBalance.getText());
                float mileage = Float.parseFloat(textMileage.getText());
                if (Dao.updateUser(id, name, balance, mileage)) {
                    JOptionPane.showMessageDialog(jPanel, "修改成功");
                } else {
                    JOptionPane.showMessageDialog(jPanel, "修改失败");
                }
            }
        });
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                UserFrame userFrame = new UserFrame();
                userFrame.createView();
            }
        });
        //给成员变量赋值
        this.user = user;
        //给控件设置Text
        textId.setText(String.valueOf(user.getId()));
        textName.setText(user.getName());
        textBalance.setText(String.valueOf(user.getBalance()));
        textMileage.setText(String.valueOf(user.getMileage()));
    }


    /**
     * 创建视图
     */
    public void createView() {
        frame = new JFrame("编辑界面");
        frame.setContentPane(jPanel);
        frame.setBounds(300, 300, 600, 600);
        frame.setVisible(true);
    }
}
