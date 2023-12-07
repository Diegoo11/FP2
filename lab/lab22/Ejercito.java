package lab.lab22;
import java.util.*;

public class Ejercito {
  private ArrayList<Espadachin> misEspadachines = new ArrayList<Espadachin>();
  private ArrayList<Caballero> misCaballero = new ArrayList<Caballero>();
  private ArrayList<Arquero> misArqueros = new ArrayList<Arquero>();
  private ArrayList<Lancero> misLanceros = new ArrayList<Lancero>();
  private ArrayList<SoldadoComun> misSoldadosEspeciales = new ArrayList<SoldadoComun>();

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
  public ArrayList<Lancero> getMisLanceros() { return misLanceros; }
  public ArrayList<SoldadoComun> getMisSoldadosEspeciales() { return misSoldadosEspeciales; }


  public Ejercito(String equipo) {
    this(equipo, null);
  }

  public Ejercito(String equipo, String reino) {
    this.reino = reino;
    addSoldados(equipo);
    team = equipo;
  }

  public Ejercito(String equipo, String reino, int nums) {
    for(int i = 0; i < nums; i += 1) addSoldados(equipo);
    team = equipo;
    this.reino = reino;
  }

  public void addSoldados(String equipo) {
    int numSoldados = random(7) + 1;
    int numSoldadosEspeciales = random(2);
    for(int i = 0; i < numSoldadosEspeciales; i += 1) {
      System.out.println(reino);
      if(reino.equals("Inglaterra")) {
        misSoldadosEspeciales.add(new EspadachinReal(equipo, random(5)));
      }
      if(reino.equals("Francia")) {
        misSoldadosEspeciales.add(new CaballeroFranco(equipo));
      }
      if(reino.equals("Sacro")) {
        misSoldadosEspeciales.add(new EspadachinTeutonico(equipo, random(5)));
      }
      if(reino.equals("Castilla")) {
        misSoldadosEspeciales.add(new EspadachinConquistador(equipo, random(5)));
      }
      if(reino.equals("Moros")) {
        misSoldadosEspeciales.add(new CaballeroMoro(equipo));
      }
    }
    int[] soldados = new int[numSoldados];
    for(int j = 0; j < soldados.length; j += 1) {
      soldados[j] = random(4);
    }
    int numEspadachines = 0;
    int numCaballeros = 0;
    int numArqueros = 0;
    int numLaceros = 0;
    for(int j = 0; j < soldados.length; j += 1) {
      String name;
      if(soldados[j] == 0) {
        name = "EspadachinX" + numEspadachines;
        Espadachin espadachin = new Espadachin(equipo, random(3));
        espadachin.setNombre(name);
        misEspadachines.add(espadachin);
        numEspadachines += 1;
      } else if (soldados[j] == 1) {
        name = "CaballeroX" + numCaballeros;
        Caballero caballero = new Caballero(equipo);
        caballero.setNombre(name);
        misCaballero.add(caballero);
        numCaballeros += 1;
      } else if (soldados[j] == 2) {
        name = "LanceroX" + numLaceros;
        Lancero lancero = new Lancero(equipo, random(5));
        lancero.setNombre(name);
        misLanceros.add(lancero);
        numLaceros += 1;
      } else {
        name = "ArqueroX" + numArqueros;
        Arquero arquero = new Arquero(equipo);
        arquero.setNombre(name);
        misArqueros.add(arquero);
        numArqueros += 1;
      }
    }
  }
  public static int random(int n) {
    return (int) (Math.random() * n);
  }

  public String toString() {
    String str = "Los soldados del ejercito de "+ reino +" son: \n";
    str += "Los arqueros: \n";
    for(Arquero s : misArqueros) {
      str += s + "\n";
    }
    str += "Los espadachines: \n";
    for(Espadachin s : misEspadachines) {
      str += s + "\n";
    }
    str += "Los caballeros: \n";
    for(Caballero s : misCaballero) {
      str += s + "\n";
    }
    return str;
  }
}