package ui;

import utils.BaseJFrame;
import utils.JLabelMouseListener;
import utils.WindowClose;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserDemo extends BaseJFrame {

    private UserDemo userDemo;

    public UserDemo() {
        //调用窗口关闭提示
        WindowClose.windowClose(this);

        init();
    }

    public void init() {

        setTitle("用户界面");
        JPanel jPanel = new JPanel();
        jPanel.setLayout(new GridLayout(1,1));
        //创建选项卡面板
        JTabbedPane jTabbedPane = new JTabbedPane(JTabbedPane.TOP);

        //创建选项卡
        JPanel jPanel1 = new JPanel();
        JPanel jPanel2 = new JPanel();
        JPanel jPanel3 = new JPanel();
        JPanel jPanel4 = new JPanel();
        JPanel jPanel5 = new JPanel();
        //添加到面板
        jTabbedPane.addTab("主页",null,jPanel1,"主页");
        jTabbedPane.addTab("搜索",null,jPanel2,"搜索");
        jTabbedPane.addTab("分类",null,jPanel3,"分类");
        jTabbedPane.addTab("个人信息",null,jPanel4,"个人信息");
        jTabbedPane.addTab("设置",null,jPanel5,"设置");

        JButton jButton = new JButton("按钮");
        jButton.setBounds(0,60,100,30);

        jPanel5.setLayout(null);

        jButton.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
            Thread thread = new Thread(new Runnable() {
              @Override
              public void run() {
                int x=0;
                while (true){
                  try {
                    Thread.sleep(10);
                  } catch (InterruptedException e) {
                    e.printStackTrace();
                  }
                  jButton.setBounds(x++,60,100,30);
                  if (x==800){
                    x=-100;
                  }
                }
              }
            });
            thread.start();
          }
        });

        JLabel jLabel = new JLabel("退出登录");
        jLabel.setBounds(0,0,80,30);
        jPanel5.add(jLabel);
        jPanel5.add(jButton);


        userDemo = this;
        BaseJFrame.jLabelOpenLoginDemo(userDemo,jLabel);
        JLabelMouseListener.jLabel(jLabel,"退出登录");

        setLayout(new BorderLayout());
        add(jPanel,BorderLayout.NORTH);
        add(jTabbedPane,BorderLayout.CENTER);

    }

}
