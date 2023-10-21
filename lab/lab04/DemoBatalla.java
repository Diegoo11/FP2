package lab.lab04;

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
      // nomb = sc.next();
      nomb = randomName();
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
    // mostrarPorNombre(misNaves);
    // mostrarPorPuntos(misNaves);
    // System.out.println("\nNave con mayor número de puntos: " + mostrarMayorPuntos(misNaves));
    
    // System.out.println("El array de objetos desordenado es: ");
    // Nave[] myTable = hashTable(misNaves);
    // mostrarNaves(myTable);

    //leer un nombre
    //mostrar los datos de la nave con dicho nombre, mensaje de “no encontrado” en caso contrario

    System.out.println("Ingresa el nombre a buscar: ");
    String nombre = sc.next();
    int pos = busquedaLinealNombre(misNaves, nombre);
    System.out.println("NAVE: " + misNaves[pos]);
    ordenarPorPuntosBurbuja(misNaves);
    mostrarNaves(misNaves);
    ordenarPorNombreBurbuja(misNaves);
    mostrarNaves(misNaves);
    //mostrar los datos de la nave con dicho nombre, mensaje de “no encontrado” en caso contrario
    pos = busquedaBinariaNombre(misNaves, nombre);
    System.out.println("NAVE: " + misNaves[pos]);
    ordenarPorPuntosSeleccion(misNaves);
    mostrarNaves(misNaves);
    ordenarPorNombreSeleccion(misNaves);
    mostrarNaves(misNaves);
    ordenarPorPuntosInsercion(misNaves);
    mostrarNaves(misNaves);
    ordenarPorNombreInsercion(misNaves);
    mostrarNaves(misNaves);
  }

  // Método para mostrar todas las naves
  public static void mostrarNaves(Nave[] flota) {
    for(Nave n: flota) {
      System.out.println(n);
    }
    System.out.println("----------------------------------------------");
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

  //Método para buscar la primera nave con un nombre que se pidió por teclado
  public static int busquedaLinealNombre(Nave[] flota, String s){
    for(int i = 0; i < flota.length; i += 1) {
      if(flota[i].getNombre().equals(s)) return i;
    }
    return -1;
  }
  //Método que ordena por número de puntos de menor a mayor
  public static void ordenarPorPuntosBurbuja(Nave[] flota){
    System.out.println("Ordenamiento de puntos por burbuja");
    for(int i = 0; i < flota.length - 1; i += 1) {
      for(int j = 0; j < flota.length - 1 - i; j += 1) {
        if(flota[j].getPuntos() > flota[j + 1].getPuntos()) {
          Nave nave = flota[j + 1];
          flota[j + 1] = flota[j];
          flota[j] = nave;
        }
      }
    }
  }
  //Método que ordena por nombre de A a Z
  public static void ordenarPorNombreBurbuja(Nave[] flota){
    System.out.println("Ordenamiento de nombre por burbuja");
    for(int i = 0; i < flota.length - 1; i += 1) {
      for(int j = 0; j < flota.length - 1 - i; j += 1) {
        if(flota[j].getNombre().charAt(0) > flota[j + 1].getNombre().charAt(0)) {
          Nave nave = flota[j + 1];
          flota[j + 1] = flota[j];
          flota[j] = nave;
        }
      }
    }
  }
  //Método para buscar la primera nave con un nombre que se pidió por teclado
  public static int busquedaBinariaNombre(Nave[] flota, String s){
    int min = 0;
    int max = flota.length - 1;
    while(min <= max) {
      int avg = (min + max) / 2;
      if(flota[avg].getNombre().equals(s)) return avg;
      else if(s.charAt(0) > flota[avg].getNombre().charAt(0)) min = avg + 1;
      else max = avg - 1;
    }
    return -1;
  }
  //Método que ordena por número de puntos de menor a mayor
  public static void ordenarPorPuntosSeleccion(Nave[] flota){
    System.out.println("Ordenamiento de puntos por seleccion");
    for(int i = 0; i < flota.length - 1; i += 1) {
      int min = i;
      for(int j = i; j < flota.length; j += 1) {
        min = flota[min].getPuntos() > flota[j].getPuntos() ? j : min;
      }
      Nave nave = flota[i];
      flota[i] = flota[min];
      flota[min] = nave;
    }
  }
  //Método que ordena por nombre de A a Z
  public static void ordenarPorNombreSeleccion(Nave[] flota){
    System.out.println("Ordenamiento de nombre por seleccion");
    for(int i = 0; i < flota.length - 1; i += 1) {
      int min = i;
      for(int j = i; j < flota.length; j += 1) {
        min = flota[min].getNombre().charAt(0) > flota[j].getNombre().charAt(0) ? j : min;
      }
      Nave nave = flota[i];
      flota[i] = flota[min];
      flota[min] = nave;
    }
  }
  //Método que muestra las naves ordenadas por número de puntos de mayor a menor
  public static void ordenarPorPuntosInsercion(Nave[] flota){
    System.out.println("Ordenamiento de puntos por insercion");
    for(int i = 1; i < flota.length; i += 1) {
      Nave nave = flota[i];
      int j = i - 1;
      while(j >= 0) {
        if(flota[j].getPuntos() > nave.getPuntos()) {
          flota[j + 1] = flota[j];
          flota[j] = nave;
        } else {
          break;
        }
        j -= 1;
      }
    }
  }
  //Método que muestra las naves ordenadas por nombre de Z a A
  public static void ordenarPorNombreInsercion(Nave[] flota){
    System.out.println("Ordenamiento de nombre por insercion");
    for(int i = 1; i < flota.length; i += 1) {
      Nave nave = flota[i];
      int j = i - 1;
      while(j >= 0) {
        if(flota[j].getNombre().charAt(0) > nave.getNombre().charAt(0)) {
          flota[j + 1] = flota[j];
          flota[j] = nave;
        } else {
          break;
        }
        j -= 1;
      }
    }
  }

  public static int random(int n) {
    return (int) (Math.random() * n);
  }
  public static String randomName() {
    return "" + (char) (random(24) + 65) +
                (char) (random(24) + 65) +
                (char) (random(24) + 65) +
                (char) (random(24) + 65) +
                (char) (random(24) + 65) +
                (char) (random(24) + 65) +
                (char) (random(24) + 65) +
                (char) (random(24) + 65) +
                (char) (random(24) + 65);
  }
}
