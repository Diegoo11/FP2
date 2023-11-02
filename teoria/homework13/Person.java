package teoria.homework13;

public class Person {
  private String name;
  private int age;

  public Person() {
    name = "Sin nombre";
  }
  public Person(String nombre, int edad) {
    name = nombre;
    age = edad;
  }
  public String getName() { return name; }
  public int getAge() { return age; }
}
