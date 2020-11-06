package ui;

import utils.BaseJFrame;
import utils.JLabelMouseListener;
import utils.WindowClose;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AdminDemo extends BaseJFrame {

    private AdminDemo adminDemo;

    public AdminDemo() {
        //调用窗口关闭
        WindowClose.windowClose(this);

        init();
    }

    public void init() {

        setTitle("管理员界面");
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
        jTabbedPane.addTab("查看用户信息",null,jPanel1,"查看用户信息");
        jTabbedPane.addTab("查看商品信息",null,jPanel2,"查看商品信息");
        jTabbedPane.addTab("添加商品",null,jPanel3,"添加商品");
        jTabbedPane.addTab("删除商品",null,jPanel4,"删除商品");
        jTabbedPane.addTab("设置",null,jPanel5,"设置");

        JLabel jLabel = new JLabel("退出登录");
        jPanel5.add(jLabel,BorderLayout.CENTER);

        adminDemo = this;
        BaseJFrame.jLabelOpenLoginDemo(adminDemo,jLabel);
        JLabelMouseListener.jLabel(jLabel,"退出登录");

        setLayout(new BorderLayout());
        add(jPanel,BorderLayout.NORTH);
        add(jTabbedPane,BorderLayout.CENTER);

    }

}
