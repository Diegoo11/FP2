package teoria.homework20;

import java.io.*;
import java.util.Scanner;

public class Programa5 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.print("Ingrese el nombre del archivo: ");
    String name = sc.next();
    
    System.out.print("Ingrese el contenido del texto: ");
    String body = sc.next();

    try {
      PrintWriter file = new PrintWriter(new FileWriter(name + ".txt"));
      file.println(body);
      file.close();
    } catch (IOException e) {
      System.out.println("IO: " + e.getMessage());
    }
  }
}
