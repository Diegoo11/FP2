import java.util.*;

public class DemoBatalla {
  public static void main(String[] args) {
    Nave[] misNaves = new Nave[10];
    Scanner sc = new Scanner(System.in);
    String nomb;
    int fil, punt, col;
    boolean est;

    for (int i = 0; i < misNaves.length; i++) {
      System.out.println("Nave " + (i + 1));
      System.out.print("Nombre: ");
      nomb = sc.next();
      // nomb = "" + (char) ((int) (Math.random() * 120));
      System.out.println("Fila ");
      //fil = sc.nextInt();
      fil = (int) (Math.random() * 120);
      System.out.print("Columna: ");
      // col = sc.next();
      col = (int) (Math.random() * 120);
      System.out.print("Estado: ");
      // est = sc.nextBoolean();
      est  = Math.random() >= 0.5;
      System.out.print("Puntos: ");
      // punt = sc.nextInt();
      punt = (int) (Math.random() * 120);

      misNaves[i] = new Nave(); // Se crea un objeto Nave y se asigna su referencia a misNaves

      misNaves[i].setNombre(nomb);
      misNaves[i].setFila(fil);
      misNaves[i].setColumna(col);
      misNaves[i].setEstado(est);
      misNaves[i].setPuntos(punt);
    }

    System.out.println("\nNaves creadas:");
    mostrarNaves(misNaves);
    mostrarPorNombre(misNaves);
    mostrarPorPuntos(misNaves);
    System.out.println("\nNave con mayor número de puntos: " + mostrarMayorPuntos(misNaves));
    System.out.println("El array de objetos desordenado es: ");

    Nave[] myTable = hashTable(misNaves);
    mostrarNaves(myTable);
  }

  // Método para mostrar todas las naves
  public static void mostrarNaves(Nave[] flota) {
    for(Nave n: flota) {
      System.out.println(n);
    }
  }

  
  public static void mostrarPorNombre(Nave[] flota) {
    Scanner sc =  new Scanner(System.in);
    System.out.println("Ingrese el nombre de la nave a buscar: ");
    String name = sc.next();
    for(Nave n : flota) {
      if(name.equals(n.getNombre())) System.out.println(n);
    }
  }

  
  public static void mostrarPorPuntos(Nave[] flota) {
    Scanner sc =  new Scanner(System.in);
    System.out.println("Ingrese el numero de puntos de la nave a buscar: ");
    int points = sc.nextInt();
    for(Nave n : flota) {
      if(points <= n.getPuntos()) System.out.println(n);
    }
  }

  public static Nave mostrarMayorPuntos(Nave[] flota) {
    int index = 0;
    for(int i = 0; i < flota.length; i += 1) {
      if(flota[index].getPuntos() < flota[i].getPuntos()) index = i;
    }
    return flota[index];
  }

  public static Nave[] hashTable(Nave[] flota) {
    Nave[] arr = new Nave[flota.length];
    for(int i = 0; i < arr.length; i += 1) {
      arr[i] = flota[i];
    }
    for(int i = 0; i < arr.length - 1; i += 1) {
      for(int j = 0; j < arr.length - 1; j += 1) {
        if(Math.random() >= 0.5){
          Nave n = arr[i];
          arr[i] = arr[i + 1];
          arr[i + 1] = n;
        }
      }
    }
    return arr;
  }
}
