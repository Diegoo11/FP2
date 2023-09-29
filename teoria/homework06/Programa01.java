package teoria.homework06;

import java.util.ArrayList;
import java.util.Scanner;

public class Programa01 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Ingrese el numero de supervivientes");
    int n = sc.nextInt();
    ArrayList<String> arr = new ArrayList<String>();
    fillRandom(n, arr);
    for(int i = 0; i < n -1; i += 1) {
      System.out.println("Se elimino a: " + removeRandom(arr));
      System.out.println("Quedan los siguientes: ");
      printArr(arr);
    }
    System.out.println("El ganador es: " + arr.get(0));
  }
  public static String removeRandom(ArrayList<String> arr) {
    int length = arr.size();
    return arr.remove(random(length));
  }
  public static int random(int n) {
    return (int) (Math.random() * n);
  }
  public static void fillRandom(int n, ArrayList<String> arr) {
    for(int i = 0; i < n; i += 1) {
      arr.add(randomName());
    }
  }
  public static String randomName() {
    return "" + (char) (random(24) + 65) +
                (char) (random(24) + 65) +
                (char) (random(24) + 65) +
                (char) (random(24) + 65) +
                (char) (random(24) + 65) +
                (char) (random(24) + 65);
  }
  public static void printArr(ArrayList<String> arr) {
    for(int i = 0; i < arr.size(); i += 1) {
      System.out.println("Nombre: " + arr.get(i));
    }
  }
}
