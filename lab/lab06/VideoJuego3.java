package lab.lab06;

import java.util.ArrayList;

public class VideoJuego3 {
  public static void main(String[] args) {
    ArrayList<ArrayList<Soldado>> table = new ArrayList<ArrayList<Soldado>>();
    for(int i = 0; i < 10; i +=1) table.add(new ArrayList<Soldado>(10));
    for(ArrayList<Soldado> n : table) for(int i = 0; i < 10; i += 1) n.add(new Soldado(0));
    fillTables(table);
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

  public static void fillTables(ArrayList<ArrayList<Soldado>> t) {
    int nSoldados1 = random(10) + 1;
    int nSoldados2 = random(10) + 1;
    for (int i = 0; i < nSoldados1; i += 1)
      addSoldado(t, i, -1);
    for (int i = 0; i < nSoldados2; i += 1)
      addSoldado(t, i, 1);
  }

  public static void addSoldado(ArrayList<ArrayList<Soldado>> t, int i, int team) {
    int points = random(5) + 1;
    int x = random(10);
    int y = random(10);
    String name = "Soldado " + (i) + "X" + (team == -1 ? 1 : 2);
    if (t.get(x).get(y).getTeam() == 0){
      Soldado soldado = new Soldado(team);
      soldado.setColumna(x);
      soldado.setFila(y);
      soldado.setNombre(name);
      soldado.setPuntos(points);
      t.get(x).set(y, soldado);
    }
    else {
      addSoldado(t, i, team);
    }
  }

  public static void printTable(ArrayList<ArrayList<Soldado>> t) {
    System.out.println("-----------------------------------------");
    for (int i = 0; i < t.size(); i += 1) {
      System.out.print("|");
      for (int j = 0; j < t.size(); j += 1) {
        Soldado soldado = t.get(i).get(j);
        if (soldado.getTeam() == 0)
          System.out.print("   |");
        else if (soldado.getTeam() == -1)
          System.out.print(" * |");
        else
          System.out.print(" # |");
      }
      System.out.println();
      System.out.println("-----------------------------------------");
    }
  }

  public static void printArr(ArrayList<Soldado> arr) {
    for (Soldado n : arr) {
      if (n != null)
        System.out.println(n + " | ");
    }
  }

  public static int random(int n) {
    return (int) (Math.random() * n);
  }

  public static void printMayorNivel(ArrayList<ArrayList<Soldado>> t) {
    int maxPoints1 = 0;
    int maxPoints2 = 0;
    for (int i = 0; i < t.size(); i += 1) {
      for (int j = 0; j < t.get(i).size(); j += 1) {
        if(t.get(i).get(j).getTeam() == 1) continue;
        if (maxPoints1 < t.get(i).get(j).getPuntos())
          maxPoints1 = t.get(i).get(j).getPuntos();
      }
    }
    for (int i = 0; i < t.size(); i += 1) {
      for (int j = 0; j < t.get(i).size(); j += 1) {
        if(t.get(i).get(j).getTeam() == -1) continue;
        if (maxPoints2 < t.get(i).get(j).getPuntos())
          maxPoints2 = t.get(i).get(j).getPuntos();
      }
    }
    System.out.println("Los soldados con el mayor nivel de puntos del primer ejercito son:");
    for (int i = 0; i < t.size(); i += 1) {
      for (int j = 0; j < t.get(i).size(); j += 1) {
        if (t.get(i).get(j).getTeam() == 1)
          continue;
        if (maxPoints1 == t.get(i).get(j).getPuntos())
          System.out.println(t.get(i).get(j));
      }
    }
    System.out.println("Los soldados con el mayor nivel de puntos del segundo ejercito son:");
    for (int i = 0; i < t.size(); i += 1) {
      for (int j = 0; j < t.get(i).size(); j += 1) {
        if (t.get(i).get(j).getTeam() == -1)
          continue;
        if (maxPoints2 == t.get(i).get(j).getPuntos())
          System.out.println(t.get(i).get(j));
      }
    }
  }

  public static void printPromedioPuntos(ArrayList<ArrayList<Soldado>> t) {
    double sum1 = 0;
    int count1 = 0;
    for (int i = 0; i < t.size(); i += 1) {
      for (int j = 0; j < t.get(i).size(); j += 1) {
        if (t.get(i).get(j).getTeam() != -1 && t.get(i).get(j).getTeam() != 0) {
          sum1 += t.get(i).get(j).getPuntos();
          count1 += 1;
        }
      }
    }
    double sum2 = 0;
    int count2 = 0;
    for (int i = 0; i < t.size(); i += 1) {
      for (int j = 0; j < t.get(i).size(); j += 1) {
        if (t.get(i).get(j).getTeam() != 1 && t.get(i).get(j).getTeam() != 0) {
          sum2 += t.get(i).get(j).getPuntos();
          count2 += 1;
        }
      }
    }
    System.out.println("El promedio del primer ejercito es: " + (sum1 / count1));
    System.out.println("El promedio del segundo ejercito es: " + (sum2 / count2));
  }

  public static void printPuntosAll(ArrayList<ArrayList<Soldado>> t) {
    for (int i = 0; i < t.size(); i += 1) {
      for (int j = 0; j < t.get(i).size(); j += 1) {
        if (t.get(i).get(j).getTeam() != 0) {
          System.out.println("Nivel de vida del "
          + t.get(i).get(j).getNombre() + " del ejercito "
          + (t.get(i).get(j).getTeam() == -1 ? 1 : 2) + " es: "
          + t.get(i).get(j).getPuntos());
        }
      }
    }
  }

  public static void printSoladosOrdenados(ArrayList<ArrayList<Soldado>> t) {
    ArrayList<Soldado> newArr1 = new ArrayList<Soldado>();
    ArrayList<Soldado> newArr2 = new ArrayList<Soldado>();
    for (int i = 0; i < t.size(); i += 1) {
      for (int j = 0; j < t.get(i).size(); j += 1) {
        if (t.get(i).get(j).getTeam() == -1) {
          newArr1.add(t.get(i).get(j));
        }
        if (t.get(i).get(j).getTeam() == 1) {
          newArr2.add(t.get(i).get(j));
        }
      }
    }
    for (int i = 0; i < newArr1.size(); i += 1) {
      for (int j = 0; j < newArr1.size() - 1 - i; j += 1) {
        if (newArr1.get(j).getNombre().charAt(8) > newArr1.get(j+1).getNombre().charAt(8)) {
          Soldado s = newArr1.get(j);
          newArr1.set(j, newArr1.get(j+1));
          newArr1.set(j+1, s);
        }
      }
    }
    for (int i = 0; i < newArr2.size(); i += 1) {
      for (int j = 0; j < newArr2.size() - 1 - i; j += 1) {
        if (newArr2.get(j).getNombre().charAt(8) > newArr2.get(j+1).getNombre().charAt(8)) {
          Soldado s = newArr2.get(j);
          newArr2.set(j, newArr2.get(j+1));
          newArr2.set(j+1, s);
        }
      }
    }
    printArr(newArr1);
    System.out.println("-----------------------------------");
    printArr(newArr2);
  }

  public static void printRankingPointsBubble(ArrayList<ArrayList<Soldado>> t) {
    ArrayList<Soldado> newArr = new ArrayList<Soldado>();
    for (int i = 0; i < t.size(); i += 1) {
      for (int j = 0; j < t.get(i).size(); j += 1) {
        if (t.get(i).get(j).getTeam() == -1) {
          newArr.add(t.get(i).get(j));
        }
      }
    }
    for (int i = 0; i < newArr.size(); i += 1) {
      for (int j = 0; j < newArr.size() - 1 - i; j += 1) {
        if (newArr.get(j).getPuntos() < newArr.get(j+1).getPuntos()) {
          Soldado s = newArr.get(j);
          newArr.set(j, newArr.get(j+1));
          newArr.set(j+1, s);
        }
      }
    }
    printArr(newArr);
  }

  public static void printRankingPointsSelect(ArrayList<ArrayList<Soldado>> t) {
    ArrayList<Soldado> newArr = new ArrayList<Soldado>();
    for (int i = 0; i < t.size(); i += 1) {
      for (int j = 0; j < t.get(i).size(); j += 1) {
        if (t.get(i).get(j).getTeam() == 1) {
          newArr.add(t.get(i).get(j));
        }
      }
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
    printArr(newArr);
  }
}