package teoria.homework21;

import java.io.Serializable;

public class Alumno implements Serializable {
  private String nombre;
  private int edad;
  private int cui;

  public Alumno(String nombre, int edad, int cui) {
    this.nombre = nombre;
    this.edad = edad;
    this.cui = cui;
  }
  public String getNombre() {
    return nombre;
  }
  public int getEdad() {
    return edad;
  }
  public int getCui() {
    return cui;
  }
  public void setNombre(String nombre) {
    this.nombre = nombre;
  }
  public void setEdad(int edad) {
    this.edad = edad;
  }
  public void setCui(int cui) {
    this.cui = cui;
  }
  public String toString() {
    return "Nombre: " + nombre + " Edad: " + edad + " CUI: " + cui;
  }
}
