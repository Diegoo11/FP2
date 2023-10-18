package teoria.homework10;

public class Programa4 {
  public static void main(String[] args) {
    Fraccion f1 = new Fraccion(3, 6);
    Fraccion f2 = new Fraccion(8, 20);

    Fraccion suma = f1.sumar(f2);
    Fraccion resta = f1.restar(f2);
    Fraccion multiplicacion = f1.multiplicar(f2);
    Fraccion division = f1.dividir(f2);
    Fraccion simplificacion = f1.simplificar();


    System.out.println(suma);
    System.out.println(resta);
    System.out.println(multiplicacion);
    System.out.println(division);
    System.out.println(simplificacion);
  }
}
