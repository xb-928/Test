package wingoop;

import javax.swing.*;
import java.awt.*;

public class Menu extends JPanel {

  public Menu() {
    init();
  }
  public void init(){
    setLayout(new BorderLayout());
    //创建菜单工具栏
    JMenuBar jMenuBar = new JMenuBar();
    //创建菜单条
    JMenu jMenu = new JMenu("文件（File）");
    jMenu.setMnemonic('F');
    JMenu jMenu1 = new JMenu("编辑（Edit）");
    jMenu.setMnemonic('E');
    JMenu jMenu2 = new JMenu("资源（Source）");
    jMenu.setMnemonic('S');
    JMenu jMenu3 = new JMenu("导航（Navigate）");
    jMenu.setMnemonic('N');
    JMenu jMenu4 = new JMenu("帮助（Help）");
    jMenu.setMnemonic('H');
    //创建菜单项
    JMenuItem jMenuItem = new JMenuItem("新建（N）");
    jMenuItem.setMnemonic('N');
    JMenuItem jMenuItem1 = new JMenuItem("打开（O）");
    jMenuItem.setMnemonic('O');
    JMenuItem jMenuItem2 = new JMenuItem("保存（S）");
    jMenuItem.setMnemonic('S');
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
    jMenuBar.setSize(200,60);
    //将菜单工具栏添加到JPanel中
    add(jMenuBar);
  }
}
