import java.util.Arrays;

public class Day1HW {
  public static void main(String[] args) {
    System.out.println(Arrays.toString(rowAndMaximumOnes(new int[][]{{0,1},{0,1}})));

    System.out.println(rotatedBinarySearch(new int[]{4,5,6,7,0,1,2}, 4));

    System.out.println(searchInInfiniteArray(new int[]{1,2,3,5,7,9,10,11,23}, -3));
  }

  // row with maximum ones
  private static int[] rowAndMaximumOnes(int[][] mat) {
    int[] ans = {0 , 0};
    for(int i = 0; i < mat.length; i++) {
        int cnt = count(mat[i]);
        if(cnt > ans[1]) {
            ans = new int[]{i, cnt}; 
        }
    }
    return ans;
}

  private static int count(int[] arr) {
      int cnt = 0;
      for(int i = 0; i < arr.length; i++) {
          if(arr[i] == 1) cnt++;
      }
      return cnt;
  }

  // Search in rotated array

  private static int rotatedBinarySearch(int[] nums, int target) {
    int start = 0;
    int end = nums.length - 1;

    while(start <= end) {
        int mid = start + (end - start) / 2;

        if(nums[mid] == target) return mid;
        else if(nums[start] <= nums[mid]) {
            if(target >= nums[start] && target <= nums[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        } else {
            if(target >= nums[mid] && target <= nums[end]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
    }

    return -1;
  }

  // search in an infinite array
  private static int searchInInfiniteArray(int[] nums, int target) {
    int start = 0;
    int end = 1;

    while(nums[end] < target) {
      start = end;
      end = 2 * end;
    }

    return binarySearch(nums, target, start, end);

  }

  private static int binarySearch(int[] nums, int target,int start,int end) {

    while(start <= end) {
      int mid = start + (end - start) / 2;

      if(nums[mid] == target) return mid;
      else if(target > nums[mid]) start = mid + 1;
      else end = mid -1;
    }
    return -1;
  }

}
