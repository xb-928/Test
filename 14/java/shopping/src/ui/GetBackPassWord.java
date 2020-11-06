package ui;

import utils.BaseJFrame;
import utils.JLabelMouseListener;
import utils.NumberJTextField;
import utils.WindowClose;

import javax.swing.*;

public class GetBackPassWord extends BaseJFrame {

  private GetBackPassWord getBackPassWord;

  public GetBackPassWord(){
    init();
  }

  public void init(){
    setTitle("修改界面");
    //创建一个子容器
    JPanel jPanel = new JPanel(null);
    jPanel.setBounds(180,120,350,300);
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

    //返回登录的鼠标处理事件
    getBackPassWord = this;
    BaseJFrame.jLabelOpenLoginDemo(getBackPassWord,jLabel3);
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

    add(jPanel);

    //调用窗口关闭提示
    WindowClose.windowClose(this);

  }

}
