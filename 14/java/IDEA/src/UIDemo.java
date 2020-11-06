import javax.swing.*;

public class UIDemo {
  private JPanel panel1;
  private JButton 登录Button;
  private JTextField textField1;
  private JTextField textField2;

  public static void main(String[] args) {
    JFrame frame = new JFrame("UIDemo");
    frame.setContentPane(new UIDemo().panel1);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.pack();
    frame.setVisible(true);
  }

}
