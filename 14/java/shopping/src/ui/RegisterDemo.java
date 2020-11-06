package ui;

import utils.*;
import utils.NumberJTextField;
import javax.swing.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RegisterDemo extends BaseJFrame {

  private RegisterDemo registerDemo;

  public RegisterDemo() {
    //调用窗口关闭提示
    WindowClose.windowClose(this);

    init();
  }

  public void init(){
    setTitle("用户界面");
    //创建一个子容器
    JPanel jPanel = new JPanel(null);
    jPanel.setBounds(280,250,350,300);
    //将默认光标定位在jPanel中
    jPanel.setFocusable(true);

    JLabel jLabel = new JLabel("账号：");
    jLabel.setBounds(30,30,60,30);
    JTextField jTextField = new JTextField();
    jTextField.setBounds(100,30,200,30);
    JLabel jLabel1 = new JLabel("密码：");
    jLabel1.setBounds(30,70,60,30);
    JPasswordField jPasswordField = new JPasswordField();
    jPasswordField.setBounds(100,70,200,30);
    JLabel jLabel2 = new JLabel("手机号：");
    jLabel2.setBounds(30,110,60,30);
    JTextField jTextField1 = new JTextField();
    jTextField1.setBounds(100,110,200,30);
    JButton jButton = new JButton("注册");
    jButton.setBounds(100,150,200,30);
    JLabel jLabel3 = new JLabel("← 返回登录");
    jLabel3.setBounds(100,190,70,25);

    //返回登录的鼠标处理事件
    registerDemo = this;
    BaseJFrame.jLabelOpenLoginDemo(registerDemo,jLabel3);
    JLabelMouseListener.jLabel(jLabel3,"← 返回登录");

    //将控件添加到jPanel
    jPanel.add(jLabel);
    jPanel.add(jLabel1);
    jPanel.add(jLabel2);
    jPanel.add(jTextField);
    jPanel.add(jPasswordField);
    jPanel.add(jTextField1);
    jPanel.add(jButton);
    jPanel.add(jLabel3);

    //设置jTextField1文本框只能输入数字
    NumberJTextField.numberJTextField(jTextField1);

    //注册事件
    jButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        String name = jTextField.getText();
        String pwd = jPasswordField.getText();
        String phone = jTextField1.getText();
            if (name.length()>0 && pwd.length()>0 && phone.length()>0){
              if(pwd.length()>=6 && pwd.length()<=18 && phone.length()==11){
                if (register(name,pwd,phone)){
                  registerDemo.openNewFrame(LoginDemo.getInstance());
                }
              }else if ((pwd.length()<6 || pwd.length()>18) && phone.length()==11){
                JOptionPane.showMessageDialog(registerDemo,"密码必须在6位到18位之间");
              }else if ((pwd.length()<6 || pwd.length()>18) && phone.length()!=11){
                JOptionPane.showMessageDialog(registerDemo,"密码必须在6位到18位之间");
              }else {
                JOptionPane.showMessageDialog(registerDemo,"手机号为11位数");
              }
            }else if((name.length()<=0 || pwd.length()<=0) && (phone.length()>0 || phone.length()<=0)) {
              JOptionPane.showMessageDialog(registerDemo,"账号或密码不能为空！");
            }else {
              JOptionPane.showMessageDialog(registerDemo,"手机号不能为空");
            }
      }
    });

    //点击将光标移到jPanel中
    BaseJFrame.clicked(this,jPanel);

    add(jPanel);

  }

  //注册方法
  public boolean register(String userName,String password,String phone){
    Connection connection = DBUtils.getConnection();
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    String sql = "select * from user where account = ?";
    try {
      preparedStatement = connection.prepareStatement(sql);
      preparedStatement.setString(1,userName);
      resultSet = preparedStatement.executeQuery();
      if(resultSet.next()){
        JOptionPane.showMessageDialog(registerDemo,"账号已存在");
        return false;
      }else {
        String insertSql = "insert into user(account,password,phone) value(?,?,?)";
        preparedStatement = connection.prepareStatement(insertSql);
        preparedStatement.setString(1,userName);
        preparedStatement.setString(2,password);
        preparedStatement.setString(3,phone);
        int num = preparedStatement.executeUpdate();
        if (num > 0){
          JOptionPane.showMessageDialog(registerDemo,"注册成功！");
          return true;
        }else {
          JOptionPane.showMessageDialog(registerDemo,"注册失败！");
        }
      }
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    } finally {
      DBUtils.close(resultSet,preparedStatement,connection);
    }
    return false;
  }

}
