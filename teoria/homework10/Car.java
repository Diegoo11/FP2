package teoria.homework10;

public class Car {
  private String make;
  private int year;
  private String color;

  public String getMake() { return make; }
  public void setMake(String str) { make = str; }

  public int getYear() { return year; }
  public void setYear(int n) { year = n; }

  public String getColor() { return color; }
  public void setColor(String str) { color = str; }

  public Car makeCopy() {
    Car c =  new Car();
    c.setColor(color);
    c.setMake(make);
    c.setYear(year);
    return c;
  }

  public String toString() {
    return "Make: " + make + "\t Year: " + year + "\t Color: " + color;
  }

  public boolean equals(Car c) {
    return color.equals(c.getColor()) && year == c.getYear() && make.equals(c.getMake());
  }
}
