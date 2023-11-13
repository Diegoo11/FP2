package teoria.homework15;

public class Circulo extends Figura{
  public Circulo(double x) {
    super(x, x);
  }

  public double getArea() {
    return x * x * Math.PI;
  }

  public String toString() {
    return "Radio: " + x + " Area: " + getArea();
  }
}
