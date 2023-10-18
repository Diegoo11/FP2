package teoria.homework09;

public class Programa2 {
  public static void main(String[] args) {
    Fraccion f1 = new Fraccion(2, 6);
    Fraccion f2 = new Fraccion(3, 12);

    System.out.println(f1 + " + " + f2);
    System.out.println(Fraccion.sumarClass(f1, f2));
    System.out.println(sumar(f1, f2));
    f1.sumar(f2);
    System.out.println(f1);
    f1.setNumerador(2); f1.setDenominador(6);

    System.out.println(f1 + " - " + f2);
    System.out.println(Fraccion.restarClass(f1, f2));
    System.out.println(restar(f1, f2));
    f1.restar(f2);
    System.out.println(f1);
    f1.setNumerador(2); f1.setDenominador(6);

    System.out.println(f1 + " * " + f2);
    System.out.println(Fraccion.multiplicarClass(f1, f2));
    System.out.println(multiplicar(f1, f2));
    f1.multiplicar(f2);
    System.out.println(f1);
    f1.setNumerador(2); f1.setDenominador(6);

    System.out.println(f1 + " / " + f2);
    System.out.println(Fraccion.dividirClass(f1, f2));
    System.out.println(dividir(f1, f2));
    f1.dividir(f2);
    System.out.println(f1);
    f1.setNumerador(2); f1.setDenominador(6);

    System.out.println(f2 + " Simplificado: ");
    System.out.println(Fraccion.simplificarClass(f2));
    System.out.println(simplificar(f2));
    f2.simplificar();
    System.out.println(f2);

  }

  public static Fraccion sumar(Fraccion f1, Fraccion f2) {
    Fraccion f = new Fraccion();
    f.setDenominador(f1.getDenominador() * f2.getDenominador());
    f.setNumerador(
      f1.getNumerador() * f2.getDenominador()
      + f2.getNumerador() * f1.getDenominador()
    );

    return f;
  }
  public static Fraccion restar(Fraccion f1, Fraccion f2) {
    Fraccion f = new Fraccion();
    f.setDenominador(f1.getDenominador() * f2.getDenominador());
    f.setNumerador(
      f1.getNumerador() * f2.getDenominador()
      - f2.getNumerador() * f1.getDenominador()
    );

    return f;
  }
  public static Fraccion multiplicar(Fraccion f1, Fraccion f2) {
    Fraccion f = new Fraccion();
    f.setDenominador(f1.getDenominador() * f2.getDenominador());
    f.setNumerador(f1.getNumerador() * f2.getNumerador());
    return f;
  }
  public static Fraccion dividir(Fraccion f1, Fraccion f2) {
    Fraccion f = new Fraccion();
    f.setNumerador(f1.getNumerador() * f2.getDenominador());
    f.setDenominador(f1.getDenominador() * f2.getNumerador());
    return f;
  }
  public static Fraccion simplificar(Fraccion f) {
    Fraccion newF = new Fraccion();
    int mcd = mcd(f.getDenominador(), f.getNumerador());
    newF.setNumerador(f.getNumerador() / mcd);
    newF.setDenominador(f.getDenominador() / mcd);
    return newF;
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
