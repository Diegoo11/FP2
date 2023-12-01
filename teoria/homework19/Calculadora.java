package teoria.homework19;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculadora extends JFrame {
  private JLabel label = new JLabel("x: ");
  private JTextField input = new JTextField(8);
  private JTextField input2 = new JTextField(20);
  private JTextField input3 = new JTextField(20);
  private JButton btn1 = new JButton();
  private JButton btn2 = new JButton();

  public Calculadora() {
    setTitle("Calculadora");
    setSize(500, 200);
    setLayout(new GridLayout(0, 2, 10, 10));
    createContens();
    setVisible(true);
  }

  public void createContens() {
    JPanel xPanelLeft = new JPanel(new FlowLayout(FlowLayout.CENTER));
    xPanelLeft.add(label);
    xPanelLeft.add(input);
    add(xPanelLeft);

    JPanel xPanelRTop = new JPanel(new FlowLayout(FlowLayout.CENTER));
    input2.setEditable(false);
    btn1.setText("Sqtr x");
    xPanelRTop.add(btn1);
    xPanelRTop.add(input2);

    JPanel xPanelRBottom = new JPanel(new FlowLayout(FlowLayout.CENTER));
    input3.setEditable(false);
    btn2.setText("Log x");
    xPanelRBottom.add(btn2);
    xPanelRBottom.add(input3);

    JPanel xPanelRigth = new JPanel(new GridLayout(2, 0, 10, 10));
    xPanelRigth.add(xPanelRTop);
    xPanelRigth.add(xPanelRBottom);
    add(xPanelRigth);

    btn1.addActionListener(new Listener());
    btn2.addActionListener(new Listener());
  }

  private class Listener implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      if(e.getSource() == btn1) {
        input2.setText("" + Math.sqrt(Integer.parseInt(input.getText())));
      }
      if(e.getSource() == btn2) {
        input3.setText("" + Math.log(Integer.parseInt(input.getText())));
      }
    }
  }

  public static void main(String[] args) {
    new Calculadora();
  }
}
