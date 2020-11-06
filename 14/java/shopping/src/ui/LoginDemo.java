package ui;

import utils.*;

import javax.swing.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDemo extends BaseJFrame {

  private static LoginDemo loginDemo;

  //返回到原来的界面
  public static LoginDemo getInstance() {
    return loginDemo;
  }

  public LoginDemo(){
    //调用窗口关闭
    WindowClose.windowClose(this);

    init();
  }

  public void init(){
    setTitle("用户界面");
    //创建一个子容器
    JPanel jPanel = new JPanel(null);
    jPanel.setBounds(280,250,350,200);
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

    //设置单选按钮
    JRadioButton jRadioButton = new JRadioButton("顾客",true);//设置单选按钮的默认选中
    jRadioButton.setBounds(120,110,80,25);
    JRadioButton jRadioButton1 = new JRadioButton("管理员");
    jRadioButton1.setBounds(215,110,70,25);
    //设置单选按钮组
    ButtonGroup buttonGroup = new ButtonGroup();
    //添加单选按钮到单选按钮组
    buttonGroup.add(jRadioButton);
    buttonGroup.add(jRadioButton1);

    JButton jButton = new JButton("登录");
    jButton.setBounds(100,140,200,30);

    JLabel jLabel2 = new JLabel("忘记密码？");
    jLabel2.setBounds(100,175,65,25);
    JLabel jLabel3 = new JLabel("注册账号");
    jLabel3.setBounds(245,175,55,25);


    //忘记密码的鼠标处理事件
    jLabel2.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
        UpdatePassWord updatePassWord = new UpdatePassWord();
        loginDemo.openNewFrame(updatePassWord);
        //跳转时文本框清空
        jTextField.setText(null);
        jPasswordField.setText(null);
      }
    });
    JLabelMouseListener.jLabel(jLabel2,"忘记密码？");

    //注册账号的处理事件
    jLabel3.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
        RegisterDemo registerDemo = new RegisterDemo();
        loginDemo.openNewFrame(registerDemo);
        //跳转时文本框清空
        jTextField.setText(null);
        jPasswordField.setText(null);
      }
    });
    JLabelMouseListener.jLabel(jLabel3,"注册账号");

    //登录事件
    jButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        String account = jTextField.getText();
        String pwd = jPasswordField.getText();
        //判断文本框是否为空
        if(account.length()>0 && pwd.length()>0){
          //判断选择的是顾客还是管理员
          if (jRadioButton.isSelected()) {
            if (userLogin(account,pwd)) {
              JOptionPane.showMessageDialog(loginDemo,"您登录的是顾客界面！");
              UserDemo userDemo = new UserDemo();
              loginDemo.openNewFrame(userDemo);
              //跳转时文本框清空
              jTextField.setText(null);
              jPasswordField.setText(null);
            } else {
              JOptionPane.showMessageDialog(loginDemo,"账号或密码错误！");
            }
          } else if (jRadioButton1.isSelected()) {
            if (adminLogin(account,pwd)) {
              JOptionPane.showMessageDialog(loginDemo,"您登录的是管理员界面！");
              AdminDemo adminDemo = new AdminDemo();
              loginDemo.openNewFrame(adminDemo);
              //跳转时文本框清空
              jTextField.setText(null);
              jPasswordField.setText(null);
            } else {
              JOptionPane.showMessageDialog(loginDemo,"账号或密码错误！");
            }
          }
        }else{
          JOptionPane.showMessageDialog(loginDemo,"账号或密码不能为空！");
        }
      }
    });

    //将控件加到jPanel中
    jPanel.add(jLabel);
    jPanel.add(jLabel1);
    jPanel.add(jTextField);
    jPanel.add(jPasswordField);
    jPanel.add(jButton);
    jPanel.add(jLabel2);
    jPanel.add(jLabel3);
    jPanel.add(jRadioButton);
    jPanel.add(jRadioButton1);

    //将jPanel加到窗口中
    add(jPanel);

    //点击将光标移到jPanel中
    BaseJFrame.clicked(this,jPanel);

    setVisible(true);
  }

  //顾客登录方法
  public boolean userLogin(String username,String password){
    Connection connection = DBUtils.getConnection();
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    String sql = "select * from user";
    try {
      preparedStatement = connection.prepareStatement(sql);
      resultSet = preparedStatement.executeQuery();
      while (resultSet.next()){
        String account = resultSet.getString("account");
        String pwd = resultSet.getString("password");
        if(username.equals(account) && password.equals(pwd)){
          return true;
        }
      }
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      DBUtils.close(resultSet,preparedStatement,connection);
    }
    return false;
  }

  //管理员登录方法
  public boolean adminLogin (String name, String password) {
    Connection connection = DBUtils.getConnection();
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    String sql = "select * from admin";
    try {
      preparedStatement = connection.prepareStatement(sql);
      resultSet = preparedStatement.executeQuery();
      if (resultSet.next()) {
        String account = resultSet.getString("account");
        String pwd = resultSet.getString("password");
        if (name.equals(account) && password.equals(pwd)) {
          return true;
        }
      }
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    } finally {
      DBUtils.close(resultSet,preparedStatement,connection);
    }
    return false;
  }

  public static void main(String[] args){
    loginDemo = new LoginDemo();
  }

}
