package lab.lab22;

public class EspadachinConquistador extends Espadachin {
  private int nivelEvolucion = 1;
  private String nombre = "Espadachin Conquistador";

  public String getNombre() {return nombre;}

  public EspadachinConquistador(String team, int lEspada) {
    super(team, lEspada);
    setNivelVida(14);
  }

  public void lanzarHacha() {
    System.out.println("Lanza un hacha");
  }

  public void evolucionar() {
    if (nivelEvolucion < 4) nivelEvolucion += 1;
  }

}
