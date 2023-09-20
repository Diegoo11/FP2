public class Programa1 {
  public static void main(String[] args) {
    int[] frecuencias = new int[4];
    
    for(int i = 0; i < 1000000; i += 1) {
      int n = random() + random() + random();
      frecuencias[n] += 1;
    }

    printFrecuencias(frecuencias);
  }
  public static int random() {
    return Math.random() > 0.5 ? 1 : 0;
  }
  public static void printFrecuencias(int[] arr) {
    for(int i = 0; i < arr.length; i += 1) {
      System.out.println(i + "\t" + arr[i] + bar(arr[i]));
    }
  }
  public static String bar(int n) {
    String str = "";
    for(int i = 0; i < n/10000; i += 1) {
      str += "*";
    }
    return str;
  }
}
