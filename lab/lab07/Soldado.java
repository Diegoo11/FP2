package lab.lab07;

public class Soldado {
  private String nombre;
  private int fila;
  private int columna;
  private int puntos;
  private int team;

  public Soldado(int n) { team = n; }
  public int getTeam() { return team; }

  public void setNombre(String n) { nombre = n; }

  public void setFila(int f) { fila = f; }

  public void setColumna(int c) { columna = c; }

  public void setPuntos(int p) { puntos = p; }

  public String getNombre() { return nombre; }

  public int getFila() { return fila; }

  public int getColumna() { return columna; }

  public int getPuntos() { return puntos; }

  public String toString() {
    return "Nombre: " + nombre +
    " | Ubicacion: " + fila + ", " +
    columna + " | Puntos: " + puntos;
  }
}