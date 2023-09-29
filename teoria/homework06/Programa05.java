package teoria.homework06;
import java.util.*;

public class Programa05 {
  public static void main(String[] args) {
    HashMap<String, String> cursos = new HashMap<String, String>();
    Scanner sc = new Scanner(System.in);

    while (true) {
      System.out.println("1. Agregar curso");
      System.out.println("2. Consultar curso por codigo");
      System.out.println("3. Consultar todos los codigos junto a su nombre");
      int opcion = sc.nextInt();
      sc.nextLine();
      switch (opcion) {
        case 1:
          System.out.print("Ingrese el nombre del curso: ");
          String nombre = sc.nextLine();
          String codigo = generarCodigo(nombre);
          if (cursos.containsKey(codigo)) {
            cursos.put((codigo + random(1000)), nombre);
          } else {
            cursos.put(codigo, nombre);
          }
          System.out.println("Curso agregado con codigo: " + codigo);
          break;
        case 2:
          System.out.print("Ingrese el código del curso: ");
          String codigoConsulta = sc.nextLine();
          if (cursos.containsKey(codigoConsulta)) {
            System.out.println("El curso correspondiente es: " + cursos.get(codigoConsulta));
          } else {
            System.out.println("Codigo no encontrado");
          }
          break;
        case 3:
          System.out.println("Codigos y Nombres de Cursos:");
          Iterator<Map.Entry<String, String>> iterator = cursos.entrySet().iterator();
          while (iterator.hasNext()) {
            Map.Entry<String, String> entry = iterator.next();
            System.out.println("Codigo: " + entry.getKey() + " Nombre: " + entry.getValue());
          }
          break;
        default:
          System.out.println("Opcion invalida");
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
