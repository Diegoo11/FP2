package teoria.homework10;

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

  public Fraccion sumar(Fraccion f) {
    return new Fraccion(
      f.getDenominador() * numerador + denominador * f.getNumerador(),
      denominador * f.getDenominador()
    );
  }
  public Fraccion restar(Fraccion f) {
    return new Fraccion(
      numerador * f.getDenominador() - denominador * f.getNumerador(),
      denominador * f.getDenominador()
    );
  }
  public Fraccion multiplicar(Fraccion f) {
    return new Fraccion(
      numerador * f.getNumerador(),
      denominador * f.getDenominador()
    );
  }
  public Fraccion dividir(Fraccion f) {
    return new Fraccion(
      numerador * f.getDenominador(),
      denominador * f.getNumerador()
    );
  }
  public Fraccion simplificar() {
    int mcd = mcd(denominador, numerador);
    return new Fraccion(
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
      if(x == 0) {
        break;
      }
      max = min;
      min = x;
    }
    return min;
  }
}
