package teoria.homework13;

public class FullTime extends Employee{
  private double salary;

  public FullTime() {
    super("Sin nombre", 0, 1);
    salary = 0;
  }
  public FullTime(String nombre, int edad, int id, double salario) {
    super(nombre, edad, id);
    salary = salario;
  }
  public void display() {
    System.out.println("Nombre: " + getName() + " | Edad: " +
     getAge() + " | ID: " + id + " | Salary: " + salary);
  }
}
