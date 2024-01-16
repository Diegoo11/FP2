package lab.lab24;

import java.io.Serializable;

public class CaballeroFranco extends Caballero implements Serializable{
  private int nivelEvolucion = 1;
  private String nombre = "Caballero Franco";

  public String getNombre() {return nombre;}

  public CaballeroFranco(String team) {
    super(team);
    setNivelVida(15);
  }

  public void lanzarLanza() {
    System.out.println("Lanza un lanza de " + nivelEvolucion * 2 + " metros");
  }

  public void evolucionar() {
    if (nivelEvolucion < 4) nivelEvolucion += 1;
  }

}
