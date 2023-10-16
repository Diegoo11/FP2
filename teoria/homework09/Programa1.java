package teoria.homework09;

public class Programa1 {
  public static void main(String[] args) {
    Coordenada c1 = new Coordenada(10, 10);
    Coordenada c2 = new Coordenada(20, 20);

    System.out.println(c1.distancia(c2));
    
    System.out.println(Coordenada.distanciaClass(c1, c2));

    System.out.println(distancia(c1, c2));

  }
  public static double distancia(Coordenada c1, Coordenada c2) {
    double diferenciaX = c1.getX() - c2.getX();
    double diferenciaY = c1.getY() - c2.getY();

    return Math.sqrt(Math.pow(diferenciaX, 2) + Math.pow(diferenciaY, 2));
  }
}
