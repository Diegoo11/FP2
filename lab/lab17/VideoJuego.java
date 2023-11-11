package lab.lab17;

import java.util.*;

public class VideoJuego {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    
    while (true) {
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
  }

  public static void play(Mapa table, ArrayList<Ejercito> reino1, ArrayList<Ejercito> reino2) {
    Scanner sc = new Scanner(System.in);
    System.out.println("###################################");

    int turno = 1;
    while (true) {
      printTable(table);
      mover(table, reino1, reino2, turno);

      turno = turno == 1 ? 2 : 1;

      String winner = null;
      if(Soldado.getNumTeam1() == 0) winner = "*";
      if(Soldado.getNumTeam2() == 0) winner = "#";
      
      if(winner != null) {
        System.out.println("###########################");
        System.out.println("GANA EL EQUIPO " + winner);
        System.out.println("###########################");
        break;
      }
      sc.next();
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

  public static void mover(Mapa t, ArrayList<Ejercito> e1, ArrayList<Ejercito> e2, int turno) {
    Scanner sc = new Scanner(System.in);
    while (true) {
      System.out.println("Toca moverse al equipo " + (turno == 1 ? "*" : "#"));
      System.out.println("Ingrese la posicion de la ficha a mover: ");
      int y = sc.next().toUpperCase().charAt(0) - 65;
      int x = sc.nextInt() - 1;
      Ejercito s = t.getTable()[x][y];

      if (s == null) {
        System.out.println("Jugada no valida");
        continue;
      }

      if (!s.getTeam().equals(turno == 1 ? "*" : "#")) {
        System.out.println("NO ES EL TURNO DEL EQUIPO: " + s.getTeam());
        continue;
      }

      System.out.println(s);


      System.out.println("Ingrese la nueva posicion deseada: ");
      int yF = sc.next().toUpperCase().charAt(0) - 65;
      int xF = sc.nextInt() - 1;
      Ejercito sF = t.getTable()[xF][yF];

      if (x - xF > 1 || x - xF < -1 || y - yF > 1 || y - yF < -1) {
        System.out.println("Superaste el maximo de casillas por movimiento");
        continue;
      }
      if (xF < 0 || xF > 9 || y < 0 || y > 9) {
        System.out.println("Limite del tablero excedido");
        continue;
      }

      if (sF == null) {
        s.setColumna(xF);
        s.setFila(yF);
        t.getTable()[xF][yF] = s;
        t.getTable()[x][y] = null;
        return;
      }

      if (sF.getTeam().equals(s.getTeam())) {
        System.out.println("Ya se encuentra un soldado aliado en esa posicion");
        continue;
      }

      if (!sF.getTeam().equals(s.getTeam())) {
        System.out.println(sF);
        atacar(t, s, sF);
        return;
      }
    }
  }
  
  public static void atacar(Mapa m, Ejercito s1, Ejercito s2) {
    int sum1 = 0;
    for(Soldado s : s1.getMisSoldados()) sum1 += s.getNivelVida();

    int sum2 = 0;
    for(Soldado s : s2.getMisSoldados()) sum2 += s.getNivelVida();

    int bonus1 = 0;
    int bonus2 = 0;

    if(
      s1.getReino() == "Inglaterra" && m.getTerreno() == "bosque"
      || s1.getReino() == "Francia" && m.getTerreno() == "campo"
      || s1.getReino() == "Castilla" && m.getTerreno() == "montaña"
      || s1.getReino() == "Moros" && m.getTerreno() == "desierto"
      || s1.getReino() == "Sacro" && m.getTerreno() == "playa"
    ) bonus1 += s1.getMisSoldados().size();

    if(
      s2.getReino() == "Inglaterra" && m.getTerreno() == "bosque"
      || s2.getReino() == "Francia" && m.getTerreno() == "campo"
      || s2.getReino() == "Castilla" && m.getTerreno() == "montaña"
      || s2.getReino() == "Moros" && m.getTerreno() == "desierto"
      || s2.getReino() == "Sacro" && m.getTerreno() == "playa"
    ) bonus2 += s2.getMisSoldados().size();

    
    System.out.println("BONUS DE TERRENO: ");
    System.out.println("Primer reino + " + bonus1);
    System.out.println("Segundo reino + " + bonus2);

    sum1 += bonus1;
    sum2 += bonus2;


    System.out.println("Tu ejercito tiene " + ((100.0/(sum1 + sum2))*sum1)
    + "% de posibilidades de vencer, y el enemigo " + ((100.0/(sum1 + sum2))*sum2)
    + "% de posibilidades de vencerte" );

    if(sum1 > Math.random() * (sum1 + sum2)) {
      System.out.println("Derrotaste al ejercito enemigo");
      m.getTable()[s1.getColumna()][s1.getFila()] = null;
      s1.setColumna(s2.getColumna());
      s1.setFila(s2.getFila());
      m.getTable()[s1.getColumna()][s1.getFila()] = s1;
      // s1.setNivelVida(s1.getNivelVida() + 1);
    } else {
      System.out.println("Te derroto el ejercito enemigo");
      m.getTable()[s1.getColumna()][s1.getFila()] = null;
    }

  }
}