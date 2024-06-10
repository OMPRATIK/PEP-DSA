import java.util.Arrays;

public class Day3 {
  public static void main(String[] args) {
    System.out.println(cntFactorsV1(36));
    System.out.println(cntFactorsV1(30));

    System.out.println("----------PRime----------");
    System.out.println(isPrimeV1(2));
    System.out.println(isPrimeV1(7));
    System.out.println(isPrimeV1(30));


    System.out.println();
    prime(7);
    sievePrime(7);


    System.out.println("GCD v1 -> " + gcdV1(3, 12));
    isNumberOfFactorsOddorEven(36);
    isNumberOfFactorsOddorEven(30);
  }

  // count factors of a number
  private static int cntFactorsV1(int num) {
      int cnt = 0;

      for(int i = 1; i <= (int)Math.sqrt((double)num); i++) {
        if(num % i == 0 && (double)num / i != i) {
          cnt += 2;
        } else if(num % i == 0) cnt++;
      }
      return cnt;
  }

  // if num has odd factors or even factors
  private static String isNumberOfFactorsOddorEven(int num) {
    return Math.sqrt(num) == num / Math.sqrt(num) ? "Odd" : "Even";
  }

  // prime or not
  private static boolean isPrimeV1(int num) {
    if(num <= 1) return false;
    if(num == 2) return true;
    int cnt = 0;
    for(int i = 2; i <= (int)Math.sqrt((double)num); i++) {
      if(num % i == 0 && (double)num / i != i) {
        cnt += 2;
      } else if(num % i == 0) cnt++;
    }
    return cnt == 0;
  }

  // check prime from 0 -> n (O(n * sqrt(n)))
  private static void prime(int num) {
    boolean[] arr = new boolean[num + 1];

    for(int i = 1; i < arr.length; i++) {
      if(isPrimeV1(i)) arr[i] = true;
    }

    System.out.println(Arrays.toString(arr));
  }


  // Sieve of eratosthines
  private static void sievePrime(int num) {
    boolean[] arr = new boolean[num + 1];
    for(int i = 2; i < arr.length; i++) {
      arr[i] = true;
    }

    for(int i = 2; i <= (int)Math.sqrt((double)num); i++) {
      if(arr[i]) {
        for(int j = i * i; j <= num; j += i) {
          arr[j] = false;

        }
      }
    }
    System.out.println(Arrays.toString(arr));
  }

  // gcd of 2 numbers
  public static int gcdV1(int num1, int num2) {
    for(int i = Math.min(num1, num2); i >= 1 ; i--) {
      if(num1 % i == 0 && num2 % i == 0) return i;
    }

    return 1;
  }


  // eucledian theorem & single number II leetcode
}
