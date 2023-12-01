package lab.lab22;

public class CaballeroMoro extends Caballero {
  private int nivelEvolucion = 1;

  public CaballeroMoro(String team) {
    super(team);
  }

  public void lanzarFlechas() {
    System.out.println("Lanzar flechas");
  }

  public void evolucionar() {
    if (nivelEvolucion < 4) nivelEvolucion += 1;
  }
}
