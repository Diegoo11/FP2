public class Programa02 {
  public static void main(String[] args) {
    Soldado[] ejercito1 = new Soldado[5];
    Soldado[] ejercito2 = new Soldado[5];

    fillEjercito(ejercito1);
    fillEjercito(ejercito2);

    displayWinner(ejercito1, ejercito2);
  }
  public static void fillEjercito(Soldado[] ejercito) {
    for(int i = 0; i < ejercito.length; i += 1) {
      ejercito[i] = new Soldado();
      ejercito[i].setName("Soldado 0" + (i+1));
      ejercito[i].setNivel((int) (Math.random() * 5 + 1));
    }
  }
  public static void printEjercito(Soldado[] ejercito) {
    for(Soldado s : ejercito) {
      System.out.println(s);
    }
  }
  public static void displayWinner(Soldado[] ejercito1, Soldado[] ejercito2) {
    if(ejercito1.length == ejercito2.length) {
      System.out.println("es un empate");
      System.out.println("debiod a que tienen ambos ejercitos la misma cantidad");
    } else {
      Soldado[] winner = ejercito1.length > ejercito2.length ? ejercito1: ejercito2;

    }
  }
}
