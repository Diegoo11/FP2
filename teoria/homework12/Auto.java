package teoria.homework12;

public class Auto {
  private String marca;
  private String color;
  private int year;
  
  public Auto(String m, String c, int y) {
    marca = m;
    color = c;
    year = y;
  }
  public String getMarca() {
    return marca;
  }
  public String getColor() {
    return color;
  }
  public int getYear() {
    return year;
  }
  public String toString() {
    return "Marca: " + marca + " Color: " + color + " Year:" + year;
  }
}
