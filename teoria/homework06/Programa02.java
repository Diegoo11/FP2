package teoria.homework06;

import java.util.ArrayList;
import java.util.Scanner;

public class Programa02 {
  public static void main(String[] args) {
    ArrayList<Contacto> misContactos = new ArrayList<Contacto>();

    llenarContactos(misContactos);
    System.out.println(misContactos);

    Contacto miAmigo = misContactos.get(busquedaBinariaContacto( misContactos, "Yenaro"));
    System.out.println(miAmigo);

  }
  public static void llenarContactos(ArrayList<Contacto> arr) {
    System.out.println("Ingrese los datos de los contactos: ");
    System.out.println("Para salir ingresar 'q'");
    while(true) {
      Scanner sc = new Scanner(System.in);
      System.out.println("Ingrese nombre: ");
      String input = sc.next();
      if(input.charAt(0) == 'q') break;
      System.out.println("Ingrese edad: ");
      int age = sc.nextInt();
      System.out.println("Ingrese s o c para su estado civil: ");
      char civilStatus = sc.next().charAt(0);
      Contacto c = new Contacto();
      c.setName(input);
      c.setAge(age);
      c.setCivilStatus(civilStatus);
      arr.add(c);
    }
  }
  public static int busquedaBinariaContacto(ArrayList<Contacto> arr, String name) {
    int min = 0;
    int max = arr.size() - 1;
    while(min <= max) {
      int avg = (min + max) / 2;
      if(arr.get(avg).getName().equals(name)) return avg;
      else if(name.charAt(0) > arr.get(avg).getName().charAt(0)) min = avg + 1;
      else max = avg - 1;
    }
    return -1;
  }
  public static int binariSearch(int n, int[] arr) {
    int min = 0;
    int max = arr.length - 1;
    while(min <= max) {
      int avg = (min + max)/2;
      if(n == arr[avg]) return avg;
      else if(n > arr[avg]) min = avg + 1;
      else max = avg - 1;
    }
    return -1;
  }
  public static void sort(ArrayList<Contacto> arr) {
    for(int i = 0; i < arr.size() - 1; i += 1) { 
      for(int j = 0; j < arr.size() - 1 - i; j += 1) {
        if(arr.get(j).getName().charAt(0) > arr.get(j+1).getName().charAt(0)) {
          Contacto c = arr.get(j + 1);
          arr.set(j + 1, arr.get(j));
          arr.set(j, c);
        }
      }
    }
  }
}
