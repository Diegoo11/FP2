package lab.lab05;

public class VideoJuego2 {
  public static void main(String[] args) {
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
  }
  public static void fillTable(Soldado[][] t) {
    int nSoldados = random(10) + 1;
    for(int i = 0; i < nSoldados; i += 1) addSoldado(t, i);
  }
  public static void addSoldado(Soldado[][] t, int i) {
    int points = random(5) + 1;
    int x = random(10);
    int y = random(10);
    String name = "Soldado " + (i + 1);
    if(!(t[x][y] == null)) addSoldado(t, i);
    else {
      Soldado soldado = new Soldado();
      soldado.setColumna(x);
      soldado.setFila(y);
      soldado.setNombre(name);
      soldado.setPuntos(points);
      t[x][y] = soldado;
    }
  }
  public static void printTable(Soldado[][] t) {
    System.out.println("-----------------------------------------");
    for(int i = 0; i < t.length; i += 1) {
      System.out.print("|");
      for(int j = 0; j < t.length; j += 1) {
        Soldado soldado = t[i][j];
        if(soldado == null) System.out.print("   |");
        else System.out.print(" * |");
      }
      System.out.println();
      System.out.println("-----------------------------------------");
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
    int maxPoints = 0;
    for(int i = 0; i < t.length; i += 1) {
      for(int j = 0; j < t[i].length; j += 1) {
        if(t[i][j] == null) continue;
        if(maxPoints < t[i][j].getPuntos()) maxPoints = t[i][j].getPuntos();
      }
    }
    System.out.println("Los soldados con el mayor nivel de puntos son:");
    for(int i = 0; i < t.length; i += 1) {
      for(int j = 0; j < t[i].length; j += 1) {
        if(t[i][j] == null) continue;
        if(maxPoints == t[i][j].getPuntos()) System.out.println(t[i][j]);
      }
    }
  }
  public static void printPromedioPuntos(Soldado[][] t) {
    double sum = 0;
    int count = 0;
    for(int i = 0; i < t.length; i += 1) {
      for(int j = 0; j < t[i].length; j += 1) {
        if(t[i][j] != null) {
          sum += t[i][j].getPuntos();
          count += 1;
        }
      }
    }
    System.out.println("El promedio es: " + (sum/count));
  }
  public static void printPuntosAll(Soldado[][] t) {
    for(int i = 0; i < t.length; i += 1) {
      for(int j = 0; j < t[i].length; j += 1) {
        if(t[i][j] != null) {
          System.out.println("Nivel de vida del " + t[i][j].getNombre() + " es: " + t[i][j].getPuntos());
        }
      }
    }
  }
  public static void printSoladosOrdenados(Soldado[][] t) {
    int count = 0;
    Soldado[] newArr = new Soldado[10];
    for(int i = 0; i < t.length; i += 1) {
      for(int j = 0; j < t[i].length; j += 1) {
        if(t[i][j] != null) {
          newArr[count] = t[i][j];
          count += 1;
        }
      }
    }
    for(int i = 0; i < count - 1 ; i += 1) {
      for(int j = 0; j < count - 1 - i; j += 1) {
        if(newArr[j].getNombre().charAt(8) > newArr[j + 1].getNombre().charAt(8)) {
          Soldado s = newArr[j];
          newArr[j] = newArr[j + 1];
          newArr[j + 1] = s;
        }
      }
    }
    printArr(newArr);
  }
  public static void printRankingPointsBubble(Soldado[][] t) {
    int count = 0;
    Soldado[] newArr = new Soldado[10];
    for(int i = 0; i < t.length; i += 1) {
      for(int j = 0; j < t[i].length; j += 1) {
        if(t[i][j] != null) {
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
        if(t[i][j] != null) {
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
}