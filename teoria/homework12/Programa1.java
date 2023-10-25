package teoria.homework12;

import java.util.ArrayList;
import java.util.Scanner;

public class Programa1 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    Gerente gerente = new Gerente("Mathias", "Zegarra", 34);
    Vendedor vendedor1 = new Vendedor("Mariel", "Jara", 32);
    Vendedor vendedor2 = new Vendedor("Jhosepo", "Mamani", 32);

    ArrayList<Vendedor> nuevosVendedores = new ArrayList<Vendedor>();
    
    Concesionario miEmpresa = new Concesionario("Mi empresa de autos", gerente);

    miEmpresa.addVendedor(vendedor1);
    miEmpresa.addVendedor(vendedor2);

    miEmpresa.addAuto(new Auto("toyota", "negro", 2000));
    miEmpresa.addAuto(new Auto("audi", "rojo", 2000));
    
    while(true) {
      printInfo();
      int input = sc.nextInt();
      if(input == 1) miEmpresa.printInfo();
      if(input == 2) {
        System.out.println("Nombre: ");
        String nombre = sc.next();
        System.out.println("Apellido: ");
        String apellido = sc.next();
        System.out.println("Edad: ");
        int edad = sc.nextInt();
        Vendedor v = new Vendedor(nombre, apellido, edad);
        nuevosVendedores.add(v);
        miEmpresa.addVendedor(v);
      }
      if(input == 3) {
        System.out.println("Marca: ");
        String marca = sc.next();
        System.out.println("Color:");
        String color = sc.next();
        System.out.println("Year:");
        int year = sc.nextInt();
        miEmpresa.addAuto(new Auto(marca, color, year));
      }
    }
  }
  public static void printInfo() {
    System.out.println("Eliga una opcion: ");
    System.out.println("1. Mostrar informacion\n2. Agregar un empleado\n3. Agregar un auto");
    System.out.println("4. Salir");
  }

}
