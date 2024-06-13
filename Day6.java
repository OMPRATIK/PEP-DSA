import java.util.Arrays;

public class Day6 {
  public static void main(String[] args) {
    int[] arr = {5, 1, 2, 9 , 0, -1, -3, 5, };
    quickSort(arr, 0, arr.length - 1);
    System.out.println(Arrays.toString(arr));
  }

  // quick sort
  private static void quickSort(int[] arr, int start, int end) {
    if(start >= end) return;

    int pos = partition(arr, start, end);
    quickSort(arr, start, pos - 1);
    quickSort(arr, pos + 1, end);
  }

  private static int partition(int[] arr, int start, int end) {
    int idx = start - 1;
    int pivotVal = arr[end];
    for(int j = start; j < end; j++) {
      if(arr[j] <= pivotVal) {
        idx++;
        swap(arr, j , idx);
      }
    }
    idx++;
    swap(arr, end, idx);
    
    return idx;
  }

  private static void swap(int[] arr, int idx1, int idx2) {
    int temp = arr[idx1];
    arr[idx1] = arr[idx2];
    arr[idx2] = temp;
  }
}
