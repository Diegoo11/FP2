package lab.lab23;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class UI extends JFrame {
  public UI() {
    setSize(600, 600);
    setLayout(new GridLayout(10, 10, 0, 0));
    NewMapa mapa = new NewMapa();
    

    printTable(mapa);

    setVisible(true);
  }

  public static void main(String[] args) {
    new UI();
  }

  public void printTable(NewMapa t) {
    System.out.println("     A      B      C      D      E      F      G      H      I      J      ");
    System.out.println("  -----------------------------------------------------------------------");
    for(int i = 0; i < t.getTable().length; i += 1) {
      System.out.print((i + 1) + " |");
      for(int j = 0; j < t.getTable().length; j += 1) {
        Ejercito ejercito = t.getTable()[i][j];
        if(ejercito == null) {
          System.out.print("      |");
          add(new JButton());
        }
        else {
          int suma = 0;
          for(Soldado s : ejercito.getMisSoldados()) suma += s.getNivelVida();
          System.out.print(" " + ejercito.getTeam() + "/" + suma +  " |");
          JButton btn = new JButton();
          btn.setText(" " + ejercito.getTeam() + "/" + suma);
          add(btn);
        }
      }
      System.out.println();
      System.out.println("  -----------------------------------------------------------------------");
    }
  }
}