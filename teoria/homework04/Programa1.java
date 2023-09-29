public class Programa1{
  public static int linealSearch(int n, int[] arr) {
    for(int i = 0; i < arr.length; i += 1) {
      if(n == arr[i]) return i;
    }
    return -1;
  }

  public static int binariSearch(int n, int[] arr) {
    int min = 0;
    int max = arr.length - 1;
    while(min <= max) {
      int avg = (min + max)/2;
      if(n == arr[avg]) return avg;
      else if(n > arr[avg]) min = avg + 1;
      else max = avg - 1;
    }
    return -1;
  }

  public static void bubleSort(int[] arr) {
    for(int i = 0; i < arr.length - 1; i += 1) { 
      for(int j = 0; j < arr.length - 1 - i; j += 1) {
        if(arr[j] > arr[j + 1]) {
          int num = arr[j + 1];
          arr[j + 1] = arr[j];
          arr[j] = num;
        }
      }
    }
  }

  public static void selectSort(int [] arr) {
    for(int i = 0; i < arr.length - 1; i += 1) {
      int min = i;
      for(int j = i; j < arr.length; j += 1) {
        min = arr[min] > arr[j] ? j : min;
      }
      int num = arr[i];
      arr[i] = arr[min];
      arr[min] = num;
    }
  }

  public static void insertSort(int[] arr) {
    for(int i = 1; i < arr.length; i += 1) {
      int num = arr[i];
      int j = i - 1;
      while(j >= 0) {
        if(arr[j] > num) {
          arr[j + 1] = arr[j];
          arr[j] = num;
        } else {
          break;
        }
        j -= 1;
      }
    }
  }

  public static void printArr(int[] arr) {
    for(int n : arr) {
      System.out.print(n + " | ");
    }
    System.out.println();
  }
  
  public static void main(String[] args) {
    int[] arr = {4, 5, 3, 5, 6, 3, 10, 1};
    // int[] arr = {1, 4, 6, 7, 12, 15, 16, 24};

    printArr(arr);
    insertSort(arr);
    printArr(arr);
  }
}

