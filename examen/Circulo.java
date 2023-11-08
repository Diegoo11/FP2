public class Circulo {
  private double radio;

  public Circulo(double n) {
    radio = n;
  }

  public double area() {
    return Math.PI * radio * radio;
  }
}
