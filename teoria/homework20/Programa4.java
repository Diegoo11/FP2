package teoria.homework20;

import java.io.*;

public class Programa4 {
  public static void main(String[] args) {
    try {
      PrintWriter file = new PrintWriter(new FileWriter("numeritosAleatorios.txt"));
      
      int[] arr = new int[10];

      for(int i = 0; i < arr.length; i++) {
        arr[i] = dado();
      }
      save(file, arr);

      file.close();
    } catch (IOException e) {
      System.out.println("IO: " + e.getMessage());
    }
  }
  public static int dado() {
    return (int)(Math.random() * 6 + 1);
  }
  public static void save(PrintWriter file, int[] arr) {
    for(int i = 0; i < arr.length; i++) {
      file.println(arr[i]);
    }
  }
}
