package teoria.homework07;

import java.util.Scanner;

public class Programa01 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    Soldado soldado1 = new Soldado();
    Soldado soldado2 = new Soldado();
    System.out.println("Ingrese el nombre del primer soldado: ");
    soldado1.setNombre(sc.next());
    System.out.println("Ingrese el nivel de vida del primer soldado: ");
    soldado1.setNivelVida(sc.nextInt());
    System.out.println("Ingrese la ubicacion del primer soldado: ");
    soldado1.setColFila(sc.next());
    
    System.out.println("Ingrese el nombre del primer soldado: ");
    soldado2.setNombre(sc.next());
    System.out.println("Ingrese el nivel de vida del primer soldado: ");
    soldado2.setNivelVida(sc.nextInt());
    System.out.println("Ingrese la ubicacion del primer soldado: ");
    soldado2.setColFila(sc.next());

    System.out.println(soldado1);
    System.out.println(soldado2);
  }
}

