package teoria.homework13;

public class Employee extends Person{
  protected int id;

  public Employee(String nombre, int edad) {
    super(nombre, edad);

  }
  public Employee(String nombre, int edad, int uid) {
    super(nombre, edad);
    id = uid;
  }
  public void display() {
    System.out.println("Nombre: " + getName() + " | Edad: " + getAge() + " | ID: " + id);
  }
}
