package teoria.homework18;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Factorial4 extends JFrame {
  JButton btn1 = new JButton();
  JButton btn2 = new JButton();

  public Factorial4() {
    setTitle("GUI");
    setSize(500, 200);
    setLayout(new FlowLayout());

    btn1.setText("Stop");
    btn1.setBackground(Color.RED);

    btn2.setText("Go");
    btn2.setBackground(Color.GREEN);

    add(btn1);
    add(btn2);
    setVisible(true);

    btn1.addActionListener(new Listener());
    btn2.addActionListener(new Listener());
  }

  private class Listener implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      if(e.getSource() == btn1) {
        getContentPane().setBackground(Color.RED);
      }
      if(e.getSource() == btn2) {
        getContentPane().setBackground(Color.GREEN);
      }
    }
  }

  public static void main(String[] args) {
    new Factorial4();
  }
}
