package teoria.homework14;

public class Programa1 {
  public static void main(String[] args) {
    Gerente gerente1 = new Gerente("Pedro");

    Concesionario empresa = new Concesionario("Mi empresa", gerente1);

    empresa.addVendedor(new Vendedor("Vendedor 1"));
    empresa.addVendedor(new Vendedor("Vendedor 2"));
    empresa.addVendedor(new Vendedor("Vendedor 3"));
    empresa.addVendedor(new Vendedor("Vendedor 4"));
    empresa.addVendedor(new Vendedor("Vendedor 5"));

    empresa.addAuto(new Auto("Marca 1"));
    empresa.addAuto(new Auto("Marca 2"));
    empresa.addAuto(new Auto("Marca 3"));
    empresa.addAuto(new Auto("Marca 4"));
    empresa.addAuto(new Auto("Marca 5"));

    empresa.imprimirStatus();
  }
}
