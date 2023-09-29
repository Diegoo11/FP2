package teoria.homework06;
import java.util.*;

public class Programa03 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    ArrayList<ArrayList<Alumno>> alumnos = new ArrayList<ArrayList<Alumno>>();
    for(int i = 0; i < 5; i += 1) alumnos.add(new ArrayList<Alumno>());

    randomFill(alumnos);

    while(true) {
      System.out.print("Ingresa el numero de la operacion: ");
      int op = sc.nextInt();
      switch (op) {
        case 1:   ingresarDatos(alumnos); break;
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
  public static void ingresarDatos(ArrayList<ArrayList<Alumno>> arr) {
    Scanner sc = new Scanner(System.in);
    System.out.print("Ingrese el nombre: ");
    String name = sc.next();
    System.out.print("Ingrese la edad: ");
    int age = sc.nextInt();
    System.out.print("Ingresa el promedio: ");
    double avg = sc.nextDouble();
    System.out.print("Ingresa el año de estudio: ");
    int year = sc.nextInt();

    Alumno alumno = new Alumno();
    alumno.setName(name);
    alumno.setAge(age);
    alumno.setAverage(avg);
    arr.get(year-1).add(alumno);
  }
  public static void consultarYear(ArrayList<ArrayList<Alumno>> arr) {
    Scanner sc =  new Scanner(System.in);
    System.out.print("Ingresa el año: ");
    int n = sc.nextInt();
    for(int i = 0; i < arr.get(n - 1).size(); i += 1) {
      Alumno alumno = arr.get(n-1).get(i);
      System.out.println("Nombre: " + alumno.getName());
      System.out.println("Edad: " + alumno.getAge());
      System.out.println("Promedio: " + alumno.getAverage());
    }
  }
  public static void consultarTodos(ArrayList<ArrayList<Alumno>> arr) {
    for(int i = 0; i < arr.size(); i += 1) {
      System.out.println("Alumnos del año: " + (i + 1));
      for(int j = 0; j < arr.get(i).size(); j += 1) {
        Alumno alumno = arr.get(i).get(j);
        System.out.println("Nombre: " + alumno.getName());
        System.out.println("Edad: " + alumno.getAge());
        System.out.println("Promedio: " + alumno.getAverage());
      }
    }
  }
  public static void promedioPonderadoYear(ArrayList<ArrayList<Alumno>> arr) {
    Scanner sc =  new Scanner(System.in);
    System.out.print("Ingresa el año: ");
    int n = sc.nextInt();
    double count = 0;
    int sum = 0;
    for(int i = 0; i < arr.get(n-1).size(); i += 1) {
      sum += arr.get(n-1).get(i).getAverage();
      count += 1;
    }
    System.out.println("El promdeio ponderado del año " + (n) +
    " es " + (sum/count));
  }
  public static void promedioPonderadoTodos(ArrayList<ArrayList<Alumno>> arr) {
    double count = 0;
    int sum = 0;
    for(int i = 0; i < arr.size(); i += 1) {
      for(int j = 0; j < arr.get(i).size(); j += 1) {
        sum += arr.get(i).get(j).getAverage();
        count += 1;
      }
    }
    System.out.println("El promdeio ponderado de todos es " + (sum/count));
  }
  public static void mejorPromedioYear(ArrayList<ArrayList<Alumno>> arr) {
    Scanner sc = new Scanner(System.in);
    System.out.print("Ingresa el año: ");
    int n = sc.nextInt() -1;
    int index = 0;
    for(int i = 0; i < arr.get(n).size(); i += 1) {
      if(arr.get(n).get(index).getAverage() < arr.get(n).get(i).getAverage()) index = i;
    }
    System.out.println("El mejor promedio es de: " + arr.get(n).get(index).getName()
    + "con un promedio de: " + arr.get(n).get(index).getAverage());
  }
  public static void menorPromedioYear(ArrayList<ArrayList<Alumno>> arr) {
    Scanner sc = new Scanner(System.in);
    System.out.print("Ingresa el año: ");
    int n = sc.nextInt() -1;
    int index = 0;
    for(int i = 0; i < arr.get(n).size(); i += 1) {
      if(arr.get(n).get(index).getAverage() > arr.get(n).get(i).getAverage()) index = i;
    }
    System.out.println("El menor promedio es de: " + arr.get(n).get(index).getName()
    + " con un promedio de: " + arr.get(n).get(index).getAverage());
  }
  public static void mejorPromedioTodos(ArrayList<ArrayList<Alumno>> arr) {
    int indexI = 0;
    int indexJ = 0;
    for(int i = 0; i < arr.size(); i += 1) {
      for(int j = 0; j < arr.get(i).size(); j += 1) {
        if(arr.get(indexI).get(indexJ).getAverage() < arr.get(i).get(j).getAverage()){
          indexI = i;
          indexJ = j;
        }
      }
    }
    System.out.println("El mejor promedio es de: " + arr.get(indexI).get(indexJ).getName()
    + " con un promedio de: " + arr.get(indexI).get(indexJ).getAverage());
  }
  public static void menorPromedioTodos(ArrayList<ArrayList<Alumno>> arr) {
    int indexI = 0;
    int indexJ = 0;
    for(int i = 0; i < arr.size(); i += 1) {
      for(int j = 0; j < arr.get(i).size(); j += 1) {
        if(arr.get(indexI).get(indexJ).getAverage() > arr.get(i).get(j).getAverage()){
          indexI = i;
          indexJ = j;
        }
      }
    }
    System.out.println("El menor promedio es de: " + arr.get(indexI).get(indexJ).getName()
    + "con un promedio de: " + arr.get(indexI).get(indexJ).getAverage());
  }
  public static void rankearYear(ArrayList<ArrayList<Alumno>> arr) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt() - 1;

    for(int i = 0; i < arr.get(n).size() - 1; i += 1) { 
      for(int j = 0; j < arr.get(n).size() - 1 - i; j += 1) {
        if(arr.get(n).get(j).getAverage() < arr.get(n).get(j + 1).getAverage()) {
          Alumno alumno = arr.get(n).get(j + 1);
          arr.get(n).set(j+1, arr.get(n).get(j));
          arr.get(n).set(j, alumno);
        }
      }
    }

    for(int i = 0; i < arr.get(n).size(); i += 1) {
      Alumno alumno = arr.get(n).get(i);
      System.out.println((1 + i) + ". Nombre: " + alumno.getName()
      + " Edad: " + alumno.getAge() + " Promedio: " + alumno.getAverage());
    }
    
  }
  public static void rankearTodos(ArrayList<ArrayList<Alumno>> arr) {
    ArrayList<Alumno> newArr = new ArrayList<Alumno>();
    for(int i = 0; i < arr.size(); i += 1) {
      for(int j = 0; j < arr.get(i).size(); j += 1) {
        newArr.add(arr.get(i).get(j));
      }
    }

    for(int i = 0; i < newArr.size() - 1; i += 1) { 
      for(int j = 0; j < newArr.size() - 1 - i; j += 1) {
        if(newArr.get(j).getAverage() > newArr.get(j+1).getAverage()) {
          Alumno num = newArr.get(j+1);
          newArr.set(j+1, newArr.get(j));
          newArr.set(j, num);
        }
      }
    }

    for(int i = 0; i < newArr.size(); i += 1) {
      Alumno alumno = newArr.get(i);
      System.out.println((1 + i) + ". Nombre: " + alumno.getName()
      + " Edad: " + alumno.getAge() + " Promedio: " + alumno.getAverage());
    }
  }
  public static void randomFill(ArrayList<ArrayList<Alumno>> arr) {
    for(int i = 0; i < arr.size(); i += 1) {
      int n = random(60);
      for(int j = 0; j < n; j += 1) {
        String name = randomName();
        int age = random(40);
        double avg = random(200) / 10.0;

        Alumno alumno = new Alumno();
        alumno.setName(name);
        alumno.setAge(age);
        alumno.setAverage(avg);
        arr.get(i).add(alumno);
      }
    }
  }
  public static int random(int n) {
    return (int) (Math.random() * n + 1);
  }
  public static String randomName() {
    return "" + (char) (random(24) + 65) +
                (char) (random(24) + 65) +
                (char) (random(24) + 65) +
                (char) (random(24) + 65) +
                (char) (random(24) + 65) +
                (char) (random(24) + 65) +
                (char) (random(24) + 65) +
                (char) (random(24) + 65) +
                (char) (random(24) + 65);
  }
}
