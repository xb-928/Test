package com.xb.t10;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class SwingDemo {

    public static void main(String[] args){
      JFrame jFrame = new JFrame();
      jFrame.setTitle("��¼����");
      jFrame.setBounds(650,400,400,400);
      //����Ϊ���Բ���
      jFrame.setLayout(null);
      //����û�����ʾ����
      JLabel jLabel1 = new JLabel("�û�����");
      jLabel1.setBounds(30,30,60,30);
      //����û��������
      JTextField jTextField = new JTextField();
      jTextField.setBounds(90,30,250,30);
      //���������ʾ����
      JLabel jLabel2 = new JLabel("���룺");
      jLabel2.setBounds(30,70,60,30);
      //������������
      JPasswordField jPasswordField = new JPasswordField();
      jPasswordField.setBounds(90,70,250,30);
      //��Ӱ�ť���
      JButton jButton = new JButton("��¼");
      jButton.setBounds(100,120,200,30);
      jFrame.add(jLabel1);
      jFrame.add(jTextField);
      jFrame.add(jLabel2);
      jFrame.add(jPasswordField);
      jFrame.add(jButton);
      //��ӵ���¼�
      jButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          jButton.setText("���ڵ�¼");
          String userName = jTextField.getText();
          String password = jPasswordField.getText();
          //���е�¼
          if(sql(userName,password)){
            jButton.setText("��¼�ɹ�");
          }else{
            jButton.setText("������û�������ȷ��");
          }
        }
      });
      jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
      jFrame.setVisible(true);
    }
    private static boolean sql(String username,String password){
      try {
        //��������
        Class.forName("com.mysql.jdbc.Driver");
      } catch (ClassNotFoundException e) {
        e.printStackTrace();
      }
      try {
        //��������
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","admin123");
        //����Ԥ����sql���Ķ���
        PreparedStatement preparedStatement = connection.prepareStatement("select * from admin;");
        //��ȡ����
        ResultSet resultSet = preparedStatement.executeQuery();
        while(resultSet.next()){
          String name = resultSet.getString("adminName");
          String pwd = resultSet.getString("pwd");
          if(username.equals(name) && password.equals(pwd)){
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
}
