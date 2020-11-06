package Calculator;

import javax.swing.*;
import java.awt.*;

public class Calculator extends JFrame {
  public Calculator(){
    this.setTitle("计算器");
    setResizable(false);
    this.setBounds(300,300,240,240);
    JLabel jLabel = new JLabel();
    jLabel.setPreferredSize(new Dimension(10,0));
    add(jLabel, BorderLayout.WEST);
    JLabel jLabel1 = new JLabel();
    jLabel1.setPreferredSize(new Dimension(10,0));
    add(jLabel1,BorderLayout.EAST);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    init();
    setVisible(true);
  }
  public void init(){
    JPanel jPanel = new JPanel();
    JTextField jTextField = new JTextField();
    jTextField.setEditable(false);
    jTextField.setColumns(19);
    jPanel.add(jTextField);
    add(jPanel,BorderLayout.NORTH);
    JPanel jPanel1 = new JPanel();
    jPanel1.setLayout(new GridLayout(4,4,10,10));
    add(jPanel1,BorderLayout.CENTER);
    jPanel1.add(new Button("1"));
    jPanel1.add(new Button("2"));
    jPanel1.add(new Button("3"));
    jPanel1.add(new Button("+"));
    jPanel1.add(new Button("4"));
    jPanel1.add(new Button("5"));
    jPanel1.add(new Button("6"));
    jPanel1.add(new Button("-"));
    jPanel1.add(new Button("7"));
    jPanel1.add(new Button("8"));
    jPanel1.add(new Button("9"));
    jPanel1.add(new Button("*"));
    jPanel1.add(new Button("."));
    jPanel1.add(new Button("0"));
    jPanel1.add(new Button("="));
    jPanel1.add(new Button("/"));
  }
  public static void main(String[] args){
    Calculator calculator = new Calculator();
    calculator.setVisible(true);
  }
}
