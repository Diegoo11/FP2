package lab.lab07;
import java.util.*;

public class VideoJuego4 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    while (true) {
      Soldado[][] table = new Soldado[10][10];
      fillTable(table);
      printTable(table);
      printMayorNivel(table);
      System.out.println("___________________________________");
      printPromedioPuntos(table);
      System.out.println("___________________________________");
      printPuntosAll(table);
      System.out.println("___________________________________");
      printSoladosOrdenados(table);
      System.out.println("___________________________________");
      printRankingPointsBubble(table);
      System.out.println("___________________________________");
      printRankingPointsSelect(table);
  
      printWinner(table);
      System.out.print("Ingrese '1' si desea continuar con el juego: ");
      if(sc.nextInt() != 1) break;
    }
  }
  public static void fillTable(Soldado[][] t) {
    int nSoldados1 = random(10) + 1;
    for(int i = 0; i < nSoldados1; i += 1) addSoldado(t, i, -1);

    int nSoldados2 = random(10) + 1;
    for(int i = 0; i < nSoldados2; i += 1) addSoldado(t, i, 1);
  }
  public static void addSoldado(Soldado[][] t, int i, int team) {
    int points = random(5) + 1;
    int x = random(10);
    int y = random(10);
    String name = "Soldado " + (i + 1);
    if(!(t[x][y] == null)) addSoldado(t, i, team);
    else {
      Soldado soldado = new Soldado(team);
      soldado.setColumna(x);
      soldado.setFila(y);
      soldado.setNombre(name);
      soldado.setPuntos(points);
      t[x][y] = soldado;
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
  public static void printMayorNivel(Soldado[][] t) {
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
    for(int i = 0; i < t.length; i += 1) {
      for(int j = 0; j < t[i].length; j += 1) {
        if(t[i][j] == null) continue;
        if(maxPoints1 == t[i][j].getPuntos() && t[i][j].getTeam() == -1)
          System.out.println(t[i][j]);
      }
    }
    System.out.println("Los soldados con el mayor nivel de puntos de la segunda flota son:");
    for(int i = 0; i < t.length; i += 1) {
      for(int j = 0; j < t[i].length; j += 1) {
        if(t[i][j] == null) continue;
        if(maxPoints2 == t[i][j].getPuntos() && t[i][j].getTeam() == 1)
          System.out.println(t[i][j]);
      }
    }
  }
  public static void printPromedioPuntos(Soldado[][] t) {
    double sum1 = 0;
    int count1 = 0;
    double sum2 = 0;
    int count2 = 0;
    for(int i = 0; i < t.length; i += 1) {
      for(int j = 0; j < t[i].length; j += 1) {
        if(t[i][j] == null) continue;
        else if (t[i][j].getTeam() == -1) {
          sum1 += t[i][j].getPuntos();
          count1 += 1;
        } else if (t[i][j].getTeam() == 1) {
          sum2 += t[i][j].getPuntos();
          count2 += 1;
        }
      }
    }
    System.out.println("El promedio de la primera flota es: " + (sum1/count1));
    System.out.println("El promedio de la segunda flota es: " + (sum2/count2));
  }
  public static void printPuntosAll(Soldado[][] t) {
    System.out.println("Nivel de vida de cada soldado de la primera flota: ");
    for(int i = 0; i < t.length; i += 1) {
      for(int j = 0; j < t[i].length; j += 1) {
        if(t[i][j] != null && t[i][j].getTeam() == -1) {
          System.out.println("Nivel de vida del " + t[i][j].getNombre() + " es: " + t[i][j].getPuntos());
        }
      }
    }
    System.out.println("Nivel de vida de cada soldado de la segunda flota: ");
    for(int i = 0; i < t.length; i += 1) {
      for(int j = 0; j < t[i].length; j += 1) {
        if(t[i][j] != null && t[i][j].getTeam() == 1) {
          System.out.println("Nivel de vida del " + t[i][j].getNombre() + " es: " + t[i][j].getPuntos());
        }
      }
    }
  }
  public static void printSoladosOrdenados(Soldado[][] t) {
    int count1 = 0;
    Soldado[] newArr1 = new Soldado[10];
    for(int i = 0; i < t.length; i += 1) {
      for(int j = 0; j < t[i].length; j += 1) {
        if(t[i][j] != null && t[i][j].getTeam() == -1) {
          newArr1[count1] = t[i][j];
          count1 += 1;
        }
      }
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
    for(int i = 0; i < t.length; i += 1) {
      for(int j = 0; j < t[i].length; j += 1) {
        if(t[i][j] != null && t[i][j].getTeam() == 1) {
          newArr2[count2] = t[i][j];
          count2 += 1;
        }
      }
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
  public static void printRankingPointsBubble(Soldado[][] t) {
    int count = 0;
    Soldado[] newArr = new Soldado[10];
    for(int i = 0; i < t.length; i += 1) {
      for(int j = 0; j < t[i].length; j += 1) {
        if(t[i][j] != null && t[i][j].getTeam() == -1) {
          newArr[count] = t[i][j];
          count += 1;
        }
      }
    }
    for(int i = 0; i < count - 1; i += 1) {
      for(int j = 0; j < count - 1 - i; j += 1) {
        if(newArr[j].getPuntos() < newArr[j + 1].getPuntos()) {
          Soldado s = newArr[j];
          newArr[j] = newArr[j + 1];
          newArr[j + 1] = s;
        }
      }
    }
    printArr(newArr);
  }
  public static void printRankingPointsSelect(Soldado[][] t) {
    int count = 0;
    Soldado[] newArr = new Soldado[10];
    for(int i = 0; i < t.length; i += 1) {
      for(int j = 0; j < t[i].length; j += 1) {
        if(t[i][j] != null && t[i][j].getTeam() == 1) {
          newArr[count] = t[i][j];
          count += 1;
        }
      }
    }
    for(int i = 0; i < count - 1; i += 1) {
      int min = i;
      for(int j = i; j < count; j += 1) {
        min = newArr[min].getPuntos() < newArr[j].getPuntos() ? j : min;
      }
      Soldado soldado = newArr[i];
      newArr[i] = newArr[min];
      newArr[min] = soldado;
    }
    printArr(newArr);
  }
  public static void printWinner(Soldado[][] t) {
    int count1 = 0;
    int count2 = 0;
    for(Soldado[] arr : t) {
      for(Soldado s : arr) {
        if(s == null) continue;
        if(s.getTeam() == -1) count1 += 1;
        if(s.getTeam() == 1) count1 += 1;
      }
    }

    if(randomWinner(count1, count2)) {
      System.out.println("GANA LA PRIMERA FLOTA");
    } else {
      System.out.println("GANA LA SEGUNDA FLOTA");
    }
    System.out.println("El ganador se escogio con las probalidades dadas"
      +"por la cantidad de soldados de cada flota");
  }
  public static boolean randomWinner(int n, int m) {
    return n > random(n + m);
  }
}