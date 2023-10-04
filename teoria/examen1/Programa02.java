package teoria.examen1;

import java.util.*;

public class Programa02 {
  public static void main(String[] args) {
    HashMap<Integer, Jugador> equipo = new HashMap<Integer, Jugador>();

    ingresar(equipo); // ingresa los datos de cada jugador

    imprimir(equipo); // imprime el equipo completo, un jugador por línea

    System.out.println("el mejor atacante es " + equipo.get(mejorAtacante(equipo)));

    System.out.println("el peor defensor es " + equipo.get(peorDefensor(equipo)));

    ArrayList<Jugador> equipoOrdenado = ordenarSeleccion(equipo); // criterio nivelAtaque descendente

    System.out.println("Imprime ArrayList -------------------------");
    System.out.println(equipoOrdenado); // imprime ordenado

    System.out.println("Imprime hashMap -------------------------");
    System.out.println(equipo); // imprime origin
  }
  public static void ingresar(HashMap<Integer, Jugador> equipo){
    for(int i = 1; i <= 11; i += 1) {
      Scanner sc = new Scanner(System.in);
      Jugador jugador = new Jugador();
      System.out.println("Ingresa el nombre del jugador con numero " + i);
      jugador.setNombre(sc.next());
      System.out.println("Ingresa el nivel de ataque de jugador con numero " + i);
      jugador.setNivelAtaque(sc.nextInt());
      System.out.println("Ingresa el nivel de defensa de jugador con numero " + i);
      jugador.setNivelDefensa(sc.nextInt());
      jugador.setNumero(i);
      equipo.put(i, jugador);
    }
  }
  public static void imprimir(HashMap<Integer, Jugador> equipo) {
    for(Integer k : equipo.keySet()) {
      Jugador jugador = equipo.get(k);
      System.out.print("Jugador ");
      System.out.print("\t Nombre: " + jugador.getNombre());
      System.out.print("\t Numero: " + jugador.getNumero());
      System.out.print("\t Nivel de ataque: " + jugador.getNivelAtaque());
      System.out.println("\t Nivel de defensa: " + jugador.getNivelDefensa());
    }
  }
  public static int mejorAtacante(HashMap<Integer, Jugador> equipo) {
    int max = 1;
    for(Integer k : equipo.keySet()) {
      if(equipo.get(k).getNivelAtaque() > equipo.get(max).getNivelAtaque()) max = k;
    }
    return max;
  }
  public static int peorDefensor(HashMap<Integer, Jugador> equipo) {
    int min = 1;
    for(Integer k : equipo.keySet()) {
      if(equipo.get(k).getNivelDefensa() < equipo.get(min).getNivelDefensa()) min = k;
    }
    return min;
  }
  public static ArrayList<Jugador> ordenarSeleccion(HashMap<Integer, Jugador> equipo) {
    ArrayList<Jugador> arr = new ArrayList<Jugador>();

    for(int i = 1; i <= 11; i += 1) {
      arr.add(equipo.get(i));
    }

    return arr;
  }
}
