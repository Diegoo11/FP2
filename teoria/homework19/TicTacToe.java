package teoria.homework19;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TicTacToe extends JFrame {
  private JButton btn1 = new JButton();
  private JButton btn2 = new JButton();
  private JButton btn3 = new JButton();
  private JButton btn4 = new JButton();
  private JButton btn5 = new JButton();
  private JButton btn6 = new JButton();
  private JButton btn7 = new JButton();
  private JButton btn8 = new JButton();
  private JButton btn9 = new JButton();

  public TicTacToe() {
    setTitle("Calculadora de factorial");
    setSize(200, 200);
    setLayout(new GridLayout(3, 3, 10, 10));
    add(btn1);
    add(btn2);
    add(btn3);
    add(btn4);
    add(btn5);
    add(btn6);
    add(btn7);
    add(btn8);
    add(btn9);
    btn1.addActionListener(new Listener());
    btn2.addActionListener(new Listener());
    btn3.addActionListener(new Listener());
    btn4.addActionListener(new Listener());
    btn5.addActionListener(new Listener());
    btn6.addActionListener(new Listener());
    btn7.addActionListener(new Listener());
    btn8.addActionListener(new Listener());
    btn9.addActionListener(new Listener());
    setVisible(true);
  }

  private class Listener implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      if (((JButton) e.getSource()).getText().equals("X")) {
        ((JButton) e.getSource()).setText("O");
      } else {
        ((JButton) e.getSource()).setText("X");
      };
    }
  }

  public static void main(String[] args) {
    new TicTacToe();
  }

}
