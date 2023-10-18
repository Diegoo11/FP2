package teoria.homework10;

public class Programa3 {
  public static void main(String[] args) {
    Persona persona1 = new Persona();
    Persona persona2 = new Persona();
    persona1.setNombre("Jonathan");
    persona2.setNombre("Benji");
    System.out.println(persona1.getNombre()
    + ", " + persona2.getNombre());
    persona1.swapPerson(persona2);
    System.out.println(persona1.getNombre()
    + ", " + persona2.getNombre());
  }
}
