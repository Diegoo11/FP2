import java.util.*;

public class Grafico {
  private ArrayList<Circulo> circulos = new ArrayList<Circulo>();
  private ArrayList<Cubo> cubos = new ArrayList<Cubo>();
  private ArrayList<Rectangulo> rectangulos = new ArrayList<Rectangulo>();
  private ArrayList<Triangulo> triangulos = new ArrayList<Triangulo>();
  private ArrayList<Esfera> esferas = new ArrayList<Esfera>();
  
  private String nombre;

  public Grafico(String name) { nombre = name; }

  public void addCirculo(Circulo f) { circulos.add(f); }
  public void addCubo(Cubo f) { cubos.add(f); }
  public void addRectangulo(Rectangulo f) { rectangulos.add(f); }
  public void addTriangulo(Triangulo f) { triangulos.add(f); }
  public void addEsfera(Esfera f) { esferas.add(f); }

  public void mostrarBidimensionales() {
    System.out.println("Circulos");
    for(Circulo c : circulos) System.out.println("Area: "+ c.area());
    System.out.println("Rectangulos");
    for(Rectangulo r : rectangulos) System.out.println("Area: " + r.area()); 
    System.out.println("Triangulos");
    for(Triangulo t : triangulos) System.out.println("Area: " + t.area());
  }

  public void mostrarTridimencionales() {
    System.out.println("Cubos");
    for(Cubo c: cubos) System.out.println("Volumen: " + c.volumen());
    System.out.println("Esferas");
    for(Esfera e: esferas) System.out.println("Volumen: " + e.volumen());
  }

}
