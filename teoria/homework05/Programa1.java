package teoria.homework05;

import java.util.Scanner;

public class Programa1 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String[] names = {"AQP", "JUL", "CUZ", "TCQ", "LIM"};
    int[][] times = {
      {0, 22, 30, 42, 57},
      {23, 0, 15, 25, 58},
      {31, 17, 0, 24, 30},
      {45, 27, 25, 0, 95},
      {59, 58, 30, 97, 0}
    };

    while(true) {
      mostrarTablaTiemposVuelo(times, names);
      preguntaPorTiempoVuelo(times);

      System.out.println("Ingrese '0' para terminar el programa");
      if(0 == sc.nextInt()) break;
    }
  }
  public static void mostrarTablaTiemposVuelo(int[][] times, String[] names) {
    System.out.print("\t");
    for(int i = 0; i < names.length; i += 1) {
      System.out.print(names[i] + "\t");
    }
    System.out.println();
    for(int i = 0; i < names.length; i += 1) {
      System.out.print(names[i] + "\t");
      for(int j = 0; j < names.length; j += 1) {
        System.out.print(times[i][j] + "\t");
      }
      System.out.println();
    }
  }
  public static void preguntaPorTiempoVuelo(int[][] arr) {
    Scanner sc = new Scanner(System.in);
    System.out.print("Ingrese numero de la ciudad de partida: ");
    int i = sc.nextInt() - 1;
    System.out.print("Ingrese numero de la ciudad de llegada: ");
    int j = sc.nextInt() - 1;
    
    System.out.println("El tiempo de vuelo es de: " + arr[i][j]);
  }
}
