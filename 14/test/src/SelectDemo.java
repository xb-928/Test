import dao.Dao;
import model.User;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class SelectDemo extends JFrame {
  private JPanel jPanel;
  private JTable table1;
  private JButton jButton;
  private JButton jButton1;
  private JButton jButton2;
  private ArrayList<User> list;
  private JFrame frame;

  public SelectDemo() {
    //删除
    jButton2.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        int i = table1.getSelectedRow();
        if (i == -1) {
          JOptionPane.showMessageDialog(jPanel,"请选择您要删除的一行数据");
        } else {
          int flag = JOptionPane.showConfirmDialog(frame,"确定删除吗？","提示",JOptionPane.YES_NO_CANCEL_OPTION);
          if (flag == 0) {
            if (Dao.deleteUser(list.get(i).getId())) {
              JOptionPane.showMessageDialog(jPanel,"删除成功！");
              frame.setVisible(false);
              SelectDemo selectDemo = new SelectDemo();
              selectDemo.init();
            } else {
              JOptionPane.showMessageDialog(jPanel,"删除失败！");
            }
          }
        }
      }
    });
    //修改
    jButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        int i = table1.getSelectedRow();
        if (i == -1) {
          JOptionPane.showMessageDialog(jPanel,"请选择一行数据进行修改");
        } else {
          frame.setVisible(false);
          UpdateDemo updateDemo = new UpdateDemo(i);
          updateDemo.init();
        }
      }
    });
    //增加
    jButton1.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        frame.setVisible(false);
        InsertDemo insertDemo = new InsertDemo();
        insertDemo.init();
      }
    });
  }

  private void createUIComponents() {
    // TODO: place custom component creation code here
    list = Dao.selectUser();
    Object[] head = {"编号","姓名","账户余额","骑行里程"};
    Object[][] data = new Object[list.size()][4];
    for (int i = 0; i < list.size(); i++) {
      data[i][0] = list.get(i).getId();
      data[i][1] = list.get(i).getName();
      data[i][2] = list.get(i).getBalance();
      data[i][3] = list.get(i).getMileage();
    }
    table1 = new JTable(data,head);
  }

  public static void main(String[] args) {
    SelectDemo selectDemo = new SelectDemo();
    selectDemo.init();
  }

  public void init() {
    frame = new JFrame("SelectDemo");
    frame.setContentPane(jPanel);
    frame.setBounds(300,100,0,0);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.pack();
    frame.setVisible(true);
  }
}
