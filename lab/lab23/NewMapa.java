package lab.lab23;

import java.util.ArrayList;

public class NewMapa {
  final private String[] TERRENOS = {"bosque", "campo", "montaña", "desierto", "playa"};
  private Ejercito[][] table = new Ejercito[10][10];
  private String terreno = TERRENOS[random(5)];

  public NewMapa() {
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

    int nEjercitos1 = random(10) + 1;
    for(int i = 0; i < nEjercitos1; i += 1) addEjercito(reino1, "*", i, nombreReino1);

    int nEjercitos2 = random(10) + 1;
    for(int i = 0; i < nEjercitos2; i += 1) addEjercito(reino2, "#", i, nombreReino2);  
  }

  public Ejercito[][] getTable() {
    return table;
  }
  public String getTerreno() {
    return terreno;
  }

  private int random(int n) {
    return (int) (Math.random() * n);
  }

  public void addEjercito(ArrayList<Ejercito> r, String equipo, int i, String reino) {
    int x = random(10);
    int y = random(10);
    System.out.println("a");
    String name = "Reino " + (i + 1);
    if(!(table[x][y] == null)) addEjercito(r, equipo, i, reino);
    else {
      Ejercito ejercito = new Ejercito(equipo, reino);
      ejercito.setColumna(x);
      ejercito.setFila(y);
      ejercito.setNombre(name);
      ejercito.setReino(reino);
      table[x][y] = ejercito;
      r.add(ejercito);
    }
  }

  public void print() {
    System.out.println("     A      B      C      D      E      F      G      H      I      J      ");
    System.out.println("  -----------------------------------------------------------------------");
    for(int i = 0; i < table.length; i += 1) {
      System.out.print((i + 1) + " |");
      for(int j = 0; j < table.length; j += 1) {
        Ejercito ejercito = table[i][j];
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
}
