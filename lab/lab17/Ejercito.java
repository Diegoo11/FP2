package lab.lab17;
import java.util.*;

public class Ejercito {
  private ArrayList<Soldado> misSoldados = new ArrayList<Soldado>(); // *
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

  public ArrayList<Soldado> getMisSoldados() { return misSoldados; }

  public Ejercito(String equipo) {
    this(equipo, null);
  }

  public Ejercito(String equipo, String reino) {
    int nSoldados1 = random(10) + 1;
    for(int i = 0; i < nSoldados1; i += 1) addSoldado(misSoldados, equipo, i);
    team = equipo;
    this.reino = reino;
  }

  public Ejercito(String equipo, String reino, int nums) {

    for(int i = 0; i < nums; i += 1) addSoldado(misSoldados, equipo, i);
    team = equipo;
    this.reino = reino;
  }

  public static void addSoldado(ArrayList<Soldado> e, String equipo, int i) {
    int points = random(5) + 1;
    String name = "Soldado " + (i + 1);
    Soldado soldado = new Soldado(equipo);
    soldado.setNombre(name);
    soldado.setNivelVida(points);
    e.add(soldado);
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