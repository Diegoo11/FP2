public class Triangulo {
  private double altura;
  private double base;

  public Triangulo(double h, double b){ 
    altura = h;
    base = b;
  }
 
  public double area() {
    return altura * base;
  }
}
