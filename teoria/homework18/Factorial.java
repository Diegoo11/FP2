package teoria.homework18;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Factorial extends JFrame {
  private JTextField input1 = new JTextField(3);
  private JTextField input2 = new JTextField(10);
  private JButton button = new JButton("Calcular");
  
  public Factorial() {
    setTitle("Calculadora de factorial");
    setSize(500, 200);
    setLayout(new FlowLayout());
    createContens();
    setVisible(true);
  }
  
  public void createContens() {
    JLabel tag1 = new JLabel("Numero: ");
    JLabel tag2 = new JLabel("Factorial: ");
    add(tag1);
    add(input1);
    add(tag2);
    add(input2);
    add(button);
    input1.addActionListener(new Listener());
  }

  private class Listener implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      input2.setEditable(false);
      int num;
      try {
        num = Integer.parseInt(input1.getText());
      } catch (Exception error){
        num = 0;
      }
      if(num < 0) {
        input2.setText("Indefinido");
      } else if (num == 0 || num == 1) {
        input2.setText("1");
      } else {
        int res = 1;
        for (int i = 1; i <= num; i += 1) {
          res += num +1 -i;
        }
        input2.setText("" + res);
      }
    }
  }
  public static void main(String[] args) {
    new Factorial();
  }

}
