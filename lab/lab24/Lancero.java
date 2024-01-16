package lab.lab24;

import java.io.Serializable;

public class Lancero extends SoldadoComun implements Serializable{
  private int logitudLanza;

  public Lancero(String team, int lEspada) {
    super(0, team);
    logitudLanza = lEspada;
    int nivelv = random(3) + 5;
    setNivelVida(nivelv);
    setNivelAtaque(5);
    setNivelDefensa(10);
  }

  public void schiltrom() {
    System.out.println("Se creo un muro de escudos");
  }

  public int getLongitudLanza() {
    return logitudLanza;
  }
}
