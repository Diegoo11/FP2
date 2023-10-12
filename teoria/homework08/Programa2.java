package teoria.homework08;

public class Programa2 {
  public static void main(String[] args) {
    Contacto c1 = new Contacto();
    c1.setNombre("Sofia");
    c1.setEdad(18);
    c1.setEstadoCivil("Casada");
    System.out.println(c1);
    
    Contacto c2 = new Contacto();
    c2.setNombre("Lucia");
    c2.setEdad(25);
    c2.setEstadoCivil("Soltera");
    System.out.println(c2);

    Comentario com1;
    com1 = new Comentario( );
    com1.setComentario("En el cine");
    com1.setEstado("publico");
    System.out.println(c1.getNombre() + " puso un comentario");
    System.out.println(com1.getComentario() ); 
    System.out.println(com1);
  }
}
