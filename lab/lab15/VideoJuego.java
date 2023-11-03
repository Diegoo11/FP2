package lab.lab15;

import java.util.*;

public class VideoJuego {
  public static void main(String[] args) {
    String[] reinos = {"Inglaterra", "Francia", "Sacro", "Castilla", "Moros"};
    ArrayList<Ejercito> reino1 = new ArrayList<Ejercito>();
    ArrayList<Ejercito> reino2 = new ArrayList<Ejercito>();

    Scanner sc = new Scanner(System.in);

    int indice1 = random(reinos.length);
    int indice2;
    do {
      indice2 = random(reinos.length);
    } while (indice2 == indice1);

    String nombreReino1 = reinos[indice1];
    String nombreReino2 = reinos[indice2];


    Ejercito[][] table = new Ejercito[10][10];

    int nEjercitos1 = random(10) + 1;
    for(int i = 0; i < nEjercitos1; i += 1) addEjercito(table, reino1, "*", i, nombreReino1);

    int nEjercitos2 = random(10) + 1;
    for(int i = 0; i < nEjercitos2; i += 1) addEjercito(table, reino2, "#", i, nombreReino2);  

    while (true) {
      System.out.println("1. Modificar el tablero");
      System.out.println("2. Partida rapida");

      int userInput = sc.nextInt();

      if(userInput == 1) customPlay(table, reino1, reino2);
      if(userInput == 2) play(table, reino1, reino2);
    }
  }

  public static void customPlay(Ejercito[][] table, ArrayList<Ejercito> reino1, ArrayList<Ejercito> reino2) {
    Scanner sc = new Scanner(System.in);
    
    while (true) {
      printTable(table);
      System.out.println("1. Añadir un ejercito");
      System.out.println("2. Eliminar un ejercito");
      System.out.println("3. Editar un ejercito");
      System.out.println("4. Salir");
      
      int userInput = sc.nextInt();

      if(userInput == 1) createArmy(table, reino1, reino2);
      if(userInput == 2) deleteArmy(table, reino1, reino2);
      if(userInput == 3) editArmy(table, reino1, reino2);
      if(userInput == 4) break;
    }
  }

  public static void deleteArmy(Ejercito[][] table, ArrayList<Ejercito> reino1, ArrayList<Ejercito> reino2) {
    Scanner sc = new Scanner(System.in);

    System.out.println("Ingresa la ubicacion del soldado: ");
    System.out.print("Ingresa la columna: ");
    int col = sc.next().toUpperCase().charAt(0) - 65;
    System.out.print("Ingresa la fila: ");
    int fila = sc.nextInt() - 1;

    table[fila][col] = null;
  }

  public static void createArmy(Ejercito[][] table, ArrayList<Ejercito> reino1, ArrayList<Ejercito> reino2) {
    Scanner sc = new Scanner(System.in);

    System.out.println("Ingresa la ubicacion del soldado: ");
    System.out.print("Ingresa la columna: ");
    int col = sc.next().toUpperCase().charAt(0) - 65;
    System.out.print("Ingresa la fila: ");
    int fila = sc.nextInt() - 1;

    System.out.print("Ingrese cuantos soldados tendra este ejercito:");
    int nums = sc.nextInt();

    while (nums <= 0 || nums > 10) {
      System.out.print("Un ejercito puede tener de 1 a 10 soldados, vuelve a ingresar: ");
      nums = sc.nextInt();
    }

    System.out.println("Ingrese el equipo");
    System.out.println("1. " + reino1.get(0).getReino());
    System.out.println("2. " + reino2.get(0).getReino());
    Ejercito armyName = sc.nextInt() == 1 ? reino1.get(0) : reino2.get(0);

    Ejercito ejercito = new Ejercito(armyName.getTeam(), armyName.getReino(), nums);

    table[fila][col] = ejercito;
  }

  public static void editArmy(Ejercito[][] table, ArrayList<Ejercito> reino1, ArrayList<Ejercito> reino2) {
    Scanner sc = new Scanner(System.in);

    System.out.println("Ingresa la ubicacion del soldado: ");
    System.out.print("Ingresa la columna: ");
    int col = sc.next().toUpperCase().charAt(0) - 65;
    System.out.print("Ingresa la fila: ");
    int fila = sc.nextInt() - 1;

    Ejercito ejercito = table[fila][col];

    System.out.print("Ingrese cuantos soldados tendra este ejercito:");
    int nums = sc.nextInt();

    while (nums <= 0 || nums > 10) {
      System.out.print("Un ejercito puede tener de 1 a 10 soldados, vuelve a ingresar: ");
      nums = sc.nextInt();
    }


    Ejercito newEjercito = new Ejercito(ejercito.getTeam(), ejercito.getReino(), nums);

    newEjercito.setColumna(ejercito.getColumna());
    newEjercito.setFila(ejercito.getFila());
    newEjercito.setNombre(ejercito.getNombre());

    table[fila][col] = newEjercito;
  }

  public static void play(Ejercito[][] table, ArrayList<Ejercito> reino1, ArrayList<Ejercito> reino2) {
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
  
  public static void addEjercito(Ejercito[][] t, ArrayList<Ejercito> r, String equipo, int i, String reino) {
    int x = random(10);
    int y = random(10);
    String name = "Reino " + (i + 1);
    if(!(t[x][y] == null)) addEjercito(t, r, equipo, i, reino);
    else {
      Ejercito ejercito = new Ejercito(equipo);
      ejercito.setColumna(x);
      ejercito.setFila(y);
      ejercito.setNombre(name);
      ejercito.setReino(reino);
      t[x][y] = ejercito;
      r.add(ejercito);
    }
  }

  public static void printTable(Ejercito[][] t) {
    System.out.println("     A     B     C     D     E     F     G     H     I     J     ");
    System.out.println("  -------------------------------------------------------------");
    for(int i = 0; i < t.length; i += 1) {
      System.out.print((i + 1) + " |");
      for(int j = 0; j < t.length; j += 1) {
        Ejercito ejercito = t[i][j];
        if(ejercito == null) System.out.print("     |");
        else System.out.print("  " + ejercito.getTeam() + "  |");
      }
      System.out.println();
      System.out.println("  -------------------------------------------------------------");
    }
  }

  public static int random(int n) {
    return (int) (Math.random() * n);
  }
  
  public static void mover(Ejercito[][] t, ArrayList<Ejercito> e1, ArrayList<Ejercito> e2, int turno) {
    Scanner sc = new Scanner(System.in);
    while (true) {
      System.out.println("Toca moverse al equipo " + (turno == 1 ? "*" : "#"));
      System.out.println("Ingrese la posicion de la ficha a mover: ");
      int y = sc.next().toUpperCase().charAt(0) - 65;
      int x = sc.nextInt() - 1;
      Ejercito s = t[x][y];

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
      Ejercito sF = t[xF][yF];

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
        t[xF][yF] = s;
        t[x][y] = null;
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
  
  public static void atacar(Ejercito[][] t, Ejercito s1, Ejercito s2) {
    int sum1 = 0;
    for(Soldado s : s1.getMisSoldados()) sum1 += s.getNivelVida();

    int sum2 = 0;
    for(Soldado s : s2.getMisSoldados()) sum2 += s.getNivelVida();

    System.out.println("Tu ejercito tiene " + ((100.0/(sum1 + sum2))*sum1)
    + "% de posibilidades de vencer, y el enemigo " + ((100.0/(sum1 + sum2))*sum2)
    + "% de posibilidades de vencerte" );

    if(sum1 > Math.random() * (sum1 + sum2)) {
      System.out.println("Derrotaste al ejercito enemigo");
      t[s1.getColumna()][s1.getFila()] = null;
      s1.setColumna(s2.getColumna());
      s1.setFila(s2.getFila());
      t[s1.getColumna()][s1.getFila()] = s1;
      // s1.setNivelVida(s1.getNivelVida() + 1);
    } else {
      System.out.println("Te derroto el ejercito enemigo");
      t[s1.getColumna()][s1.getFila()] = null;
    }

  }

}
