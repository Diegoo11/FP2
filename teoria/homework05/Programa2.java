package teoria.homework05;

import java.util.Scanner;

public class Programa2 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    Alumno[][] alumnos = new Alumno[5][100];
    int[] count = new int[5];

    randomFill(alumnos, count);

    while(true) {
      System.out.print("Ingresa el numero de la operacion: ");
      int op = sc.nextInt();
      switch (op) {
        case 1:   ingresarDatos(alumnos, count); break;
        case 2:   consultarYear(alumnos); break;
        case 3:   consultarTodos(alumnos); break;
        case 4:   promedioPonderadoYear(alumnos); break;
        case 5:   promedioPonderadoTodos(alumnos); break;
        case 6:   mejorPromedioYear(alumnos); break;
        case 7:   menorPromedioYear(alumnos); break;
        case 8:   mejorPromedioTodos(alumnos); break;
        case 9:   menorPromedioTodos(alumnos); break;
        case 10:  rankearYear(alumnos); break;
        case 11:  rankearTodos(alumnos); break;
      }
      if(op == 12) break;
    }
  }
  public static void ingresarDatos(Alumno[][] arr, int[] count) {
    Scanner sc = new Scanner(System.in);
    System.out.print("Ingrese el nombre: ");
    String name = sc.next();
    System.out.print("Ingrese la edad: ");
    int age = sc.nextInt();
    System.out.print("Ingresa el promedio: ");
    double avg = sc.nextDouble();
    System.out.print("Ingresa el año de estudio: ");
    int year = sc.nextInt();

    arr[year - 1][count[year - 1]] = new Alumno();
    arr[year - 1][count[year - 1]].setName(name);
    arr[year - 1][count[year - 1]].setAge(age);
    arr[year - 1][count[year - 1]].setAverage(avg);

    count[year] += 1;
  }
  public static void consultarYear(Alumno[][] arr) {
    Scanner sc =  new Scanner(System.in);
    System.out.print("Ingresa el año: ");
    int n = sc.nextInt();
    for(int i = 0; i < arr[n-1].length; i += 1) {
      Alumno alumno = arr[n-1][i];
      if(alumno == null) break;
      System.out.println("Nombre: " + alumno.getName());
      System.out.println("Edad: " + alumno.getAge());
      System.out.println("Promedio: " + alumno.getAverage());
    }
  }
  public static void consultarTodos(Alumno[][] arr) {
    for(int i = 0; i < arr.length; i += 1) {
      System.out.println("Alumnos del año: " + (i + 1));
      for(int j = 0; j < arr[i].length; j += 1) {
        Alumno alumno = arr[i][j];
        if(alumno == null) break;
        System.out.println("Nombre: " + alumno.getName());
        System.out.println("Edad: " + alumno.getAge());
        System.out.println("Promedio: " + alumno.getAverage());
      }
    }
  }
  public static void promedioPonderadoYear(Alumno[][] arr) {
    Scanner sc =  new Scanner(System.in);
    System.out.print("Ingresa el año: ");
    int n = sc.nextInt();
    double count = 0;
    int sum = 0;
    for(int i = 0; i < arr[n-1].length; i += 1) {
      if(arr[n-1][i] == null) break;
      sum += arr[n-1][i].getAverage();
      count += 1;
    }
    System.out.println("El promdeio ponderado del año " + (n) +
    " es " + (sum/count));
  }
  public static void promedioPonderadoTodos(Alumno[][] arr) {
    double count = 0;
    int sum = 0;
    for(int i = 0; i < arr.length; i += 1) {
      for(int j = 0; j < arr.length; j += 1) {
        if(arr[i][j] == null) break;
        sum += arr[i][j].getAverage();
        count += 1;
      }
    }
    System.out.println("El promdeio ponderado de todos es " + (sum/count));
  }
  public static void mejorPromedioYear(Alumno[][] arr) {
    Scanner sc = new Scanner(System.in);
    System.out.print("Ingresa el año: ");
    int n = sc.nextInt() -1;
    int index = 0;
    for(int i = 0; i < arr[n].length; i += 1) {
      if(arr[n][i] == null) break;
      if(arr[n][index].getAverage() < arr[n][i].getAverage()) index = i;
    }
    System.out.println("El mejor promedio es de: " + arr[n][index].getName()
    + "con un promedio de: " + arr[n][index].getAverage());
  }
  public static void menorPromedioYear(Alumno[][] arr) {
    Scanner sc = new Scanner(System.in);
    System.out.print("Ingresa el año: ");
    int n = sc.nextInt() -1;
    int index = 0;
    for(int i = 0; i < arr[n].length; i += 1) {
      if(arr[n][i] == null) break;
      if(arr[n][index].getAverage() > arr[n][i].getAverage()) index = i;
    }
    System.out.println("El menor promedio es de: " + arr[n][index].getName()
    + " con un promedio de: " + arr[n][index].getAverage());
  }
  public static void mejorPromedioTodos(Alumno[][] arr) {
    int indexI = 0;
    int indexJ = 0;
    for(int i = 0; i < arr.length; i += 1) {
      for(int j = 0; j < arr[i].length; j += 1) {
        if(arr[indexI][indexJ].getAverage() < arr[i][j].getAverage()){
          indexI = i;
          indexJ = j;
        }
      }
    }
    System.out.println("El mejor promedio es de: " + arr[indexI][indexJ].getName()
    + " con un promedio de: " + arr[indexI][indexJ].getAverage());
  }
  public static void menorPromedioTodos(Alumno[][] arr) {
    int indexI = 0;
    int indexJ = 0;
    for(int i = 0; i < arr.length; i += 1) {
      for(int j = 0; j < arr[i].length; j += 1) {
        if(arr[indexI][indexJ].getAverage() > arr[i][j].getAverage()){
          indexI = i;
          indexJ = j;
        }
      }
    }
    System.out.println("El menor promedio es de: " + arr[indexI][indexJ].getName()
    + "con un promedio de: " + arr[indexI][indexJ].getAverage());
  }
  public static void rankearYear(Alumno[][] arr) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt() - 1;

    for(int i = 0; i < arr[n].length - 1; i += 1) { 
      for(int j = 0; j < arr[n].length - 1 - i; j += 1) {
        if(arr[n][j + 1] == null) continue;
        if(arr[n][j].getAverage() < arr[n][j + 1].getAverage()) {
          Alumno num = arr[n][j + 1];
          arr[n][j + 1] = arr[n][j];
          arr[n][j] = num;
        }
      }
    }

    for(int i = 0; i < arr[n].length; i += 1) {
      Alumno alumno = arr[n][i];
      if(alumno == null) break;
      System.out.println((1 + i) + ". Nombre: " + alumno.getName()
      + " Edad: " + alumno.getAge() + " Promedio: " + alumno.getAverage());
    }
    
  }
  public static void rankearTodos(Alumno[][] arr) {
    Alumno[] newArr = new Alumno[500];
    for(int i = 0; i < arr.length; i += 1) {
      for(int j = 0; j < arr[i].length; j += 1) {
        if(arr[i][j] == null) continue;
        newArr[i*arr.length + j] = arr[i][j];
      }
    }

    for(int i = 0; i < newArr.length - 1; i += 1) { 
      for(int j = 0; j < newArr.length - 1 - i; j += 1) {
        if(newArr[j].getAverage() > newArr[j + 1].getAverage()) {
          Alumno num = newArr[j + 1];
          newArr[j + 1] = newArr[j];
          newArr[j] = num;
        }
      }
    }

    for(int i = 0; i < newArr.length; i += 1) {
      Alumno alumno = newArr[i];
      System.out.println((1 + i) + ". Nombre: " + alumno.getName()
      + " Edad: " + alumno.getAge() + " Promedio: " + alumno.getAverage());
    }
  }
  public static void randomFill(Alumno[][] arr, int[] count) {
    for(int i = 0; i < arr.length; i += 1) {
      int n = random(60);
      for(int j = 0; j < n; j += 1) {
        Scanner sc = new Scanner(System.in);
        String name = randomName();
        int age = random(40);
        double avg = random(200) / 10.0;
        int year = i +1;

        arr[year - 1][count[year - 1]] = new Alumno();
        arr[year - 1][count[year - 1]].setName(name);
        arr[year - 1][count[year - 1]].setAge(age);
        arr[year - 1][count[year - 1]].setAverage(avg);

        count[year - 1] += 1;
      }
    }
  }
  public static int random(int n) {
    return (int) (Math.random() * n + 1);
  }
  public static String randomName() {
    return "" + (char) (random(120)) + (char) (random(120)) + (char) (random(120));
  }
}
