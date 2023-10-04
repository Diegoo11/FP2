package teoria.examen1;

import java.util.*;

public class Programa01 {
  public static void main(String[] args) {
    ArrayList<Double> a = new ArrayList<Double>();

    ingresar(a);

    imprimir(a); // usando for-each

    modificar(a);

    imprimir(a);

    imprimir(a, 3.5);

    System.out.println("El promedio es:" +promedio(a));
  }

  public static void ingresar(ArrayList<Double> arr) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Ingrese datos, para salir ingrese '-1': ");
    while(true) {
      double input = sc.nextDouble();
      if(input == -1) break;
      arr.add(input);
    }
  }
  public static void modificar(ArrayList<Double> arr) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Ingrese el valor con el que se quiere modificar: ");
    System.out.println("--------------------------------");
    double input = sc.nextDouble();
    for(int i = 0; i < arr.size(); i += 1) {
      arr.set(i, arr.get(i) * input);
    }
  }
  public static void imprimir(ArrayList<Double> arr) {
    System.out.println("Imprime todos los elementos");
    System.out.println("--------------------------------");
    for(double n : arr) {
      System.out.println(n);
    }
  }
  public static void imprimir(ArrayList<Double> arr, double m) {
    System.out.println("Imprime los elementos divisibles por " + m);
    System.out.println("--------------------------------");
    for(double n : arr) {
      if(n % m == 0) System.out.println(n);
    }
  }
  public static double promedio(ArrayList<Double> arr) {
    double sum = 0;
    for(double n : arr) {
      sum += n;
    }
    return sum/arr.size();
  }
}