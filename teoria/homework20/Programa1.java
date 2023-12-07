package teoria.homework20;

import java.io.*;

public class Programa1 {
  public static void main(String[] args) {
    try {
      PrintWriter file = new PrintWriter(new FileWriter("mensaje.txt"));
      file.println("hola amigos como estan");
      file.close();
    } catch (IOException e) {
      System.out.println("IO: " + e.getMessage());
    }
  }
}
