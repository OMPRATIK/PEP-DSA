import java.util.Arrays;

class Day2 {
  public static void main(String[] args) {
    System.out.println(search2Dv1(new int[][] {{1,2,3,4}, {7,10,11,12}, {15,17, 19,28}}, 28));
    System.out.println(search2Dv2(new int[][] {{1,2,3,4}, {7,10,11,12}, {15,17, 19,28}}, 28));
    
  }

  // search 2D matrix in which first integer of each row is greater than last integer of last row -------------------
  // time -> O(log(m * n)) space -> O(m * n)
  private static boolean search2Dv1(int[][] arr, int target) {
    int[] helper = new int[arr.length * arr[0].length];
    int k = 0;
    for(int i = 0; i < arr.length; i++) {
      for(int j = 0; j < arr[0].length; j++) {
        helper[k++] = arr[i][j];
      }
    }

    return binarySearch(helper, target, 0, helper.length - 1);
  }

  private static boolean binarySearch(int[] nums, int target,int start,int end) {

    while(start <= end) {
      int mid = start + (end - start) / 2;

      if(nums[mid] == target) return true;
      else if(target > nums[mid]) start = mid + 1;
      else end = mid -1;
    }
    return false;
  }

  // time -> O(log(m * n)) space -> O(1)
  private static boolean search2Dv2(int[][] arr, int target) {
    int i = 0;
    int j = arr.length * arr[0].length - 1;

    while(i <= j) {
      int mid = i + (j - i) / 2;
      int midVal = arr[mid / arr[0].length][mid % arr[0].length];
      if(midVal == target) {
        return true;
      } else if(midVal > target) {
        j = mid - 1;
      } else i = mid + 1; 
    }
    return false;
  }

  // -----------------------------------------------------------------------------------



  // Aggressive cows -------------------------------------------------------------------
   public static int aggressiveCows(int n, int k, int[] stalls) {
        Arrays.sort(stalls);
        
        int start = 1;
        int end = stalls[stalls.length - 1] - 1;
        int ans = Integer.MIN_VALUE;
        
        while(start <= end) {
            int mid = start + (end - start) / 2;
            
            if(check(stalls, n, k, mid)) {
                ans = Math.max(ans, mid); 
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        
        return ans;
    }
    
    private static boolean check(int[] stalls, int n, int k, int gap) {
        int cows = 1;
        int pos = stalls[0];
        
        for(int i = 1; i < n; i++) {
            if(stalls[i] - pos >= gap) {
                pos = stalls[i];
                cows++;
            }
            
            if(cows == k) return true;
        }
        
        return false;
    }
}