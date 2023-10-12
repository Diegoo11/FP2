package teoria.homework08;

public class Contacto {
  private String nombre;
  private int edad;
  private String estadoCivil;

  public void setNombre(String str) { nombre = str; }
  public String getNombre() { return nombre; }

  public void setEdad(int n) { edad = n; }
  public int getEdad() { return edad; }

  public void setEstadoCivil(String str) { estadoCivil = str; }
  public String getEstadoCivil() { return estadoCivil; }

  public String toString() {
    return "Nombre: " + nombre + " Edad: " + edad + " Estado Civil: " + estadoCivil;
  }
}
