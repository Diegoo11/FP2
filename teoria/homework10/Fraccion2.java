package teoria.homework10;

public class Fraccion2 {
  private int numerador;
  private int denominador;

  public Fraccion2() {
    this(1, 1);
  }
  public Fraccion2(int n) {
    this(n, 1);
  }
  public Fraccion2(int n, int m) {
    numerador = n;
    denominador = m;
  }

  public int getNumerador() { return numerador; }
  public int getDenominador() { return denominador; }

  public void setNumerador(int n) { numerador = n; }
  public void setDenominador(int n) { denominador = n; }

  public Fraccion2 sumar(Fraccion2 f) {
    numerador = f.getDenominador() * numerador + denominador * f.getNumerador();
    denominador = denominador * f.getDenominador();
    return this;
  }
  public Fraccion2 restar(Fraccion2 f) {
    numerador = numerador * f.getDenominador() - denominador * f.getNumerador();
    denominador = denominador * f.getDenominador();
    return this;
  }
  public Fraccion2 multiplicar(Fraccion2 f) {
    numerador = numerador * f.getNumerador();
    denominador = denominador * f.getDenominador();
    return this;
  }
  public Fraccion2 dividir(Fraccion2 f) {
    numerador = numerador * f.getDenominador();
    denominador = denominador * f.getNumerador();
    return this;
  }
  public Fraccion2 simplificar() {
    int mcd = mcd(denominador, numerador);
    numerador = numerador / mcd;
    denominador = denominador / mcd;
    return this;
  }

  public String toString() {
    return "" + numerador + "/" + denominador + ", " + (numerador/(denominador * 1.0));
  }

  public static int mcd(int n, int m) {
    int max = n > m ? n: m;
    int min = n > m ? m: n;
    int x;
    while(true) {
      x = max % min;
      if(x == 0) {
        break;
      }
      max = min;
      min = x;
    }
    return min;
  }
}
