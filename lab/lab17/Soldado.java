package lab.lab17;

public class Soldado {
  private String nombre;
  private int fila;
  private int nivelAtaque = random(5);
  private int nivelDefensa = random(5);
  private int columna;
  private int nivelVida;
  private int vidaActual;
  private int velocidad;
  private String actitud;
  private boolean vive;
  private String team;

  public final static int MAX = 0;
  private static int numSoldados = 0;
  private static int numTeam1 = 0;
  private static int numTeam2 = 0;

  public Soldado(String t) {
    team = t;
    if(t.equals("*")) numTeam1 += 1;
    else numTeam2 += 1;
    velocidad = 0;
    vive = true;
    actitud = "ataque";
    numSoldados += 1;
  }
  public Soldado(int v, String t) {
    team = t;
    if(t.equals("*")) numTeam1 += 1;
    else numTeam2 += 1;
    velocidad = v;
    vive = true;
    actitud = "ataque";
    numSoldados += 1;
  }
  public Soldado(int v, int nV, String t) {
    team = t;
    if(t.equals("*")) numTeam1 += 1;
    else numTeam2 += 1;
    vive = true;
    velocidad = v;
    nivelVida = nV;
    actitud = "ataque";
    numSoldados += 1;
  }

  public void atacar() {
    actitud = "ofensiva";
  }
  public void defender() {
    actitud = "defensiva";
  }
  public void huir() {
    actitud = "fuga";
    velocidad += 2;
  }

  public void avanzar() {
    velocidad += 1;
  }

  public void serAtacado() {
    vidaActual -= 1;
    if(vidaActual == 0) morir();
  }
  public void morir() { 
    if(team.equals("*")) numTeam1 -= 1;
    else numTeam2 -= 1;
    numSoldados -= 1;
    vive = false;
  }

  public void retroceder() {
    if (velocidad > 0) {
      velocidad = 0;
      actitud = "defensiva";
    } else if (velocidad == 0) {
      velocidad = -1; 
    }
  }

  public String getTeam() { return team; }

  public void setNombre(String n) { nombre = n; }

  public void setFila(int f) { fila = f; }

  public void setColumna(int c) { columna = c; }

  public void setNivelVida(int p) { nivelVida = p; }

  public String getNombre() { return nombre; }

  public int getFila() { return fila; }

  public int getColumna() { return columna; }

  public int getNivelVida() { return nivelVida; }

  public int getNivelAtaque() { return nivelAtaque; }

  public int getNivelDefensa() { return nivelDefensa; }

  public void setNivelAtaque(int n) { nivelAtaque = n; }

  public void setNivelDefensa(int n) { nivelDefensa = n; }

  public boolean isLive() { return vive; }

  public String toString() {
    return "Nombre: " + nombre +
    " | Ubicacion: " + fila + ", " + columna +
    " | nivelVida: " + nivelVida + 
    " | Estado: " + (vive ? "Vivo" : "Muerto") +
    " | Actitud: "+ actitud +
    " | Team: " + team;
  }
  private int random(int n) {
    return (int) (Math.random() * n + 1);
  }
  public Soldado sumar(Soldado s) {
    Soldado newSoldado = new Soldado(s.getTeam());
    newSoldado.setNivelAtaque(this.nivelAtaque + s.nivelAtaque);
    newSoldado.setNivelDefensa(this.nivelDefensa + s.nivelDefensa);
    newSoldado.setNivelVida(this.nivelVida + s.nivelVida);
    return newSoldado;
  }

  public static int getNumSoldados() {
    return numSoldados;
  }
  public static int getNumTeam1() {
    return numTeam1;
  }
  public static int getNumTeam2() {
    return numTeam2;
  }
}
