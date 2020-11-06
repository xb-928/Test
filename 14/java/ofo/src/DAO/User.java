package DAO;

import Moule.Entity;

import javax.swing.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class User extends JFrame {
    private JButton jButton;
    private JTable jTable;
    private JPanel jPanel;
    private JScrollPane jScrollPane;

    public User() {
        JFrame frame = new JFrame("User");
        frame.setContentPane(jPanel);
        frame.setBounds(300,200,0,0);
        frame.pack();
        frame.setVisible(true);
        //设置默认关闭模式
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        //关闭时提示
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int flag = JOptionPane.showConfirmDialog(frame,"确定关闭吗？","提示",JOptionPane.YES_NO_CANCEL_OPTION);
                if (flag==0){
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                }
            }
        });
        createUIComponents();
    }

    public List<Entity> getSelect(){
        List<Entity> list = new ArrayList<>();
        Connection connection = Utils.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql = "select * from ofo_users";
        try {
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("ofo_users_id");
                String name = resultSet.getString("ofo_users_name");
                Float balance = resultSet.getFloat("ofo_users_balance");
                Float mileage = resultSet.getFloat("ofo_users_mileage");
                Entity entity = new Entity(id,name,balance,mileage);
                list.add(entity);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

  private void createUIComponents() {
    // TODO: place custom component creation code here
    List<Entity> list = getSelect();
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
    jScrollPane = new JScrollPane(jTable,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    //获取选中的数据
    jTable.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
        int i = jTable.getSelectedRow();
        //点击按钮时弹窗
        jButton.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
            UpdateDemo updateDemo = new UpdateDemo(i);
          }
        });
        System.out.println(list.get(i));
      }
    });
  }

  public static void main(String[] args) {
    User user = new User();
  }

}
