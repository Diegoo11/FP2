package teoria.homework08;

public class Raton {
  private double peso = 1;
  private int edad = 1;
  private double tasaCrecimiento = random(100)/100.0;

  public void crecerUnoDia() {
    System.out.println("El raton crecio un dia");
    edad += 1;
    peso += 0.1 * tasaCrecimiento * edad;
  }
  public double getPeso() {
    return peso;
  }
  public int getEdad() {
    return edad;
  }

  public static int random(int n) {
    return (int) (Math.random() * n);
  }

  public void mostrarDatos() {
    System.out.println("Peso: " + peso + " | Edad: " + edad);
  }

  public String toString() {
    return "Peso: " + peso + " | Edad: " + edad;
  }
}
