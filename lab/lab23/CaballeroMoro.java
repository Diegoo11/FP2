package lab.lab23;

public class CaballeroMoro extends Caballero {
  private int nivelEvolucion = 1;
  private String nombre = "Caballero Moro";

  public String getNombre() {return nombre;}

  public CaballeroMoro(String team) {
    super(team);
    setNivelVida(13);
  }

  public void lanzarFlechas() {
    System.out.println("Lanzar flechas");
  }

  public void evolucionar() {
    if (nivelEvolucion < 4) nivelEvolucion += 1;
  }
}
