package teoria.homework15;

public class Programa1 {
  public static void main(String[] args) {
    Object obj;

    obj = new Triangulo(10, 10);

    System.out.println(obj);

    obj = new Rectangulo(10, 10);

    System.out.println(obj);

    obj = new Circulo(10);

    System.out.println(obj);
  }
}
