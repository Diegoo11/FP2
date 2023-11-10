package lab.lab16;

import java.util.*;

public class VideoJuego {
  public static void main(String[] args) {
    String[] reinos = {"Inglaterra", "Francia", "Sacro", "Castilla", "Moros"};
    ArrayList<Ejercito> reino1 = new ArrayList<Ejercito>();
    ArrayList<Ejercito> reino2 = new ArrayList<Ejercito>();



    int indice1 = random(reinos.length);
    int indice2;
    do {
      indice2 = random(reinos.length);
    } while (indice2 == indice1);

    String nombreReino1 = reinos[indice1];
    String nombreReino2 = reinos[indice2];


    Mapa table = new Mapa();

    int nEjercitos1 = random(10) + 1;
    for(int i = 0; i < nEjercitos1; i += 1) addEjercito(table, reino1, "*", i, nombreReino1);

    int nEjercitos2 = random(10) + 1;
    for(int i = 0; i < nEjercitos2; i += 1) addEjercito(table, reino2, "#", i, nombreReino2);  

    play(table, reino1, reino2);


  }

  public static void play(Mapa table, ArrayList<Ejercito> reino1, ArrayList<Ejercito> reino2) {
    Scanner sc = new Scanner(System.in);
    System.out.println("###################################");

    while (true) {
      printTable(table);
      batalla(table, reino1, reino2);

      System.out.println("Ingresa 0 para salir");
      if(sc.nextInt() == 0) break;
    }
  }
  
  public static void addEjercito(Mapa t, ArrayList<Ejercito> r, String equipo, int i, String reino) {
    int x = random(10);
    int y = random(10);
    String name = "Reino " + (i + 1);
    if(!(t.getTable()[x][y] == null)) addEjercito(t, r, equipo, i, reino);
    else {
      Ejercito ejercito = new Ejercito(equipo);
      ejercito.setColumna(x);
      ejercito.setFila(y);
      ejercito.setNombre(name);
      ejercito.setReino(reino);
      t.getTable()[x][y] = ejercito;
      r.add(ejercito);
    }
  }

  public static void printTable(Mapa t) {
    System.out.println("     A      B      C      D      E      F      G      H      I      J      ");
    System.out.println("  -----------------------------------------------------------------------");
    for(int i = 0; i < t.getTable().length; i += 1) {
      System.out.print((i + 1) + " |");
      for(int j = 0; j < t.getTable().length; j += 1) {
        Ejercito ejercito = t.getTable()[i][j];
        if(ejercito == null) System.out.print("      |");
        else {
          int suma = 0;
          for(Soldado s : ejercito.getMisSoldados()) suma += s.getNivelVida();
          System.out.print(" " + ejercito.getTeam() + "/" + suma +  " |");
        }
      }
      System.out.println();
      System.out.println("  -----------------------------------------------------------------------");
    }
  }

  public static int random(int n) {
    return (int) (Math.random() * n);
  }

  public static void batalla(Mapa m, ArrayList<Ejercito> reino1, ArrayList<Ejercito> reino2) {
    int bonus1 = 0;
    int bonus2 = 0;

    if(
      reino1.get(0).getReino() == "Inglaterra" && m.getTerreno() == "bosque"
      || reino1.get(0).getReino() == "Francia" && m.getTerreno() == "campo"
      || reino1.get(0).getReino() == "Castilla" && m.getTerreno() == "montaña"
      || reino1.get(0).getReino() == "Moros" && m.getTerreno() == "desierto"
      || reino1.get(0).getReino() == "Sacro" && m.getTerreno() == "playa"
    ) for(Ejercito e : reino1) bonus1 += e.getMisSoldados().size();

    if(
      reino2.get(0).getReino() == "Inglaterra" && m.getTerreno() == "bosque"
      || reino2.get(0).getReino() == "Francia" && m.getTerreno() == "campo"
      || reino2.get(0).getReino() == "Castilla" && m.getTerreno() == "montaña"
      || reino2.get(0).getReino() == "Moros" && m.getTerreno() == "desierto"
      || reino2.get(0).getReino() == "Sacro" && m.getTerreno() == "playa"
    ) for(Ejercito e : reino2) bonus2 += e.getMisSoldados().size();


    int suma1 = 0;
    for(Ejercito e : reino1)
      for(Soldado s : e.getMisSoldados())
        suma1 += s.getNivelVida();
    int suma2 = 0;
    for(Ejercito e : reino2)
      for(Soldado s : e.getMisSoldados())
        suma2 += s.getNivelVida();
    
    System.out.println("BONUS DE TERRENO: ");
    System.out.println("Primer reino + " + bonus1);
    System.out.println("Segundo reino + " + bonus2);

    System.out.println("---->   Suma de nivel de puntos absoluto:");
    System.out.println("El primer reino tiene " + suma1 + " Puntos");
    System.out.println("El segundo reino tiene " + suma2 + " Puntos");
    if(suma1 > suma2) System.out.println("Gana " + reino1.get(0).getReino());
    else if(suma1 < suma2) System.out.println("Gana " + reino2.get(0).getReino());
    else System.out.println("Quedan en empate");

    System.out.println("---->   Por probabilidades:");
    System.out.println("El reino 1 tiene " + (int)((suma1/(double)(suma2 +suma1))*100) + "% de posibilidades");
    System.out.println("El reino 1 tiene " + (int)((suma2/(double)(suma2 +suma1))*100) + "% de posibilidades");
    if(random(suma1 + suma2) > suma2) System.out.println("Gana " + reino1.get(0).getReino());
    else System.out.println("Gana " + reino2.get(0).getReino());

    System.out.println("---->   Alreatoriamente 50% cada uno");
    System.out.println("Cada reino tiene el 50% de ganar");
    if(random(10) > 5)  System.out.println("Gana " + reino1.get(0).getReino());
    else System.out.println("Gana " + reino2.get(0).getReino());
  }
  
}