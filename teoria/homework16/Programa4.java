package teoria.homework16;

import java.util.ArrayList;

public class Programa4 {
  public static void main(String[] args) {
    ArrayList<Employee> employees = new ArrayList<Employee>();
    employees.add(new Hourly("Anna", 25));
    employees.add(new Salaried("Simon", 48000));
    employees.add(new Hourly("Donovan", 20));

    for(int i = 1; i <= 30; i += 1) {
      for(Employee e : employees) {
        if(e instanceof Hourly) {
          ((Hourly) e).addHours(8);
        }
        if((i-4)%7 == 0 && e instanceof Hourly) {
          System.out.println(i + " " + e);
          
        }
        if(i%15 == 0 && e instanceof Salaried) {
          System.out.println(i + " " + e);
        }
      }
    }
  }
}
