package teoria.homework17;

public class Postgrado extends Estudiante {
  public int getNotaFinal() {
    double suma = getNotas()[0] * 25 + getNotas()[1] * 35 + getNotas()[2] * 40;
    return  (int) (suma/100);
  }
}
