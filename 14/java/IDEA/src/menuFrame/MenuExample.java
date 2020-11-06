package menuFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class MenuExample extends BaseJFrame {
  public MenuExample(String title){
    super(title);
  }
  public void init(){
    this.setLayout(new FlowLayout());
    //创建菜单工具栏
    JMenuBar jMenuBar = new JMenuBar();
    //创建菜单条
    JMenu jMenu = new JMenu("文件(File)");
    jMenu.setMnemonic('F');
    JMenu jMenu1 = new JMenu("编辑(Edit)");
    jMenu1.setMnemonic('E');
    JMenu jMenu2 = new JMenu("资源(Source)");
    jMenu2.setMnemonic('S');
    JMenu jMenu3 = new JMenu("导航(Navigate)");
    jMenu3.setMnemonic('N');
    JMenu jMenu4 = new JMenu("帮助(Help)");
    jMenu4.setMnemonic('H');
    //创建菜单项
    JMenuItem jMenuItem = new JMenuItem("新建(N)");
    jMenuItem.setMnemonic('N');
    JMenuItem jMenuItem1 = new JMenuItem("打开(O)");
    jMenuItem1.setMnemonic('O');
    JMenuItem jMenuItem2 = new JMenuItem("保存(S)");
    jMenuItem2.setMnemonic('S');
    //将菜单项添加到菜单条中
    jMenu.add(jMenuItem);
    jMenu.add(jMenuItem1);
    jMenu.add(jMenuItem2);
    //将菜单条添加到菜单工具栏中
    jMenuBar.add(jMenu);
    jMenuBar.add(jMenu1);
    jMenuBar.add(jMenu2);
    jMenuBar.add(jMenu3);
    jMenuBar.add(jMenu4);
    //将菜单工具栏添加到JFrame中
    this.add(jMenuBar);

  }
  public void init1(){
    //复选框
    JCheckBox jCheckBox = new JCheckBox("中国");
    JCheckBox jCheckBox1 = new JCheckBox("英国");
    JCheckBox jCheckBox2 = new JCheckBox("美国");
    JCheckBox jCheckBox3 = new JCheckBox("韩国");
    this.add(jCheckBox);
    this.add(jCheckBox1);
    this.add(jCheckBox2);
    this.add(jCheckBox3);
  }
  public void init2(){
    //单选框
    ButtonGroup buttonGroup = new ButtonGroup();
    JRadioButton jRadioButton = new JRadioButton("男");
    JRadioButton jRadioButton1 = new JRadioButton("女");
    buttonGroup.add(jRadioButton);
    buttonGroup.add(jRadioButton1);
    add(jRadioButton);
    add(jRadioButton1);
  }
  public void init3(){
    //下拉列表
    JComboBox jComboBox = new JComboBox();
    jComboBox.addItem("中国");
    jComboBox.addItem("美国");
    jComboBox.addItem("韩国");
    jComboBox.addItem("英国");
    jComboBox.setMaximumRowCount(3);
    add(jComboBox);
  }
  public static void main(String[] args){
    MenuExample menuExample = new MenuExample("菜单栏");
    menuExample.init();
    MenuExample menuExample1 = new MenuExample("主页面");
    menuExample1.setLayout(null);
    MenuExample menuExample2 = new MenuExample("复选框");
    menuExample2.setLayout(new FlowLayout());
    menuExample2.init1();
    MenuExample menuExample3 = new MenuExample("单选框");
    menuExample3.setLayout(new FlowLayout());
    menuExample3.init2();
    MenuExample menuExample4 = new MenuExample("下拉框");
    menuExample4.setLayout(new FlowLayout());
    menuExample4.init3();
    JButton jButton = new JButton("菜单按钮");
    jButton.setBounds(0,0,200,40);
    jButton.addActionListener(new AbstractAction() {
      @Override
      public void actionPerformed(ActionEvent e) {
        menuExample1.openNewFrame(menuExample);
      }
    });
    JButton jButton1 = new JButton("复选框按钮");
    jButton1.setBounds(0,40,200,40);
    jButton1.addActionListener(new AbstractAction() {
      @Override
      public void actionPerformed(ActionEvent e) {
        menuExample1.openNewFrame(menuExample2);
      }
    });
    JButton jButton2 = new JButton("单选框按钮");
    jButton2.setBounds(0,80,200,40);
    jButton2.addActionListener(new AbstractAction() {
      @Override
      public void actionPerformed(ActionEvent e) {
        menuExample1.openNewFrame(menuExample3);
      }
    });
    JButton jButton3 = new JButton("下拉框按钮");
    jButton3.setBounds(0,120,200,40);
    jButton3.addActionListener(new AbstractAction() {
      @Override
      public void actionPerformed(ActionEvent e) {
        menuExample1.openNewFrame(menuExample4);
      }
    });
    menuExample1.add(jButton);
    menuExample1.add(jButton1);
    menuExample1.add(jButton2);
    menuExample1.add(jButton3);
    menuExample1.setVisible(true);
  }
}
