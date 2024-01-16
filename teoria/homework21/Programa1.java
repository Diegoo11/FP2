package teoria.homework21;

import java.io.*;
import java.util.ArrayList;

public class Programa1 {
  public static void main(String[] args) {
    DataInputStream file;
    ArrayList<Integer> arr = new ArrayList<Integer>();
    char ch;
    String description = "";
    int num;

    try {
      file = new DataInputStream(new FileInputStream("numeros.txt"));
      while ((ch = file.readChar()) != 0) {
        description += ch;
      }
      System.out.println(description);
      num = file.readInt();

      for(int i = 0; i < num; i += 1) {
        arr.add(file.readInt());
      }

      for(Integer i : arr) {
        System.out.println(i);
      }
      file.close();
    } catch (IOException e) {
      System.out.println(e);
    }
  }
}
