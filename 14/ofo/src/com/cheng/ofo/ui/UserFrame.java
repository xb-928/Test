package com.cheng.ofo.ui;

import com.cheng.ofo.dao.Dao;
import com.cheng.ofo.model.User;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class UserFrame {
    private JPanel jPanel;
    private JTable table1;
    private JButton jButtonAdd;
    private JButton jButtonEdit;
    private JButton jButtonDelete;
    private JFrame frame;
    //用户列表
    private ArrayList<User>  users;
    private DefaultTableModel model;

    public UserFrame() {
        //修改按钮添加点击事件
        jButtonEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //获取选取的一行
                int position = table1.getSelectedRow();
                //如果没有选中，不进行修改
                if (position == -1) {
                    JOptionPane.showMessageDialog(frame, "请选择一行数据进行修改");
                    return;
                }
                //设置本界面为不可见
                frame.setVisible(false);
                User user = users.get(position);
                EditFrame editFrame = new EditFrame(user);
                editFrame.createView();

            }
        });

        //删除按钮点击事件
        jButtonDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int n = table1.getSelectedRow();
                User user = users.get(n);
                if(Dao.deleteUser(user.getId())) {
                    JOptionPane.showMessageDialog(frame, "删除成功");
                    //删除表数据的一行
                    model.removeRow(n);
                } else {
                    JOptionPane.showMessageDialog(frame, "删除失败");
                }
            }
        });

        jButtonAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                InsertFrame insertFrame = new InsertFrame();
                insertFrame.createView();
            }
        });
    }

    /**
     * 启动程序
     * @param args
     */
    public static void main(String[] args) {
        UserFrame userFrame = new UserFrame();
        userFrame.createView();
    }

    public void createView() {
        frame = new JFrame("主界面");
        frame.setContentPane(jPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setBounds(300,300,600,600);
        frame.setVisible(true);
    }


    private void createUIComponents() {
        String[] headers = {"序号", "姓名", "账户余额", "骑行里程"};
        //获取user list
        users = Dao.selectUser();

        Object[][] data = new Object[users.size()][4];
        for (int i = 0; i < users.size(); i++) {
            data[i][0] = users.get(i).getId();
            data[i][1] = users.get(i).getName();
            data[i][2] = users.get(i).getBalance();
            data[i][3] = users.get(i).getMileage();
        }
        //给表格数据赋值
        model = new DefaultTableModel(data, headers);
        table1 = new JTable(model);
    }
}
