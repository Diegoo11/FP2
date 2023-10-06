package teoria.homework07;

public class Reino {
  private String name;
  public String getName() { return name; }
  public void setName(String n) { name = n; }
  
  private SoldadoReino soldier = new SoldadoReino();
  public SoldadoReino getSoldier() { return soldier; }

  public void newSoldier() {
    soldier = new SoldadoReino();
  }
}
