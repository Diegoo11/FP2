package lab.lab10;
import java.util.*;

public class VideoJuego {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    Soldado[][] table = new Soldado[10][10];
    ArrayList<Soldado> ejercito1 = new ArrayList<Soldado>();
    ArrayList<Soldado> ejercito2 = new ArrayList<Soldado>();
    fillTable(table, ejercito1, ejercito2);
    printTable(table);
    printMayorNivel(table, ejercito1, ejercito2);
    System.out.println("___________________________________");
    System.out.println("IMPRIMIR PROMEDIO DE PUNTOS");
    printPromedioPuntos(table, ejercito1, ejercito2);
    System.out.println("___________________________________");
    System.out.println("SOLDADOS ORDENADOS");
    printSoladosOrdenados(table, ejercito1, ejercito2);
    System.out.println("___________________________________");
    System.out.println("RANKING DE PUNTOS EJERCITO1 POR BUBBLE SORT");
    printRankingPointsBubble(table, ejercito1);
    System.out.println("___________________________________");
    System.out.println("RANKING DE PUNTOS EJERCITO2 POR SELECT SORT");
    printRankingPointsSelect(table, ejercito2);

    System.out.println("###################################");
    int turno = 1;
    while (true) {
      printTable(table);
      mover(table, ejercito1, ejercito2, turno);

      turno = turno == 1 ? 2 : 1;

      String winner = getWinner(ejercito1, ejercito2);
      
      if(winner != null) {
        System.out.println("###########################");
        System.out.println("GANA EL EQUIPO " + winner);
        System.out.println("###########################");
        break;
      }
    }
  }
  public static void fillTable(Soldado[][] t, ArrayList<Soldado> e1, ArrayList<Soldado> e2) {
    int nSoldados1 = random(10) + 1;
    for(int i = 0; i < nSoldados1; i += 1) addSoldado(t, i, e1, "*");

    int nSoldados2 = random(10) + 1;
    for(int i = 0; i < nSoldados2; i += 1) addSoldado(t, i, e2, "#");
  }
  public static void addSoldado(Soldado[][] t, int i, ArrayList<Soldado> e, String team) {
    int points = random(5) + 1;
    int x = random(10);
    int y = random(10);
    String name = "Soldado " + (i + 1);
    if(!(t[x][y] == null)) addSoldado(t, i, e, team);
    else {
      Soldado soldado = new Soldado(team);
      soldado.setColumna(x);
      soldado.setFila(y);
      soldado.setNombre(name);
      soldado.setNivelVida(points);
      t[x][y] = soldado;
      e.add(soldado);
    }
  }
  public static void printTable(Soldado[][] t) {
    System.out.println("     A     B     C     D     E     F     G     H     I     J     ");
    System.out.println("  -------------------------------------------------------------");
    for(int i = 0; i < t.length; i += 1) {
      System.out.print((i + 1) + " |");
      for(int j = 0; j < t.length; j += 1) {
        Soldado soldado = t[i][j];
        if(soldado == null) System.out.print("     |");
        else System.out.print(" " + soldado.getTeam() + "/"+soldado.getNivelVida()+" |");
      }
      System.out.println();
      System.out.println("  -------------------------------------------------------------");
    }
  }
  public static void printArr(Soldado[] arr) {
    for(Soldado n : arr) {
      if(n != null)System.out.println(n + " | ");
    }
  }
  public static int random(int n) {
    return (int) (Math.random() * n);
  }
  public static void printMayorNivel(Soldado[][] t, ArrayList<Soldado> e1, ArrayList<Soldado> e2) {
    int maxPoints1 = 0;
    int maxPoints2 = 0;

    for(int i = 0; i < e1.size(); i += 1) {
      if(e1.get(i).getNivelVida() > maxPoints1) maxPoints1 = e1.get(i).getNivelVida();
    }
    for(int i = 0; i < e2.size(); i += 1) {
      if(e2.get(i).getNivelVida() > maxPoints2) maxPoints2 = e2.get(i).getNivelVida();
    }

    System.out.println("Los soldados con el mayor nivel de puntos de la primera flota son:");
    for(Soldado s : e1) { 
      if(maxPoints1 == s.getNivelVida())
        System.out.println(s);
    }
    System.out.println("Los soldados con el mayor nivel de puntos de la segunda flota son:");
    for(Soldado s : e1) { 
      if(maxPoints2 == s.getNivelVida())
        System.out.println(s);
    }
  }
  public static void printPromedioPuntos(Soldado[][] t, ArrayList<Soldado> e1, ArrayList<Soldado> e2) {
    double sum1 = 0;
    int count1 = 0;
    double sum2 = 0;
    int count2 = 0;

    for(Soldado s : e1){
      sum1 += s.getNivelVida();
      count1 += 1;
    }
    for(Soldado s : e2){
      sum2 += s.getNivelVida();
      count2 += 1;
    }
    System.out.println("El promedio de la primera flota es: " + (sum1/count1));
    System.out.println("El promedio de la segunda flota es: " + (sum2/count2));
  }
  public static void printPuntosAll(Soldado[][] t, ArrayList<Soldado> e1, ArrayList<Soldado> e2) {
    System.out.println("Nivel de vida de cada soldado de la primera flota: ");
    for(Soldado s : e1) { 
      System.out.println("Nivel de vida del " + s.getNombre() + " es: " + s.getNivelVida());
    }
    System.out.println("Nivel de vida de cada soldado de la segunda flota: ");
    for(Soldado s : e2) { 
      System.out.println("Nivel de vida del " + s.getNombre() + " es: " + s.getNivelVida());
    }
  }
  public static void printSoladosOrdenados(Soldado[][] t, ArrayList<Soldado> e1, ArrayList<Soldado> e2) {
    int count1 = 0;
    Soldado[] newArr1 = new Soldado[10];

    for(Soldado s : e1) {
      newArr1[count1] = s;
      count1 += 1;
    }

    for(int i = 0; i < count1 - 1 ; i += 1) {
      for(int j = 0; j < count1 - 1 - i; j += 1) {
        if(newArr1[j].getNombre().charAt(8) > newArr1[j + 1].getNombre().charAt(8)) {
          Soldado s = newArr1[j];
          newArr1[j] = newArr1[j + 1];
          newArr1[j + 1] = s;
        }
      }
    }

    int count2 = 0;
    Soldado[] newArr2 = new Soldado[10];

    for(Soldado s : e2) {
      newArr2[count2] = s;
      count2 += 1;
    }

    for(int i = 0; i < count2 - 1 ; i += 1) {
      for(int j = 0; j < count2 - 1 - i; j += 1) {
        if(newArr2[j].getNombre().charAt(8) > newArr2[j + 1].getNombre().charAt(8)) {
          Soldado s = newArr2[j];
          newArr2[j] = newArr2[j + 1];
          newArr2[j + 1] = s;
        }
      }
    }

    System.out.println("Soldados ordenado de la primera flota");
    printArr(newArr1);
    System.out.println("Soldados ordenado de la segunda flota");
    printArr(newArr2);
  }
  public static void printRankingPointsBubble(Soldado[][] t, ArrayList<Soldado> e) {
    ArrayList<Soldado> newArr = new ArrayList<Soldado>();

    for(Soldado s : e) {
      newArr.add(s);
    }

    for(int i = 0; i < newArr.size() - 1; i += 1) {
      for(int j = 0; j < newArr.size() - 1 - i; j+=1) {
        if(newArr.get(j).getNivelVida() > newArr.get(j+1).getNivelVida()) {
          Soldado num = newArr.get(j+1);
          newArr.set(j+1, newArr.get(j));
          newArr.set(j, num);
        }
      } 
    }
    System.out.println(newArr);
  }
  public static void printRankingPointsSelect(Soldado[][] t, ArrayList<Soldado> e) {
    ArrayList<Soldado> newArr = new ArrayList<Soldado>();

    for(Soldado s : e) {
      newArr.add(s);
    }

    for (int i = 0; i < newArr.size() - 1; i += 1) {
      int min = i;
      for (int j = i; j < newArr.size(); j += 1) {
        min = newArr.get(min).getNivelVida() < newArr.get(j).getNivelVida() ? j : min;
      }
      Soldado soldado = newArr.get(i);
      newArr.set(i, newArr.get(min));
      newArr.set(min, soldado);
    }
    System.out.println(newArr);
  }
  public static String getWinner(ArrayList<Soldado> e1 , ArrayList<Soldado> e2) {
    boolean isWinner = true;

    for(Soldado s: e1) {
      isWinner = isWinner && !s.isLive();
    }
    if(isWinner) return e1.get(0).getTeam();

    isWinner = true;
    for(Soldado s: e2) {
      isWinner = isWinner && !s.isLive();
    }
    if(isWinner) return e2.get(0).getTeam();

    return null;
  }
  public static boolean randomWinner(int n, int m) {
    return n > random(n + m);
  }
  public static void mover(Soldado[][] t, ArrayList<Soldado> e1, ArrayList<Soldado> e2, int turno) {
    Scanner sc = new Scanner(System.in);
    while (true) {
      System.out.println("Toca moverse al equipo " + (turno == 1 ? "*" : "#"));
      System.out.println("Ingrese la posicion de la ficha a mover: ");
      int y = sc.next().toUpperCase().charAt(0) - 65;
      int x = sc.nextInt() - 1;
      Soldado s = t[x][y];

      if (s == null) {
        System.out.println("Jugada no valida");
        continue;
      }

      if (!s.getTeam().equals(turno == 1 ? "*" : "#")) {
        System.out.println("NO ES EL TURNO DEL EQUIPO: " + s.getTeam());
        continue;
      }

      System.out.println("Ingrese la nueva posicion deseada: ");
      int yF = sc.next().toUpperCase().charAt(0) - 65;
      int xF = sc.nextInt() - 1;
      Soldado sF = t[xF][yF];

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
        atacar(t, s, sF);
        return;
      }
    }
  }
  public static void atacar(Soldado[][] t, Soldado s1, Soldado s2) {
    if(s1.getNivelVida() > s2.getNivelVida()) {
      System.out.println("Derrotaste al soldado enemigo:\n" + s2);
      t[s1.getColumna()][s1.getFila()] = null;
      s1.setColumna(s2.getColumna());
      s1.setFila(s2.getFila());

      t[s1.getColumna()][s1.getFila()] = s1;
    } else {
      System.out.println("Te derroto un soldado enemigo;\n" + s1 + " ah muerto");
      s1.morir();
      t[s1.getColumna()][s1.getFila()] = null;
    }
  }
}