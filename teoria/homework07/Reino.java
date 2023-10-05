package teoria.homework07;

public class Reino {
  private String name;
  public String getName() { return name; }
  
  private SoldadoReino soldier = new SoldadoReino();
  public SoldadoReino getSoldier() { return soldier; }

  public void newSoldier() {
    soldier = new SoldadoReino();
  }
}
