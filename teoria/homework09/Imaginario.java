package teoria.homework09;

public class Imaginario {
  private int numNatural;
  private int numImaginario;

  public int getNumNatural() { return numNatural; }
  public int getNumImaginario() { return numImaginario; }

  public void setNumNatural(int n) { numNatural = n; }
  public void setNumImaginario(int n) { numImaginario = n; }
  
  public Imaginario() {
    this(1, 1);
  }
  public Imaginario(int n) {
    this(n, 1);
  }
  public Imaginario(int n, int i) {
    numNatural = n;
    numImaginario = i;
  }

  public Imaginario sumar(Imaginario i) {
    return new Imaginario(
      numNatural + i.getNumNatural(),
      numImaginario + i.getNumImaginario()
    );
  }
  public Imaginario restar(Imaginario i) {
    return new Imaginario(
      numNatural - i.getNumNatural(),
      numImaginario - i.getNumImaginario()
    );
  }
  public Imaginario multiplicar(Imaginario i) {
    return new Imaginario(
      numNatural * i.getNumNatural() - numImaginario * i.getNumImaginario(),
      numNatural * i.getNumImaginario() + i.getNumNatural() * numImaginario
    );
  }
  public double modulo() {
    return Math.sqrt(Math.pow(numNatural, 2) + Math.pow(numImaginario, 2));
  }
  public Imaginario conjugado() {
    return new Imaginario(
      numNatural,
      numImaginario * -1
    );
  }

  public static Imaginario sumarClass(Imaginario i1, Imaginario i2) {
    return new Imaginario(
      i1.getNumNatural() + i2.getNumNatural(),
      i1.getNumImaginario() + i2.getNumImaginario()
    );
  }
  public static Imaginario restarClass(Imaginario i1, Imaginario i2) {
    return new Imaginario(
      i1.getNumNatural() - i2.getNumNatural(),
      i1.getNumImaginario() - i2.getNumImaginario()
    );
  }
  public static Imaginario multiplicarClass(Imaginario i1, Imaginario i2) {
    return new Imaginario(
      i1.getNumNatural() * i2.getNumNatural() - i1.getNumImaginario() * i2.getNumImaginario(),
      i1.getNumNatural() * i2.getNumImaginario() + i2.getNumNatural() * i1.getNumImaginario()
    );
  }
  public static double moduloClass(Imaginario i) {
    return Math.sqrt(Math.pow(i.getNumNatural(), 2) + Math.pow(i.getNumImaginario(), 2));
  }
  public static Imaginario conjugadoClass(Imaginario i) {
    return new Imaginario(
      i.getNumNatural(),
      i.getNumImaginario() * -1
    );
  }

  public String toString() {
    return "(" + numNatural + ", " + numImaginario + "); "
    + numNatural + "+" + numImaginario + "i";
  }
}