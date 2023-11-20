package teoria.homework16;

public class Programa2 {
  public static void main(String[] args) {
    Employee[] employees = new Employee[100];
    employees[0] = new Hourly("Anna", 25);
    employees[1] = new Salaried("Simon", 48000);
    employees[2] = new Hourly("Donovan", 20);

    for(int i = 0; i < employees.length && employees[i] != null; i += 1) {
      if(employees[i] instanceof Hourly) {
        Hourly hourly = (Hourly) employees[i];
        hourly.addHours(160);
      }
      System.out.println(employees[i]);;
    }
  }
}
