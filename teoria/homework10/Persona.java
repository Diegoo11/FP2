package teoria.homework10;

public class Persona {
  private String nombre;

  public String getNombre() { return nombre; }
  public void setNombre(String str) { nombre = str; }

  public void swapPerson(Persona p) {
    String name = nombre;
    nombre = p.getNombre();
    p.setNombre(name);
  }
}
