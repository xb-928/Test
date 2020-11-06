package wingoop;

import javax.swing.*;
import java.awt.*;

public class JTableFrame extends BaseJFrame {
  public JTableFrame() {
    init();
  }
  public void init(){
    setTitle("表格控件");
    String[] head = {"学号","姓名","年龄","生日"};
    String[][] data = {
      {"1","张三","12","1995-1-1"},
      {"2","李四","14","1996-1-1"},
      {"3","王五","16","1997-1-1"},
      {"4","赵六","15","1998-1-1"},
      {"5","小米","11","1999-1-1"},
      {"6","小明","20","2000-1-1"},
    };
    JTable jTable = new JTable(data,head);
    JScrollPane jScrollPane = new JScrollPane(jTable,
      JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
      JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED
    );
    add(jScrollPane,BorderLayout.CENTER);
  }
  public static void main(String[] args){
    JTableFrame jTableFrame = new JTableFrame();
    Menu menu = new Menu();
    jTableFrame.add(menu,BorderLayout.NORTH);
    jTableFrame.setVisible(true);
  }
}
