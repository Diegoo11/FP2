package teoria.homework12;

public class Gerente {
  private String nombre;
  private String apellido;
  private int edad;

  public Gerente(String n, String a, int e) {
    nombre = n;
    apellido = a;
    edad = e;
  }
  public String getNombre() {
    return nombre;
  }
  public String getApellido() {
    return apellido;
  }
  public int getEdad() {
    return edad;
  }
}
