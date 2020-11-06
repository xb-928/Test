package Swing;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.*;

public class Demo extends JFrame {


  public Demo(){
    init();
  }
  public void init(){
    this.setTitle("Swing");
    this.setLayout(null);
    this.setBounds(400,400,1000,800);
    JLabel jLabel = new JLabel("用户名：");
    JLabel jLabel1 = new JLabel("密码：");
    JTextField jTextField = new JTextField();
    JPasswordField jPasswordField = new JPasswordField();
    JLabel jLabel2 = new JLabel("注册");
    jLabel2.setBounds(45,90,60,30);
    JButton jButton = new JButton("登录");

    jLabel1.setBounds(45,50,60,30);
    jTextField.setBounds(120,0,200,30);
    jPasswordField.setBounds(120,50,200,30);
    jButton.setBounds(140,90,150,35);
    jLabel2.addMouseListener(new MouseListener() {
      @Override
      public void mouseClicked(MouseEvent e) {
        JOptionPane.showMessageDialog(null,"您正在注册中...");
      }

      @Override
      public void mousePressed(MouseEvent e) {

      }

      @Override
      public void mouseReleased(MouseEvent e) {

      }

      @Override
      public void mouseEntered(MouseEvent e) {

      }

      @Override
      public void mouseExited(MouseEvent e) {

      }
    });
    jButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        jButton.setText("正在登录中");
        String name = jTextField.getText();
        String pwd = jPasswordField.getText();
        if(sql(name,pwd)){
          jButton.setText("登录成功");
        }else{
          jButton.setText("登录失败");
        }
      }
    });
    this.add(jLabel);
    this.add(jLabel1);
    this.add(jTextField);
    this.add(jPasswordField);
    this.add(jButton);
    this.add(jLabel2);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
  public boolean sql(String userName,String password){
    //加载驱动
    try {
      Class.forName("com.mysql.jdbc.Driver");
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }
    //建立连接
    try {
      Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","admin123");
      //获取执行sql语句的对象
      PreparedStatement preparedStatement = connection.prepareStatement("select * from admin;");
      //获取处理集
      ResultSet resultSet = preparedStatement.executeQuery();
      while(resultSet.next()){
        int id = resultSet.getInt("adminID");
        String name = resultSet.getString("adminName");
        String pwd = resultSet.getString("pwd");
        if(userName.equals(name) && password.equals(pwd)){
          return true;
        }
      }
      resultSet.close();
      preparedStatement.close();
      connection.close();
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return false;
  }
  public static void main(String[] args){
    Demo demo = new Demo();
    demo.setVisible(true);
  }

}
