package teoria.homework17;

public class Pregrado extends Estudiante {
  public int getNotaFinal() {
    double suma = 0;
    for(Double n : getNotas()) suma += n;
    return  (int) (suma/getNotas().length);
  }
}
