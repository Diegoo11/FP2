package teoria.homework20;

import java.io.*;

public class Programa3 {
  public static void main(String[] args) {
    try {
      PrintWriter file = new PrintWriter(new FileWriter("numeritosAleatorios.txt"));
      
      for(int i = 1; i <= 10; i++) file.println((int)(Math.random() * 6 + 1));

      file.close();
    } catch (IOException e) {
      System.out.println("IO: " + e.getMessage());
    }
  }
}
