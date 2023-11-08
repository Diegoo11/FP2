public class Rectangulo {
  private double altura;
  private double largo;

  public Rectangulo(double h, double b) {
    altura = h;
    largo = b;
  }

  public double area() {
    return altura * largo;
  }
}
