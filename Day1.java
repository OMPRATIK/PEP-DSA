import java.util.Arrays;

class Day1 {
  public static void main(String[] args) {
    int[] arr = {1, 2, 3, 10, 11, 19, 20};
    System.out.println(linearSerch(arr, 10));
    System.out.println(binarySearch(arr, 100));

    System.out.println(floorOfNum(new int[]{1,2,5,6,7,8}, -2));
    System.out.println(ceilOfNum(new int[]{1,2,5,6,7,18}, 9));

    System.out.println(Arrays.toString(search2Dv1(new int[][] {{1,2,7}, {2,5,8}, {3,6,9}}, 9)));
    System.out.println(search2Dv2(new int[][] {{1,2,7}, {2,5,8}, {3,6,9}}, 19));

  }

  private static boolean search2Dv2(int[][] arr, int target) {
    int i = 0;
    int j = arr[0].length - 1;

    while(i < arr.length && j >= 0) {
      if(arr[i][j] == target) return true;
      else if(arr[i][j] > target) j--;
      else i++;
    }
    return false;
  }

  private static int[] search2Dv1(int[][] arr, int target) {
    int[] ans = {-1,-1};
    for(int i = 0; i < arr.length; i++) {
      int col = binarySearch(arr[i], target);
      if(col != -1) {
        return new int[] {i, col};
      }
    }
    return ans;
  }

  private static int linearSerch(int[] arr, int target) {
    for(int i = 0; i < arr.length; i++) {
      if(arr[i] == target) return i;
    }
    return -1;
  }

  private static int binarySearch(int[] arr, int target) {
    int start = 0;
    int end = arr.length - 1;

    while(start <= end) {
      int mid = start + (end - start) / 2;

      if(arr[mid] == target) return mid;
      else if(arr[mid] > target) end = mid - 1;
      else start = mid + 1;
    }
    return -1;
  }

  private static int floorOfNum(int[] arr, int num) {
    int start = 0;
    int end = arr.length - 1;

    if(num < arr[start]) return -1;

    while(start <= end) {
      int mid = start + (end - start) / 2;

      if(arr[mid] == num) return mid;
      else if(arr[mid] > num) end = mid - 1;
      else start = mid + 1;
    }
    
    return arr[end];
  
  }

  private static int ceilOfNum(int[] arr, int num) {
    int start = 0;
    int end = arr.length - 1;

    if(num > arr[start]) return -1;

    while(start <= end) {
      int mid = start + (end - start) / 2;

      if(arr[mid] == num) return mid;
      else if(arr[mid] > num) end = mid - 1;
      else start = mid + 1;
    }

    return arr[start];
  
  }
}