package teoria.homework12;

public class Estudiante {
  private int numLista;
  private String nombre;
  private Direccion domicilio;

  public Estudiante(int num, String nom, Direccion dir) {
    numLista = num;
    nombre = nom;
    domicilio = dir;
  }

  public int getNumLista() {
    return numLista;
  }

  public void setNumLista(int numLista) {
    this.numLista = numLista;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public Direccion getDomicilio() {
    return domicilio;
  }

  public void setDomicilio(Direccion domicilio) {
    this.domicilio = domicilio;
  }
  public String toString() {
    return "Nombre:" + nombre + " Numero: " + numLista + " Direccion: " + domicilio;
  }
}
