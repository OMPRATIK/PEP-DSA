import java.util.HashMap;

public class Day9 {
  public static void main(String[] args) {
    int[] arr = {2, 8, -3, -5, 2, -4, 6, 1, 2, 1, -3, 4};
    System.out.println(largestSubarrayWithZero(arr));
    System.out.println(largestSubarrayWithZeroV2(arr));
  }

  private static int largestSubarrayWithZero(int[] arr) {
    int size = 0;

    for(int i = 0; i < arr.length; i++) {
      int sum = 0;
      for(int j = i; j < arr.length; j++) {
        sum += arr[j];
        if(sum == 0) {
          size = Math.max(j - i + 1, size);
        }
      }
    }

    return size;
  }

  private static int largestSubarrayWithZeroV2(int[] arr) {
      int size = 0;
      HashMap<Integer, Integer> hm = new HashMap<>();

      hm.put(0, -1);
      int sum = 0;
      for(int i = 0; i < arr.length; i++) {
        sum += arr[i];

        if(hm.containsKey(sum)) {
          size = Math.max(i - hm.get(sum), size);
        } else {
          hm.put(sum , i);
        }

      }

      return size;
  }
}
