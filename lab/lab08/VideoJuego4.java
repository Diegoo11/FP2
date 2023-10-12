package lab.lab08;
import java.util.*;

public class VideoJuego4 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    while (true) {
      Soldado[][] table = new Soldado[10][10];
      HashMap<String, Soldado> ejercito1 = new HashMap<String, Soldado>();
      HashMap<String, Soldado> ejercito2 = new HashMap<String, Soldado>();
      fillTable(table, ejercito1, ejercito2);
      printTable(table);
      printMayorNivel(table, ejercito1, ejercito2);
      System.out.println("___________________________________");
      System.out.println("IMPRIMIR PROMEDIO DE PUNTOS");
      printPromedioPuntos(table, ejercito1, ejercito2);
      System.out.println("___________________________________");
      System.out.println("IMPRIMIR TODOS LOS PUNTOS");
      printPuntosAll(table, ejercito1, ejercito2);
      System.out.println("___________________________________");
      System.out.println("SOLDADOS ORDENADOS");
      printSoladosOrdenados(table, ejercito1, ejercito2);
      System.out.println("___________________________________");
      System.out.println("RANKING DE PUNTOS POR BUBBLE SORT");
      printRankingPointsBubble(table, ejercito1);
      System.out.println("___________________________________");
      System.out.println("RANKING DE PUNTOS POR SELECT SORT");
      printRankingPointsSelect(table, ejercito2);

      System.out.println("___________________________________");
  
      printWinner(table, ejercito1, ejercito2);
      System.out.print("Ingrese '1' si desea continuar con el juego: ");
      if(sc.nextInt() != 1) break;
    }
  }
  public static void fillTable(Soldado[][] t, HashMap<String, Soldado> e1, HashMap<String, Soldado> e2) {
    int nSoldados1 = random(10) + 1;
    for(int i = 0; i < nSoldados1; i += 1) addSoldado(t, i, -1, e1);

    int nSoldados2 = random(10) + 1;
    for(int i = 0; i < nSoldados2; i += 1) addSoldado(t, i, 1, e2);
  }
  public static void addSoldado(Soldado[][] t, int i, int team, HashMap<String, Soldado> e) {
    int points = random(5) + 1;
    int x = random(10);
    int y = random(10);
    String name = "Soldado " + (i + 1);
    if(!(t[x][y] == null)) addSoldado(t, i, team, e);
    else {
      Soldado soldado = new Soldado(team);
      soldado.setColumna(x);
      soldado.setFila(y);
      soldado.setNombre(name);
      soldado.setPuntos(points);
      t[x][y] = soldado;
      e.put(name, soldado);
    }
  }
  public static void printTable(Soldado[][] t) {
    System.out.println("-------------------------------------------------------------");
    for(int i = 0; i < t.length; i += 1) {
      System.out.print("|");
      for(int j = 0; j < t.length; j += 1) {
        Soldado soldado = t[i][j];
        if(soldado == null) System.out.print("     |");
        else if (soldado.getTeam() == -1) System.out.print(" #/"+soldado.getPuntos()+" |");
        else System.out.print(" */"+soldado.getPuntos()+" |");
      }
      System.out.println();
      System.out.println("-------------------------------------------------------------");
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
  public static void printMayorNivel(Soldado[][] t, HashMap<String, Soldado> e1, HashMap<String, Soldado> e2) {
    int maxPoints1 = 0;
    int maxPoints2 = 0;
    for(int i = 0; i < t.length; i += 1) {
      for(int j = 0; j < t[i].length; j += 1) {
        if(t[i][j] == null) continue;
        if(maxPoints1 < t[i][j].getPuntos()
          && t[i][j].getTeam() == -1) maxPoints1 = t[i][j].getPuntos();
        if(maxPoints2 < t[i][j].getPuntos()
          && t[i][j].getTeam() == 1) maxPoints2 = t[i][j].getPuntos();
      }
    }
    System.out.println("Los soldados con el mayor nivel de puntos de la primera flota son:");
    for(String s : e1.keySet()) { 
      if(maxPoints1 == e1.get(s).getPuntos())
        System.out.println(e1.get(s));
    }
    System.out.println("Los soldados con el mayor nivel de puntos de la segunda flota son:");
    for(String s : e2.keySet()) { 
      if(maxPoints2 == e2.get(s).getPuntos())
        System.out.println(e2.get(s));
    }
  }
  public static void printPromedioPuntos(Soldado[][] t, HashMap<String, Soldado> e1, HashMap<String, Soldado> e2) {
    double sum1 = 0;
    int count1 = 0;
    double sum2 = 0;
    int count2 = 0;

    for(String s : e1.keySet()){
      sum1 += e1.get(s).getPuntos();
      count1 += 1;
    }
    for(String s : e2.keySet()){
      sum2 += e2.get(s).getPuntos();
      count2 += 1;
    }
    System.out.println("El promedio de la primera flota es: " + (sum1/count1));
    System.out.println("El promedio de la segunda flota es: " + (sum2/count2));
  }
  public static void printPuntosAll(Soldado[][] t, HashMap<String, Soldado> e1, HashMap<String, Soldado> e2) {
    System.out.println("Nivel de vida de cada soldado de la primera flota: ");
    for(String s : e1.keySet()) { 
      System.out.println("Nivel de vida del " + e1.get(s).getNombre() + " es: " + e1.get(s).getPuntos());
    }
    System.out.println("Nivel de vida de cada soldado de la segunda flota: ");
    for(String s : e2.keySet()) { 
      System.out.println("Nivel de vida del " + e2.get(s).getNombre() + " es: " + e2.get(s).getPuntos());
    }
  }
  public static void printSoladosOrdenados(Soldado[][] t, HashMap<String, Soldado> e1, HashMap<String, Soldado> e2) {
    int count1 = 0;
    Soldado[] newArr1 = new Soldado[10];
    
    for(String s : e1.keySet()) {
      newArr1[count1] = e1.get(s);
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
    for(String s : e2.keySet()) {
      newArr2[count2] = e2.get(s);
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
  public static void printRankingPointsBubble(Soldado[][] t, HashMap<String, Soldado> e) {
    ArrayList<Soldado> newArr = new ArrayList<Soldado>();

    for(String s : e.keySet()) {
      newArr.add(e.get(s));
    }

    for(int i = 0; i < newArr.size() - 1; i += 1) {
      for(int j = 0; j < newArr.size() - 1 - i; j+=1) {
        if(newArr.get(j).getPuntos() > newArr.get(j+1).getPuntos()) {
          Soldado num = newArr.get(j+1);
          newArr.set(j+1, newArr.get(j));
          newArr.set(j, num);
        }
      }
    }
    System.out.println(newArr);
  }
  public static void printRankingPointsSelect(Soldado[][] t, HashMap<String, Soldado> e) {
    ArrayList<Soldado> newArr = new ArrayList<Soldado>();

    for(String s : e.keySet()) {
      newArr.add(e.get(s));
    }

    for (int i = 0; i < newArr.size() - 1; i += 1) {
      int min = i;
      for (int j = i; j < newArr.size(); j += 1) {
        min = newArr.get(min).getPuntos() < newArr.get(j).getPuntos() ? j : min;
      }
      Soldado soldado = newArr.get(i);
      newArr.set(i, newArr.get(min));
      newArr.set(min, soldado);
    }
    System.out.println(newArr);
  }
  public static void printWinner(Soldado[][] t, HashMap<String, Soldado> e1 , HashMap<String, Soldado> e2) {
    int count1 = 0;
    int count2 = 0;

    for(String s : e1.keySet()) count1 += e1.get(s).getPuntos();
    for(String s : e2.keySet()) count2 += e2.get(s).getPuntos();

    if(randomWinner(count1, count2)) {
      System.out.println("GANA LA PRIMERA FLOTA");
    } else {
      System.out.println("GANA LA SEGUNDA FLOTA");
    }
    System.out.println("El ganador se escogio con las probalidades dadas"
      +"por la suma de los puntos de soldados de cada flota");
  }
  public static boolean randomWinner(int n, int m) {
    return n > random(n + m);
  }
}