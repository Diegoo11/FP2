package lab.lab22;

public class Espadachin extends SoldadoComun {
  private int logitudEspada;

  public Espadachin(String team, int lEspada) {
    super(0, team);
    logitudEspada = lEspada;
    int nivelv = random(2) + 8;
    setNivelVida(nivelv);
    setNivelAtaque(10);
    setNivelDefensa(8);
  }

  public void crearMuro() {
    System.out.println("Se creo un muro de escudos");
  }

  public int getLongitudEspada() {
    return logitudEspada;
  }
}
