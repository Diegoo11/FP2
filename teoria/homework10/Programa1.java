package teoria.homework10;

public class Programa1 {
  public static void main(String[] args) {
    Car johnCar = new Car();
    Car stacyCar;
    
    johnCar.setMake("Honda");
    johnCar.setYear(2003);
    johnCar.setColor("silver");
    stacyCar = johnCar.makeCopy();
    stacyCar.setColor("peach");

    System.out.println("John car:" + johnCar);
    System.out.println("Stacy car:" + stacyCar);
  }
}
