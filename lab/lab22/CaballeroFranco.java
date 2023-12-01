package lab.lab22;

public class CaballeroFranco extends Caballero {
  private int nivelEvolucion = 1;
  public CaballeroFranco(String team) {
    super(team);
  }

  public void lanzarLanza() {
    System.out.println("Lanza un lanza de " + nivelEvolucion * 2 + " metros");
  }

  public void evolucionar() {
    if (nivelEvolucion < 4) nivelEvolucion += 1;
  }

}
