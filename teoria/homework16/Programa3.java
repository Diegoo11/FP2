package teoria.homework16;

import java.util.*;

public class Programa3 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    ArrayList<Employee> employees = new ArrayList<Employee>();
    employees.add(new Hourly("Anna", 25));
    employees.add(new Salaried("Simon", 48000));
    employees.add(new Hourly("Donovan", 20));

    while(true) {
      System.out.println("Empleados actuales");
      for(Employee e : employees) {
        System.out.println(e);
      }
      System.out.println("Ingrese: ");
      System.out.println("1. Ingresar un trabajador por horas");
      System.out.println("2. Ingresar un trabajador por salario");
    
      int input = sc.nextInt();
      if(input == 1) {
        System.out.println("Ingrese el nombre y el pago por horas:");
        employees.add(new Hourly(sc.next(), sc.nextDouble()));
      }
      if(input == 2) {
        System.out.println("Ingrese el nombre y el salario:");
        employees.add(new Salaried(sc.next(), sc.nextDouble()));
      }
    }
  }
}
