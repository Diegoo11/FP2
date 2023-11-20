package teoria.homework16;

public class Employee {
  private String name;

  public Employee(String n) {
    name = n;
  }

  public double getPay() {
    return 0.0;
  }

  public String toString() {
    return (name + " " + getPay());
  }
}
