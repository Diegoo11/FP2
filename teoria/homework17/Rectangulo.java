package teoria.homework17;

public class Rectangulo extends Shape {
  private double altura;
  private double largo;

  public Rectangulo(double a, double l) {
    super();
    altura = a;
    largo = l;
  }
  public double getArea() {
    return altura * largo;
  }
  public double getPerimetro() {
    return altura*2 + largo*2;
  }
}
