package teoria.homework11;

public class Programa2 {
  public static void main(String[] args) {
    PennyJar j1 = new PennyJar();
    PennyJar j2 = new PennyJar();

    System.out.println(PennyJar.GOAL);

    j1.addPenny();
    j2.addPenny();
    j1.addPenny();
  }
}



