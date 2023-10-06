package teoria.homework07;

import javax.swing.*;

public class Programa02 {
  public static void main(String[] args) {
    while (true) {
      Reino reino1 = new Reino();
      Reino reino2 = new Reino();

      String name1 = JOptionPane
        .showInputDialog("Ingrese el nombre del reino 1","reinoOne");
      reino1.setName(name1);

      String name2 = JOptionPane
        .showInputDialog("Ingrese el nombre del reino 2", "reinoTwo");
      reino2.setName(name2);

      int nWars = random(15) + 5;
      int nWin1 = 0;
      int nWin2 = 0;

      JOptionPane.showMessageDialog(null, "El numero de batallas seran: " + nWars);

      for (int i = 0; i < nWars; i += 1) {
        if (winner(reino1.getSoldier().getNivelVida(), reino2.getSoldier().getNivelVida())) {
          JOptionPane.showMessageDialog(null, "Pelea " + reino1.getSoldier() + " del reino 1\n"
          + "Pelea " + reino2.getSoldier() + " del reino 2\n"
          + "\nGana el reino 1");
          nWin1 += 1;
        } else {
          JOptionPane.showMessageDialog(null, "Pelea " + reino1.getSoldier() + " del reino 1\n"
          + "Pelea " + reino2.getSoldier() + " del reino 2\n"
          + "\nGana el reino 2");
          nWin2 += 1;
        }
        reino1.newSoldier();
        reino2.newSoldier();
      }

      if (nWin1 == nWin2)
        JOptionPane.showMessageDialog(null, "Es un empate");
      else if (nWin1 > nWin2)
        JOptionPane.showMessageDialog(null, "Gana la guerra el reino 1");
      else
        JOptionPane.showMessageDialog(null, "Gana la guerra el reino 2");

      int nInput = Integer.parseInt(JOptionPane
      .showInputDialog("Ingrese 1 si desea continuar con otra guerra","1"));
      if(nInput != 1) break;
    }
  }

  public static int random(int n) {
    return (int) (Math.random() * n);
  }

  public static boolean winner(int n, int m) {
    return random(n + m) < n;
  }
}
