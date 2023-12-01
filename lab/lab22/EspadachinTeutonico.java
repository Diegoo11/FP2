package lab.lab22;

public class EspadachinTeutonico extends Espadachin {
  private int nivelEvolucion = 1;

  public EspadachinTeutonico(String team, int lEspada) {
    super(team, lEspada);
  }

  public void lanzarJabalina() {
    System.out.println("Lanza un jabalina");
  }

  public void modoTortuga() {
    setNivelDefensa(getNivelDefensa() + 2);
  }

  public void evolucionar() {
    if (nivelEvolucion < 4) nivelEvolucion += 1;
  }
}
