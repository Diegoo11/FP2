package teoria.homework11;

public class Empleado {
  private String nombre;
  private String apellido;
  private int edad;
  private static int allEmpleados = 0;

  public Empleado(String name, String lastName, int age) {
    nombre = name;
    apellido = lastName;
    edad = age;
    allEmpleados += 1;
  }
  public Empleado(String name, String lastName) {
    this(name, lastName, 18);
  }
  public Empleado(String name) {
    this(name, ".", 18);
  }
  public void setNombre(String str) {
    nombre = str;
  }
  public String getNombre() {
    return nombre;
  }
  public void setApellido(String str) {
    apellido = str;
  }
  public String getApellido() {
    return apellido;
  }
  public void setEdad(int age) {
    edad = age;
  }
  public int getEdad() {
    return edad;
  }
  public static int getAllEmpleados() {
    return allEmpleados;
  }
}
