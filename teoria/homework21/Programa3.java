package teoria.homework21;

import java.io.*;

public class Programa3 {
  public static void main(String[] args) {
    ObjectOutputStream fileOut;
    ObjectInputStream fileIn;

    Alumno alumno = new Alumno("Juan", 16, 20220556);

    try {
      fileOut = new ObjectOutputStream(new FileOutputStream("objetos.dat"));

      fileOut.writeObject(alumno);

      fileIn = new ObjectInputStream(new FileInputStream("objetos.dat"));

      Alumno alumno2 = (Alumno) fileIn.readObject();
      System.out.println(alumno2);

      fileIn.close();
      fileOut.close();
      
    } catch (Exception e) {
      System.out.println(e);
    }
  }
}
