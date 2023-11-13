package teoria.homework15;

public class Triangulo extends Figura {
  public Triangulo(double x, double y) {
    super(x, y);
  }

  public double getArea() {
    return x * y / 2;
  }

  public String toString() {
    return "Base: " + x + " Altura: " + y + " Area: " + getArea();
  }
}
