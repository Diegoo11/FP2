package teoria.homework07;

public class SoldadoReino {
  private String name;
  private int nivelVida;

  public SoldadoReino() {
    int randomSoldado = (int) (Math.random() * 3);
    if(randomSoldado == 0) {
      name = "Arquero";
      nivelVida = (int) (Math.random() * 2 + 3);
    } else if(randomSoldado == 1) {
      name = "Espadachin";
      nivelVida = (int) (Math.random() * 2 + 5);
    } else {
      name = "Caballero";
      nivelVida = (int) (Math.random() * 2 + 7);
    }
  }

  public String getName() {
    return name;
  }
  public int getNivelVida() {
    return nivelVida;
  }
  public String toString() {
    return name + " nivel: " + nivelVida;
  }
}
