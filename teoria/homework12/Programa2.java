package teoria.homework12;

public class Programa2 {
  public static void main(String[] args) {
    Direccion d1 = new Direccion("Jr. Juan José Anguiano", "Lima", "Lima", "Peru");
    
    Estudiante e1 = new Estudiante(1, "joel", d1);
    Estudiante e2 = new Estudiante(2, "Pablo", d1);
  
    Estudiante e3 = new Estudiante(3, "Diegoo", new Direccion(
      "Cl. Alex Vélez",
      "Arequipa", "Arequipa",
      "Peru")
    );

    System.out.println(e1);
    System.out.println(e2);
    System.out.println(e3);
  }
}
