package teoria.homework12;
import java.util.*;

public class Concesionario {
  private String nombreEmpresa;
  private Gerente elGerente;
  private ArrayList<Vendedor> personal = new ArrayList<Vendedor>();
  private ArrayList<Auto> autos = new ArrayList<Auto>();

  public Concesionario(String nombre, Gerente geren) {
    nombreEmpresa = nombre;
    elGerente = geren;
  }
  public void addAuto(Auto a) {
    autos.add(a);
  }
  public void addVendedor(Vendedor v) {
    personal.add(v);
  }
  public void printInfo() {
    System.out.println("Nombre de la empresa \t\t Nombre del gerente");
    System.out.println(nombreEmpresa + "\t\t" + elGerente.getNombre() + " " + elGerente.getApellido());
    System.out.println("\nVendedores:");
    for(Vendedor v : personal)
      System.out.println(v);
    for(Auto a : autos)
      System.out.println(a);
  }
}
