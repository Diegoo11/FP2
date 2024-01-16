package lab.lab23;

abstract class Soldado {
  public final static int MAX = 0;


  abstract void atacar();

  abstract void defender();

  abstract void serAtacado();

  abstract void morir();

  abstract String getTeam();

  abstract void setNombre(String n);

  abstract void setFila(int f);

  abstract void setColumna(int c);

  abstract void setNivelVida(int p);

  abstract String getNombre();

  abstract int getFila();

  abstract int getColumna();

  abstract int getNivelVida();

  abstract int getNivelAtaque();

  abstract int getNivelDefensa();
  
  abstract void setNivelAtaque(int n);

  abstract void setNivelDefensa(int n);

  abstract boolean isLive();

}

