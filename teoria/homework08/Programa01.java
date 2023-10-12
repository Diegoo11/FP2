package teoria.homework08;

public class Programa01 {
  public static void main(String[] args) {
    Cuenta cuenta1 = new Cuenta();
    cuenta1.depositar(500);
    cuenta1.consultarSaldo();
    cuenta1.depositar(23);
    cuenta1.consultarSaldo();
    
    Cuenta cuenta2 = new Cuenta();
    cuenta2.retirar(2323);
    cuenta2.consultarSaldo();
    cuenta2.depositar(1231);
    cuenta2.consultarSaldo();
  }
}