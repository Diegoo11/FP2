import java.util.Scanner;

public class Programa01 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    Soldado[] ejercito = new Soldado[5];
    for(int i = 0; i < ejercito.length; i += 1) {
      ejercito[i] = new Soldado();
      System.out.println("Ingres el nombre del soldado" );
      ejercito[i].setName(sc.next());
      System.out.println("Ingres el nivel del soldado" );
      ejercito[i].setNivel(sc.nextInt());
    }
    
    for(Soldado s : ejercito) {
      System.out.println(s);
    }

  }
}
