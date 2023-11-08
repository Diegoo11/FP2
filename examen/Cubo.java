public class Cubo {
  private double altura;
  private double ancho;
  private double largo;

  public Cubo(double h, double a, double b) {
    altura = h;
    ancho = a;
    largo = b;
  }

  public double volumen() {
    return altura * ancho * largo;
  }
}
