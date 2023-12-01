package lab.lab22;

public class Arquero extends SoldadoComun {
  private int numFlechas = random(20);

  public Arquero(String team) {
    super(0, team);
    int nivelv = random(2) + 3;
    setNivelVida(nivelv);
    setNivelAtaque(7);
    setNivelDefensa(3);
  }

  public void disparar() {
    System.out.print("Disparo un flecha quedan: ");
    numFlechas -= 1;
    System.out.println(numFlechas);
  }
}
