package teoria.homework20;

import java.io.*;
import java.util.Scanner;

class Programa9 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    try {
      Scanner fileIn = new Scanner(new FileReader("./numeritosAleatorios.txt"));
      while (fileIn.hasNextLine()) {
        String keyWord = fileIn.nextLine();
        System.out.println(keyWord);
      }
      fileIn.close();

    } catch (FileNotFoundException e) {
      System.out.println("Error: " + e.getMessage());
    }
    sc.close();
  }
}