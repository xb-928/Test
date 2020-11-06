package ui;

import utils.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UpdatePassWord extends BaseJFrame {

  private UpdatePassWord updatePassWord;

  public UpdatePassWord(){
    //调用窗口关闭提示
    WindowClose.windowClose(this);

    init();
  }

  public void init(){
    setTitle("修改界面");
    //创建一个子容器
    JPanel jPanel = new JPanel(null);
    jPanel.setBounds(280,250,350,300);
    //将默认光标定位在jPanel中
    jPanel.setFocusable(true);
    JLabel jLabel = new JLabel("账号：");
    jLabel.setBounds(30,30,60,30);
    JTextField jTextField = new JTextField();
    jTextField.setBounds(100,30,200,30);
    JLabel jLabel1 = new JLabel("手机号：");
    jLabel1.setBounds(30,70,60,30);
    JTextField jTextField1 = new JTextField();
    jTextField1.setBounds(100,70,200,30);
    JLabel jLabel2 = new JLabel("新密码：");
    jLabel2.setBounds(30,110,60,30);
    JPasswordField jPasswordField = new JPasswordField();
    jPasswordField.setBounds(100,110,200,30);
    JButton jButton = new JButton("确认");
    jButton.setBounds(100,150,200,30);
    JLabel jLabel3 = new JLabel("← 返回登录");
    jLabel3.setBounds(100,190,70,25);

    //确认的点击事件
    jButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        String name = jTextField.getText();
        String phone = jTextField1.getText();
        String pwd = jPasswordField.getText();
        if (update(name,phone,pwd)) {
          updatePassWord.openNewFrame(LoginDemo.getInstance());
        }
      }
    });

    //返回登录的鼠标处理事件
    updatePassWord = this;
    BaseJFrame.jLabelOpenLoginDemo(updatePassWord,jLabel3);
    JLabelMouseListener.jLabel(jLabel3,"← 返回登录");

    //将控件添加到jPanel
    jPanel.add(jLabel);
    jPanel.add(jLabel1);
    jPanel.add(jLabel2);
    jPanel.add(jTextField);
    jPanel.add(jTextField1);
    jPanel.add(jPasswordField);
    jPanel.add(jButton);
    jPanel.add(jLabel3);

    //设置jTextField1只能输入数字
    NumberJTextField.numberJTextField(jTextField1);

    //点击将光标移到jPanel中
    BaseJFrame.clicked(this,jPanel);

    add(jPanel);

  }

  public boolean update(String username,String phone,String password){
    Connection connection = DBUtils.getConnection();
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    String sql = "update user set password = ? where account = ? and phone = ?";
    try {
      preparedStatement = connection.prepareStatement(sql);
      preparedStatement.setString(1,password);
      preparedStatement.setString(2,username);
      preparedStatement.setString(3,phone);
      int num = preparedStatement.executeUpdate();
      if (num > 0) {
        JOptionPane.showMessageDialog(updatePassWord,"修改密码成功！");
        return true;
      } else {
        JOptionPane.showMessageDialog(updatePassWord,"修改失败！");
      }
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    } finally {
      DBUtils.close(resultSet,preparedStatement,connection);
    }
    return false;
  }

}
