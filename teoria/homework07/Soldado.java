package teoria.homework07;

public class Soldado {
  private String nombre;
  private int nivelVida;
  private String colFila;

  public String getNombre() { return nombre; }
  public void setNombre(String n) { nombre = n; }
  public int getNivelVida() { return nivelVida; }
  public void setNivelVida(int n) { nivelVida = n; }
  public String getColFila() { return colFila; }
  public void setColFila(String n) { colFila = n; }

  public String toString() {
    return "" + nombre + ", " + nivelVida + " => " + colFila;
  }
}
