package teoria.homework17;

import java.util.ArrayList;

public class Programa1 {
  public static void main(String[] args) {
    ArrayList<Estudiante> estudiantes = new ArrayList<Estudiante>();

    for(int i = 0; i < 30; i += 1) {
      int num = (int) random(30);
      double[] arr = {random(20), random(20), random(20)};
      Estudiante estudiante;
      if(i < num) {
        estudiante = new Pregrado();
      } else {
        estudiante = new Postgrado();
      }
      estudiante.setNotas(arr);
      estudiantes.add(estudiante);
    }

    int pre = 0;
    int post = 0;
    for(Estudiante e : estudiantes) {
      if(e instanceof Pregrado) pre += 1; else post += 1; 
      System.out.println(e.getNotaFinal());
    }
    System.out.println("Numero de estudiantes de Pregrado: " + pre);
    System.out.println("Numero de estudiantes de Postgrado: " + post);
  }

  public static double random(int n) {
    return (int) (Math.random() * n + 1);
  }
}
