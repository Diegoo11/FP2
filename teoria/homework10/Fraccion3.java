package teoria.homework10;

public class Fraccion3 {
  private int numerador;
  private int denominador;

  public Fraccion3() {
    this(1, 1);
  }
  public Fraccion3(int n) {
    this(n, 1);
  }
  public Fraccion3(int n, int m) {
    numerador = n;
    denominador = m;
  }

  public int getNumerador() { return numerador; }
  public int getDenominador() { return denominador; }

  public void setNumerador(int n) { numerador = n; }
  public void setDenominador(int n) { denominador = n; }

  public Fraccion3 sumar(Fraccion3 f) {
    return new Fraccion3(
      f.getDenominador() * numerador + denominador * f.getNumerador(),
      denominador * f.getDenominador()
    );
  }
  public Fraccion3 restar(Fraccion3 f) {
    return new Fraccion3(
      numerador * f.getDenominador() - denominador * f.getNumerador(),
      denominador * f.getDenominador()
    );
  }
  public Fraccion3 multiplicar(Fraccion3 f) {
    return new Fraccion3(
      numerador * f.getNumerador(),
      denominador * f.getDenominador()
    );
  }
  public Fraccion3 dividir(Fraccion3 f) {
    return new Fraccion3(
      numerador * f.getDenominador(),
      denominador * f.getNumerador()
    );
  }
  public Fraccion3 simplificar() {
    int mcd = mcd(denominador, numerador);
    return new Fraccion3(
      numerador / mcd,
      denominador / mcd
    );
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
      if(x == 0) break;
      max = min;
      min = x;
    }
    return min;
  }
}
