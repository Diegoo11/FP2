package teoria.examen1;

public class Jugador {
  private String nombre;
  private int numero;
  private int nivelDefensa;
  private int nivelAtaque;
  public void setNombre(String nombre) {
    this.nombre = nombre;
  }
  public String getNombre() {
    return nombre;
  }
  public void setNumero(int numero) {
    this.numero = numero;
  }
  public int getNumero() {
    return numero;
  }
  public void setNivelDefensa(int nivelDefensa) {
    this.nivelDefensa = nivelDefensa;
  }
  public int getNivelDefensa() {
    return nivelDefensa;
  }
  public void setNivelAtaque(int nivelAtaque) {
    this.nivelAtaque = nivelAtaque;
  }
  public int getNivelAtaque() {
    return nivelAtaque;
  }
  public String toString() {
    return "Nombre: " + nombre + "\t Nivel de ataque: " + nivelAtaque + "\t Nivel de defensa: " + nivelDefensa + "\n";
  }
}
