package lab.lab09;
import java.util.*;

public class VideoJuego4 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    while (true) {
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
    System.out.println("-------------------------------------------------------------");
    for(int i = 0; i < t.length; i += 1) {
      System.out.print("|");
      for(int j = 0; j < t.length; j += 1) {
        Soldado soldado = t[i][j];
        if(soldado == null) System.out.print("     |");
        else System.out.print(" " + soldado.getTeam() + "/"+soldado.getNivelVida()+" |");
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
  public static void printWinner(Soldado[][] t, ArrayList<Soldado> e1 , ArrayList<Soldado> e2) {
    int count1 = 0;
    int count2 = 0;

    for(Soldado s : e1) count1 += s.getNivelVida();
    for(Soldado s : e2) count2 += s.getNivelVida();

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