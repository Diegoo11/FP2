package teoria.homework03;
import java.util.*;

class Programa3 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int[] hours = new int[30];
    generar(hours);
    for(int i = 0; i < sc.nextInt(); i += 1) {
      desplazar(hours);
    }
  }
  public static void generar(int[] arr) {
    for(int i = 0; i < arr.length; i += 1) {
      arr[i] = random(8);
    }
  }
  public static int random(int n) {
    return (int) (Math.random() * n + 1);
  }
  public static void desplazar(int[] arr) {
    for(int i = 0; i < arr.length - 1; i += 1) {
      arr[i] = arr[i + 1];
    }
    arr[arr.length - 1] = random(8);
  }
  public static void print(int[] arr) {
    for(int i = 0; i < arr.length; i += 1) {
      System.out.print(arr[i] + " | ");
    }
    System.out.println();
  }
}
