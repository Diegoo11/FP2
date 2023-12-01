package lab.lab22;

public class EspadachinReal extends Espadachin {
  private int nivelEvolucion = 1;

  public EspadachinReal(String team, int lEspada) {
    super(team, lEspada);
  }
  
  public void lanzarCuchillos() {
    System.out.println("Lanza un cuchillo");
  }

  public void evolucionar() {
    if (nivelEvolucion < 4) nivelEvolucion += 1;
  }
}
