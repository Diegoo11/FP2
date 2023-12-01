package teoria.homework19;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Form extends JFrame {
  private JLabel label1 = new JLabel("Skills: ");
  private JCheckBox checkBox1 = new JCheckBox("Java sun certified");
  private JCheckBox checkBox2 = new JCheckBox("Help desk");
  private JCheckBox checkBox3 = new JCheckBox("good coffe");

  private JLabel label2 = new JLabel("Comunity standing");
  private ButtonGroup group = new ButtonGroup();
  private JRadioButton btn1 = new JRadioButton("law abiding");
  private JRadioButton btn2 = new JRadioButton("violent criminal");

  private JLabel label3 = new JLabel("Salary");
  private String[] salary ={
    "$10,000 - $19,000",
    "$20,000 - $29,000",
    "$30,000 - $39,000",
    "$40,000 - $49,000",
    "$50,000 - $59,000"
  };
  private JComboBox comboBox = new JComboBox<>(salary);

  private JButton btnFinal = new JButton();


  public Form() {
    setTitle("Formulario");
    setSize(200,300);
    setLayout(new GridLayout(4, 1));
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    createContens();
    setVisible(true);
  }

  public void createContens() {
    JPanel panel1 = new JPanel(new GridLayout(4, 1));
    panel1.add(label1);
    panel1.add(checkBox1);
    panel1.add(checkBox2);
    panel1.add(checkBox3);

    JPanel panel2 = new JPanel(new GridLayout(3, 1));
    group.add(btn1);
    group.add(btn2);


    panel2.add(label2);
    panel2.add(btn1);
    panel2.add(btn2);

    JPanel panel3 = new JPanel(new GridLayout(2, 1));
    panel3.add(label3);
    panel3.add(comboBox);

    JPanel panel4 = new JPanel(new FlowLayout(FlowLayout.CENTER));
    btnFinal.setText("submit");
    btnFinal.addActionListener(new Listener());
    panel4.add(btnFinal);

    add(panel1);
    add(panel2);
    add(panel3);
    add(panel4);
  }

  private class Listener implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      if(
        (checkBox1.isSelected() || checkBox2.isSelected() || checkBox3.isSelected())
        && btn1.isSelected()
        && comboBox.getSelectedItem().equals("$10,000 - $19,000")
      ) {
        JOptionPane.showMessageDialog(null, "Gracias");
      } else {
        JOptionPane.showMessageDialog(null, "Losiento");
      }
    }
  }

  public static void main(String[] args) {
    new Form();
  }
}
