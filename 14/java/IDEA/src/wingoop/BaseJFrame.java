package wingoop;

import javax.swing.*;

public class BaseJFrame extends JFrame {
  public BaseJFrame(){
    //设置图标
    ImageIcon icon = new ImageIcon("src//Image//ic_launcher.png");
    setIconImage(icon.getImage());
    //设置位置大小
    setBounds(300,300,500,400);
    //设置默认关闭模式
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }

  public void openNewFrame(JFrame jFrame){
    this.setVisible(false);
    jFrame.setVisible(true);
  }
}
