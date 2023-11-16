package lab.lab18;
import java.util.*;

public class Ejercito {
  private ArrayList<Soldado> misSoldados = new ArrayList<Soldado>(); // *
  private ArrayList<Espadachin> misEspadachines = new ArrayList<Espadachin>();
  private ArrayList<Caballero> misCaballero = new ArrayList<Caballero>();
  private ArrayList<Arquero> misArqueros = new ArrayList<Arquero>();

  String team;

  private int columna;
  private int fila;
  private String nombre;
  private String reino;

  public void setFila(int f) { fila = f; }

  public void setColumna(int c) { columna = c; }
  
  public void setNombre(String n) { nombre = n; }

  public void setReino(String p) { reino = p; }
  
  public int getColumna() { return columna; }
  public int getFila() { return fila; }
  public String getNombre() { return nombre; }
  public String getTeam() { return team; }
  public String getReino() { return reino; }

  public ArrayList<Arquero> getMisArqueros() { return misArqueros; }
  public ArrayList<Caballero> getMisCaballeros() { return misCaballero; }
  public ArrayList<Espadachin> getMisEspadachines() { return misEspadachines; }


  public Ejercito(String equipo) {
    this(equipo, null);
  }

  public Ejercito(String equipo, String reino) {
    int nSoldados1 = random(10) + 1;
    for(int i = 0; i < nSoldados1; i += 1) addSoldados(equipo, i);
    team = equipo;
    this.reino = reino;
  }

  public Ejercito(String equipo, String reino, int nums) {
    for(int i = 0; i < nums; i += 1) addSoldados(equipo, i);
    team = equipo;
    this.reino = reino;
  }

  public void addSoldados(String equipo, int i) {
    int[] soldados = new int[10];
    for(int j = 0; j < 10; j += 1) soldados[j] = random(3);

    for(int j = 0; j < 10; j += 1) {
      int points = random(5) + 1;
      int numEspadachines = 0;
      int numCaballeros = 0;
      int numArqueros = 0;
      String name;
      if(soldados[j] == 0) {
        name = "EspadachinX" + numEspadachines;
        Espadachin espadachin = new Espadachin(points, name, random(3));
        espadachin.setNombre(name);
        misEspadachines.add(espadachin);
        numEspadachines += 1;
      } else if (soldados[j] == 1) {
        name = "CaballeroX" + numCaballeros;
        Caballero caballero = new Caballero(points, name);
        caballero.setNombre(name);
        misCaballero.add(caballero);
      } else {
        name = "ArqueroX" + numArqueros;
        Arquero arquero = new Arquero(points, name);
        arquero.setNombre(name);
        misArqueros.add(arquero);
      }
    }
  }
  public static int random(int n) {
    return (int) (Math.random() * n);
  }

  public String toString() {
    String str = "Los soldados del ejercito de "+ reino +" son: \n";
    for(Soldado s : misSoldados) {
      str += s + "\n";
    }
    return str;
  }
}