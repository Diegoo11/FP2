package teoria.homework20;

import java.io.*;
import java.util.Scanner;

class Archivo07 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Ingresa el archivo a leer");
    String file = sc.nextLine();
    try {
      Scanner fileIn = new Scanner(new FileReader("./"+file));
      String keyWord = fileIn.nextLine();
      System.out.println("La 1ra linea: ");
      System.out.println(keyWord);
      fileIn.close();
    }
    catch(FileNotFoundException e){
      System.out.println(e.getMessage());
    }
    sc.close();
  }
}