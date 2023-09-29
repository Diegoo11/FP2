package lab.lab05;

public class Soldado {
  private String nombre;
  private int fila;
  private int columna;
  private int puntos;

  // Metodos mutadores
  public void setNombre(String n) {
    nombre = n;
  }

  public void setFila(int f) {
    fila = f;
  }

  public void setColumna(int c) {
    columna = c;
  }

  public void setPuntos(int p) {
    puntos = p;
  }

  // Metodos accesores
  public String getNombre() {
    return nombre;
  }

  public int getFila() {
    return fila;
  }

  public int getColumna() {
    return columna;
  }

  public int getPuntos() {
    return puntos;
  }
  // Completar con otros métodos necesarios
  public String toString() {
    return "Nombre: " + nombre +
    " | Ubicacion: " + fila + ", " +
    columna + " | Puntos: " + puntos;
  }
}