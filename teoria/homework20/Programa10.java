package teoria.homework20;

import java.io.*;
import java.util.Scanner;

public class Programa10 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int[] nums = new int[10];
    try {
      Scanner fileIn = new Scanner(new FileReader("./numeritosAleatorios.txt"));
      leer(fileIn, nums);
      printNums(nums);
      fileIn.close();
    } catch (FileNotFoundException e) {
      System.out.println("Error: " + e.getMessage());
    }
    sc.close();
  }

  public static void leer(Scanner file, int[] nums) {
    for (int i = 0; i < nums.length && file.hasNextLine(); i += 1) {
      nums[i] = file.nextInt();
    }
  }

  public static void printNums(int[] lanzamientos) {
    for (int i = 0; i < lanzamientos.length; i += 1)
      System.out.println( (i + 1) + ". " + lanzamientos[i]);
  }
}