package teoria.homework14;

import java.util.ArrayList;

public class Concesionario {
  private String nombreEmpresa;
  private Gerente elGerente;
  private ArrayList<Vendedor> personal = new ArrayList<Vendedor>();
  private ArrayList<Auto> autos = new ArrayList<Auto>();

  public Concesionario(String nombre, Gerente geren) {
    nombreEmpresa = nombre;
    elGerente = geren;
  }

  public void addAuto(Auto car) {
    autos.add(car);
  }

  public void addVendedor(Vendedor ven) {
    personal.add(ven);
  }

  public void imprimirStatus() {
    System.out.println("Nombre: " + nombreEmpresa);
    System.out.println("Nombre del gerente: " + elGerente.getNombre());
    System.out.println("Lista del perosnal: ");
    for(Vendedor p : personal) System.out.println(p.getNombre());
    System.out.println("Lista de marca de carros en el concesionario: ");
    for(Auto c : autos) System.out.println(c.getMarca());
  }
}
