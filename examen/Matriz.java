public class Matriz {
  private int[][] arr;
  private int columnas;
  private int filas;

  public Matriz(int n, int m) {
    arr = new int[n][m];
    columnas = n;
    filas = m;
  }

  public Matriz(int n) {
    this(n, n);
  }

  public void mostrar() {
    for(int[] f : arr) {
      for(int e : f) {
        System.out.println(e);
      }
    }
  }

  public void aleatoria(int min, int max) {
    for(int i = 0; i < arr.length; i += 1) {
      for(int j = 0; j < arr[i].length; j += 1) {
        arr[i][j] = (int)(Math.random() * (max - min) + min);
      }
    }
  }
  
  public void alterar(int n) {
    for(int[] fila : arr) {
      for(int element : fila) {
        element *= n;
      }
    }
  }
  public void zeros() {
    for(int[] fila : arr) {
      for(int element : fila) {
        element = 0;
      }
    }
  }

  public boolean esCuadrada() {
    return arr.length == arr[0].length;
  }

  public Matriz sumar(Matriz m) {
    Matriz r = new Matriz(m.columnas, m.filas);
    
    for(int i = 0; i < r.arr.length; i += 1) {
      for(int j = 0; j < r.arr[0].length; j += 1) {
        r.arr[i][j] = m.arr[i][j] + arr[i][j];
      }
    }
    return r;
  }

  public static Matriz sumar(Matriz a, Matriz b) {
    Matriz r = new Matriz(a.columnas, b.columnas);
    
    for(int i = 0; i < r.columnas; i += 1) {
      for(int j = 0; j < r.filas; j += 1) {
        r.arr[i][j] = a.arr[i][j] + b.arr[i][j];
      }
    }
    return r;
  }
}
