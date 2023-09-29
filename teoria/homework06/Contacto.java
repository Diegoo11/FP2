package teoria.homework06;

public class Contacto {
  private String name;
  private int age;
  private char civilStatus;
  public void setName(String str) {
    name = str;
  }
  public String getName() {
    return name;
  }
  public void setAge(int n) {
    age = n;
  }
  public int getAge() {
    return age;
  }
  public void setCivilStatus(char n) {
    civilStatus = n;
  }
  public char getCivilStatus() {
    return civilStatus;
  }
  public String toString() {
    return "Nombre: " + name + " | Edad: " + age + " | Estado civil: " + civilStatus;
  }
}
