package teoria.homework12;

public class Vendedor {
  private String nombre;
  private String apellido;
  private int edad;
  private int ventas = 0;

  public Vendedor(String n, String a, int e) {
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
  public int getVentas() {
    return ventas;
  }
  public void vender() {
    ventas += 1;
  }
  public String toString() {
    return("Nombre: " + nombre + " Apellido: " + apellido + " Edad: " + edad + " Ventas: " + ventas);
  }
}

