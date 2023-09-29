public class Soldado {
  private String name;
  private int nivel;

  public String getName() {
    return name;
  }
  public int getNivel() {
    return nivel;
  }
  public void setName(String n) {
    name = n;
  }
  public void setNivel(int n) {
    nivel = n;
  }

  public String toString() {
    return "Nombre: " + name + " | Nivel" + nivel;
  }
}
