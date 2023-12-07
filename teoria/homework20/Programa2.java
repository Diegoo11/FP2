package teoria.homework20;

import java.io.*;

public class Programa2 {
  public static void main(String[] args) {
    try {
      PrintWriter file = new PrintWriter(new FileWriter("numeritos.txt"));
      
      for(int i = 1; i <= 10; i++) file.println("" + i);

      file.close();
    } catch (IOException e) {
      System.out.println("IO: " + e.getMessage());
    }
  }
}
