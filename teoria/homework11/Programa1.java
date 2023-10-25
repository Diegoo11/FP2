package teoria.homework11;

public class Programa1 {
  public static void main(String[] args) {
    Empleado e1 = new Empleado("Juan", "Noa", 18);
    Empleado e2 = new Empleado("Pablo");
    Empleado e3 = new Empleado("Diego", "Torres");

    System.out.println(e1.getNombre() + " | " + e1.getApellido() + " | " + e1.getEdad());

    System.out.println(Empleado.getAllEmpleados()); // 3
  }
}
