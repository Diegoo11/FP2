package teoria.homework21;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Programa2 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    DataOutputStream fileOut;
    DataInputStream fileIn;
    DataOutputStream fileOut2;
    ArrayList<Integer> arr = new ArrayList<Integer>();

    ArrayList<Integer> arrOut = new ArrayList<Integer>();
    
    int n = sc.nextInt();
    int x = sc.nextInt();
    int y = sc.nextInt();
    sc.close();
    for(int i = 0; i < n; i++) {
      arr.add(random(y - x + 1) + x);
    }

    try {
      fileOut = new DataOutputStream(new FileOutputStream("numeros.dat"));
      fileIn = new DataInputStream(new FileInputStream("numeros.dat"));
      fileOut2 = new DataOutputStream(new FileOutputStream("otrosNumeros.dat"));

      for(int i = 0; i < arr.size(); i++) {
        fileOut.writeInt(arr.get(i));
      }

      for(int i = 0; i < arr.size(); i++) {
        arrOut.add(fileIn.readInt());
      }

      for(int i = 0; i < arrOut.size(); i += 1) {
        for(int j = 0; j < arrOut.size() - i; j += 1) {
          if(arrOut.get(j) > arrOut.get(j + 1)) {
            int num = arrOut.get(j);
            arrOut.set(j, arrOut.get(j + 1));
            arrOut.set(j + 1, num);
          }
        }
      }

      for(int i = 0; i < arrOut.size(); i += 1) {
        fileOut2.writeInt(arrOut.get(i));
      }

      fileIn.close();
      fileOut.close();
      fileOut2.close();

    } catch (Exception e) {
      return;
    }
  }
  public static int random(int n) {
    return (int) (Math.random() * n);
  }
}
