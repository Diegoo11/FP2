package teoria.homework11;

import java.util.Scanner;

public class PennyJar {
  public static final int GOAL = 30;
  private static int allPenies = 0;
  private int pennies = 0;

  public void addPenny() {
    Scanner sc = new Scanner(System.in);
    System.out.println("Ingrese el numero de monedas: ");
    int monedas = sc.nextInt();
    for(int i = 0; i < monedas; i += 1) {
      System.out.println("clink");
    }
    allPenies += monedas;
    pennies += monedas;

    if(allPenies > GOAL) System.out.println("Tiempo de compras");
  }
  public int getPennies() {
    return pennies;
  }
  public static int getAllPennies() {
    return allPenies;
  }
}
