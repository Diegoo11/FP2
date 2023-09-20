import java.util.*;

public class Programa2 {
  public static void rellenar(int[] arr) {
    Scanner sc = new Scanner(System.in);
    for(int i = 0; i < arr.length; i += 1) {
      arr[i] = sc.nextInt();
    }
  }
  public static void modificar(int[] arr) {
    for(int i = 0; i < arr.length; i += 1) {
      arr[i] *= 2;
    }
  }
  public static void imprimir(int[] arr) {
    for(int i = 0; i < arr.length; i += 1) {
      System.out.println(arr[i]);
    }
  }
  public static void main(String[] args) {
    int[] arr = new int[(int) Math.random() * 50];
    rellenar(arr);
    modificar(arr);
    imprimir(arr);
  }
}
