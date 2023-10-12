package teoria.homework08;

public class Cuenta {
  private double saldo;

  public void consultarSaldo() {
    System.out.println("Tu saldo es:" + saldo);
  }
  public void depositar(double n) {
    saldo += n;
  }
  public void retirar(double n) {
    if(saldo < n) {
      System.out.println("No cuenta con suficiente saldo");
    } else saldo -= n;
  }
}

