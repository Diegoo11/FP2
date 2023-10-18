package teoria.homework09;

public class Fraccion {
  private int numerador;
  private int denominador;

  public Fraccion() {
    this(1, 1);
  }
  public Fraccion(int n) {
    this(n, 1);
  }
  public Fraccion(int n, int m) {
    numerador = n;
    denominador = m;
  }

  public int getNumerador() { return numerador; }
  public int getDenominador() { return denominador; }

  public void setNumerador(int n) { numerador = n; }
  public void setDenominador(int n) { denominador = n; }

  public void sumar(Fraccion f) {
    int den = denominador;
    numerador *= f.getDenominador();
    denominador *= f.getDenominador();
    numerador += f.getNumerador() * den;
  }
  public void restar(Fraccion f) {
    int den = denominador;
    numerador *= f.getDenominador();
    denominador *= f.getDenominador();
    numerador -= f.getNumerador() * den;
  }
  public void multiplicar(Fraccion f) {
    numerador *= f.getNumerador();
    denominador *= f.getDenominador();
  }
  public void dividir(Fraccion f) {
    numerador *= f.getDenominador();
    denominador *= f.getNumerador();
  }
  public void simplificar() {
    int mcd = mcd(numerador, denominador);
    numerador /= mcd;
    denominador /= mcd;
  }

  public static Fraccion sumarClass(Fraccion f1, Fraccion f2) {
    Fraccion f = new Fraccion();
    f.setDenominador(f1.getDenominador() * f2.getDenominador());
    f.setNumerador(
      f1.getNumerador() * f2.getDenominador() + f2.getNumerador() * f1.getDenominador()
    );

    return f;
  }
  public static Fraccion restarClass(Fraccion f1, Fraccion f2) {
    Fraccion f = new Fraccion();
    f.setDenominador(f1.getDenominador() * f2.getDenominador());
    f.setNumerador(
      f1.getNumerador() * f2.getDenominador() - f2.getNumerador() * f1.getDenominador()
    );

    return f;
  }
  public static Fraccion multiplicarClass(Fraccion f1, Fraccion f2) {
    Fraccion f = new Fraccion();
    f.setDenominador(f1.getDenominador() * f2.getDenominador());
    f.setNumerador(f1.getNumerador() * f2.getNumerador());
    return f;
  }
  public static Fraccion dividirClass(Fraccion f1, Fraccion f2) {
    Fraccion f = new Fraccion();
    f.setNumerador(f1.getNumerador() * f2.getDenominador());
    f.setDenominador(f1.getDenominador() * f2.getNumerador());
    return f;
  }
  public static Fraccion simplificarClass(Fraccion f) {
    Fraccion newF = new Fraccion();
    int mcd = mcd(f.getDenominador(), f.getNumerador());
    newF.setNumerador(f.getNumerador() / mcd);
    newF.setDenominador(f.getDenominador() / mcd);
    return newF;
  }

  public String toString() {
    return "" + numerador + "/" + denominador;
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
