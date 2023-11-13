package teoria.homework15;

public class Programa2 {
  public static void main(String[] args) {
    Figura figura;

    figura = new Triangulo(10, 10);

    System.out.println(figura);

    figura = new Rectangulo(10, 10);

    System.out.println(figura);

    figura = new Circulo(10);

    System.out.println(figura);
  }
}

