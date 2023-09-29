package teoria.homework06;

import java.util.HashMap;
import java.util.Scanner;

public class Programa04 {
  public static void main(String[] args) {
    HashMap<String, String> cursos = new HashMap<String, String>();
    Scanner sc = new Scanner(System.in);

    while (true) {
      System.out.println("1. Agregar curso");
      System.out.println("2. Consultar curso por código");
      int opcion = sc.nextInt();
      sc.nextLine();

      switch (opcion) {
        case 1:
          System.out.print("Ingrese el nombre del curso: ");
          String nombre = sc.nextLine();
          String codigo = generarCodigo(nombre);
          if(cursos.containsKey(codigo)) {
            cursos.put((codigo+random(1000)), nombre);
          } else {
            cursos.put(codigo, nombre);
          }
          System.out.println("Curso agregado con código: " + codigo);
          break;
        case 2:
          System.out.print("Ingrese el código del curso: ");
          String codigoConsulta = sc.nextLine();
          if (cursos.containsKey(codigoConsulta)) {
            System.out.println("El curso correspondiente es: " + cursos.get(codigoConsulta));
          } else {
            System.out.println("Código no encontrado");
          }
          break;
        default:
          System.out.println("Opción inválida");
      }
    }
  }

  public static String generarCodigo(String nombre) {
    String codigo = nombre.substring(0, 2).toUpperCase();
    return codigo;
  }
  public static int random(int n) {
    return (int) (Math.random() * n + 1);
  }
}
