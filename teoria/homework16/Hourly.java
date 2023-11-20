package teoria.homework16;

public class Hourly extends Employee{
  private double hourlyRate;
  private double hours = 0;

  public Hourly(String n, double rate) {
    super(n);
    hourlyRate = rate;
  }

  public double getPay() {
    return hourlyRate * hours;
  }

  public void addHours(double h) {
    hours += h;
  }
}
