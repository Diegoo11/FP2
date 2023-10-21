package teoria.homework10;

public class Programa5 {
  public static void main(String[] args) {
    Fraccion2 f1 = new Fraccion2(2, 6);
    Fraccion2 f2 = new Fraccion2(12, 72);
    Fraccion2 f3 = new Fraccion2(5, 45);
    Fraccion2 f4 = new Fraccion2(14, 21);
    Fraccion2 f5 = new Fraccion2(3, 12);
    
    Fraccion2 f;
    f = f1.sumar(f2).sumar(f3).restar(f4).multiplicar(f5).simplificar();
    
    System.out.println("f :" + f);
    System.out.println("f1:" + f1);
  }
}
