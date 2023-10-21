package teoria.homework10;

public class Programa6 {
  public static void main(String[] args) {
    Fraccion3 f1 = new Fraccion3(2, 6);
    Fraccion3 f2 = new Fraccion3(12, 72);
    Fraccion3 f3 = new Fraccion3(5, 45);
    Fraccion3 f4 = new Fraccion3(14, 21);
    Fraccion3 f5 = new Fraccion3(3, 12);
    
    Fraccion3 f;
    f = f1.sumar(f2).sumar(f3).restar(f4).multiplicar(f5).simplificar();
    
    System.out.println("f :" + f);
    System.out.println("f1:" + f1);
  }
}
