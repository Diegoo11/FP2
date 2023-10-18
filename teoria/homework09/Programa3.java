package teoria.homework09;

import java.util.ArrayList;
import java.util.Scanner;

public class Programa3 {
  public static void main(String[] args) {
    ArrayList<Imaginario> arr = new ArrayList<Imaginario>();
    Scanner sc = new Scanner(System.in);
    while(true) {
      int input = sc.nextInt();
      if(input == 1) generateArr(arr);
      if(input == 2) printArr(arr);
      if(input == 3) printOperations(arr);
      if(input == 4) break;
    }
  }

  public static void generateArr(ArrayList<Imaginario> arr) {
    int e = random(2, 10);
    for(int i = 0; i < e; i += 1) {
      arr.add(new Imaginario(random(-10, 20), random(-10, 20)));
    }
  }

  public static void printArr(ArrayList<Imaginario> arr) {
    System.out.println(arr);
  }

  public static void printOperations(ArrayList<Imaginario> arr) {
    Imaginario num1 = arr.get(0);
    Imaginario num2 = arr.get(1);

    System.out.println("Suma   : \t" + num1.sumar(num2));
    System.out.println("Suma   : \t" + Imaginario.sumarClass(num1, num2));
    System.out.println("Suma   : \t" + sumar(num1, num2));

    System.out.println("Resta  : \t" + num1.restar(num2));
    System.out.println("Resta  : \t" + Imaginario.restarClass(num1, num2));
    System.out.println("Resta  : \t" + restar(num1, num2));

    System.out.println("Multiplicar: \t" + num1.multiplicar(num2));
    System.out.println("Multiplicar: \t" + Imaginario.multiplicarClass(num1, num2));
    System.out.println("Multiplicar: \t" + multiplicar(num1, num2));

    System.out.println("Modulo: \t" + num1.modulo());
    System.out.println("Modulo: \t" + Imaginario.moduloClass(num1));
    System.out.println("Modulo: \t" + modulo(num1));

    System.out.println("Conjugado: \t" + num1.conjugado());
    System.out.println("Conjugado: \t" + Imaginario.conjugadoClass(num1));
    System.out.println("Conjugado: \t" + conjugado(num1));
  }

  public static Imaginario sumar(Imaginario i1, Imaginario i2) {
    return new Imaginario(
      i1.getNumNatural() + i2.getNumNatural(),
      i1.getNumImaginario() + i2.getNumImaginario()
    );
  }
  public static Imaginario restar(Imaginario i1, Imaginario i2) {
    return new Imaginario(
      i1.getNumNatural() - i2.getNumNatural(),
      i1.getNumImaginario() - i2.getNumImaginario()
    );
  }
  public static Imaginario multiplicar(Imaginario i1, Imaginario i2) {
    return new Imaginario(
      i1.getNumNatural() * i2.getNumNatural() - i1.getNumImaginario() * i2.getNumImaginario(),
      i1.getNumNatural() * i2.getNumImaginario() + i2.getNumNatural() * i1.getNumImaginario()
    );
  }
  public static double modulo(Imaginario i) {
    return Math.sqrt(Math.pow(i.getNumNatural(), 2) + Math.pow(i.getNumImaginario(), 2));
  }
  public static Imaginario conjugado(Imaginario i) {
    return new Imaginario(
      i.getNumNatural(),
      i.getNumImaginario() * -1
    );
  }

  public static int random(int n, int m) {
    return (int) (Math.random() * (m-n) + n);
  }
}
