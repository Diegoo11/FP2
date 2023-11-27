package teoria.homework17;

abstract public class Shape {
  private Color color;
  private String origen;

  public Shape(int green, int blue, int red, String o) {
    Color c = new Color(green, blue, red);
    color = c;
    origen = o;
  }
  public Shape(int green, int blue, int red) {
    this(green, blue, red, "nulo");
  }
  public Shape() {
    this(255, 255, 255, "nulo");
  }

  public Color getColor() { return color; }
  public String getOrigen() { return origen; }

  public void setColor(Color c) { color = c; }
  public void setOrigen(String o) { origen = o; }

  abstract double getArea();
  abstract double getPerimetro();
}
