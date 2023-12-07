package teoria.homework20;

import java.io.*;
import java.util.Scanner;
class Programa8{
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("ngresa el nombre del archivo:");
    String file = sc.nextLine();
    try{
      Scanner fileIn = new Scanner(new FileReader("./"+file));
      while(fileIn.hasNextLine()){
        String line = fileIn.nextLine();
        System.out.println(line);
      }
      fileIn.close();

    }
    catch(FileNotFoundException e){
      System.out.println(e.getMessage());
    }
    sc.close();
  }
}