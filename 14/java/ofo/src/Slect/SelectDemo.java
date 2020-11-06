package Slect;

import Moule.Entity;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class SelectDemo {
  private JTextField jTextField;
  private JButton jButton;
  private JTable jTable;
  private JPanel jPanel;
  private JScrollPane jScrollPane;
  private JLabel jLabel;

  public SelectDemo() {
    jButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        String name = jTextField.getText();
        List<Entity> list = Dao.selectUser(name);
        String[] head = {"序号","姓名","账户余额（元）","骑行里程（KM）"};
        String[][] data = new String[list.size()][4];
        for (int i = 0;i<list.size();i++){
          Entity entity = list.get(i);
          data[i][0] = String.valueOf(entity.getId());
          data[i][1] = entity.getName();
          data[i][2] = String.valueOf(entity.getBalance());
          data[i][3] = String.valueOf(entity.getMileage());
        }
        jTable = new JTable(data,head);
      }
    });
  }

  private void createUIComponents() {

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
      jTable = new JTable(data,head);
  }


  public static void main(String[] args) {
    JFrame frame = new JFrame("SelectDemo");
    frame.setContentPane(new SelectDemo().jPanel);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.pack();
    frame.setVisible(true);
  }

}
