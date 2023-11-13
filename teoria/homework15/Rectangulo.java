package teoria.homework15;

public class Rectangulo extends Figura {
  public Rectangulo(double x, double y) {
    super(x, y);
  }

  public double getArea() {
    return x * y;
  }

  public String toString() {
    return "Base: " + x + " Altura: " + y + " Area: " + getArea();
  }
}
