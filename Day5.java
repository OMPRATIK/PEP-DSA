import java.util.Arrays;

public class Day5 {
  public static void main(String[] args) {
    int[] arr = {5, 1, 2, 9 , 0, -1, -3, 5, 6};
    mergeSort(arr, 0, arr.length - 1);
    // insertionSort(arr);
    // selectionSort(arr);
    // bubbleSort(arr);
    System.out.println(Arrays.toString(arr));
    printONeToN(5);

    System.out.println(fatorialRec(5));
    System.out.println(fibonacci(4));

    System.out.println(maxNumInArray(new int[] {9, 1, 2, 3, 4, 5}, 0));
  }

  // bubble sort

  private static void bubbleSort(int[] arr) {
    
    for(int i = 0; i < arr.length; i++) {
      boolean isSorted = true;
      for(int j = 0; j < arr.length - i - 1; j++) {
        if(arr[j] > arr[j + 1]) {
          int temp = arr[j];
          arr[j] = arr[j + 1];
          arr[j + 1] = temp;

          isSorted = false;
        }
      }
      if(isSorted) return;
    }
  }

  private static void selectionSort(int[] arr) {
    for(int i = 0; i < arr.length; i++) {
      int minPos = i;
      for(int j = i + 1; j < arr.length; j++) {
        if(arr[j] < arr[minPos]) minPos = j;
      }
      int temp = arr[minPos];
      arr[minPos] = arr[i];
      arr[i] = temp;
    }
  }

  // insertion sort
  private static void insertionSort(int[] arr) {
    for(int i = 1; i < arr.length ; i++) {
      int j = i - 1;
      int temp = arr[i];
      while(j >= 0 && arr[j] > temp) {
        arr[j + 1] = arr[j];
        j--;
      }
      arr[j + 1] = temp;
    }
  }

  // Merge sort
  private static void mergeSort(int[] arr, int start, int end) {
    if(start >= end) return;
    int mid = start + (end - start) / 2;
    mergeSort(arr, start, mid);
    mergeSort(arr, mid + 1, end);
    merge(arr, start, mid, end);
  }

  private static void merge(int[] arr, int start, int mid, int end) {
    int i = start;
    int j = mid + 1;
    int[] temp = new int[end - start + 1];
    int k = 0;
    while(i <= mid && j <= end) {
      if(arr[i] < arr[j]) {
        temp[k++] = arr[i++];
      } else {
        temp[k++] = arr[j++];
      }
    }

    while(i <= mid) {
      temp[k++] = arr[i++];
    }

    while(j <= end) {
      temp[k++] = arr[j++];
    }

    for(i = start, k = 0; i <= end && k < temp.length; i++, k++) {
      arr[i] = temp[k];
    }
  }

  // recursion
  private static void printONeToN(int n) {
    if(n == 0) return;
    printONeToN(n - 1);
    System.out.println(n);
  }

  // factorial
  private static int fatorialRec(int num) {
    if(num < 0) return -1;
    if(num == 0) return 1;

    return num * fatorialRec(num - 1);
  }

  private static int fibonacci(int num) {
    if(num < 1) return 0;
    if(num == 1) return 1;

    return fibonacci(num - 1) + fibonacci(num - 2);
  }

  // max num using rec
  private static int maxNumInArray(int[] arr, int i) {
    if(i == arr.length) return Integer.MIN_VALUE;
    return Math.max(arr[i], maxNumInArray(arr, i + 1));
  }


  // count inversions --------------------------------------------------------------------------

  static long mergeSort(long[] arr, int start, int end) {
    long ans = 0;
    if(start == end) return ans;
    
    int mid = start + (end - start) / 2;
    
    ans += mergeSort(arr, start, mid);
    ans += mergeSort(arr, mid + 1, end);
    ans += merge(arr, start, mid, end);
    
    return ans;
}

static long merge(long[] arr, int start, int mid, int end) {
    int i = start;
    int j = mid + 1;
    int k = 0;
    long[] temp = new long[end - start + 1];
    long cnt = 0;
    
    while(i <= mid && j <= end) {
        if(arr[i] <= arr[j]) {
            temp[k++] = arr[i++];
        } else {
            temp[k++] = arr[j++];
            cnt += mid - i + 1;
        }
    }
    
    while(i <= mid) {
        temp[k++] = arr[i++];
    }
    
    while(j <= end) {
        temp[k++] = arr[j++];
    }
    
    for(i = start,k = 0; i <= end && k < temp.length; i++, k++) {
        arr[i] = temp[k];
    }
    
    return cnt;
}
}
