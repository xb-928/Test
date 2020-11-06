package DAO;

import Moule.Entity;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;

public class Demo extends JFrame {


  public Demo(){
    JFrame jFrame = new JFrame();
    jFrame.setLayout(new BorderLayout());
    JPanel jPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
    jPanel.setBounds(200,100,1500,40);
    //设置位置大小
    jFrame.setBounds(200,100,1500,800);
    JButton jButton = new JButton("修改");
    JButton jButton1 = new JButton("增加");
    JButton jButton2 = new JButton("删除");
    //调用关闭方法
    Utils.windowClose(jFrame);
    List<Entity> list = Dao.getSelect();
    String[] head = {"序号","姓名","账户余额（元）","骑行里程（KM）"};
    String[][] data = new String[list.size()][4];
    for (int i = 0;i<list.size();i++){
      Entity entity = list.get(i);
      data[i][0] = String.valueOf(entity.getId());
      data[i][1] = entity.getName();
      data[i][2] = String.valueOf(entity.getBalance());
      data[i][3] = String.valueOf(entity.getMileage());
    }
    JTable jTable = new JTable(data,head);
    JScrollPane jScrollPane = new JScrollPane(jTable,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

    //增加数据
    jButton1.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        jFrame.setVisible(false);
        InsertUser insertUser = new InsertUser();
        insertUser.createView();
      }
    });

    //删除数据
    jButton2.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        int i = jTable.getSelectedRow();
        int id = list.get(i).getId();
        String name = list.get(i).getName();
        float balance = list.get(i).getBalance();
        float mileage = list.get(i).getMileage();
        if (i==-1) {
          JOptionPane.showMessageDialog(jFrame,"请选择要删除的一行数据");
        }else {
          int t = JOptionPane.showConfirmDialog(jFrame,"确定要删除吗？","提示",JOptionPane.YES_NO_OPTION);
          if (t==0) {
            if (Dao.deleteUser(id,name,balance,mileage)) {
              JOptionPane.showMessageDialog(jFrame,"删除成功");
              jFrame.setVisible(false);
              Demo demo = new Demo();
            }else {
              JOptionPane.showMessageDialog(jFrame,"删除失败");
            }
          }
        }
      }
    });

    //修改按钮弹窗
    jButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        if (jTable.getSelectedRow()==-1) {
          JOptionPane.showMessageDialog(jFrame,"请选中一行数据进行修改！");
        }else {
          UpdateDemo updateDemo = new UpdateDemo(jTable.getSelectedRow());
          jFrame.setVisible(false);
        }
      }
    });

    jPanel.add(jButton1);
    jPanel.add(jButton2);
    jPanel.add(jButton);
    jFrame.add(jPanel,BorderLayout.NORTH);
    jFrame.add(jScrollPane,BorderLayout.CENTER);
    jFrame.setVisible(true);
  }

  public static void main(String[] args) {
    Demo demo = new Demo();
  }
}
