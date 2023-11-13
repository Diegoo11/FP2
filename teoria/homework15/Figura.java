package teoria.homework15;

public class Figura {
  protected double x;
  protected double y;

  public Figura(double x, double y) {
    this.x = x;
    this.y = y;
  }

  public double getArea() {
    return x*y;
  }

  public String toString() {
    return super.toString();
  }
}
