public class Day4 {
  public static void main(String[] args) {
    System.out.println(isSet(6, 1));
    System.out.println(setBit(11, 2));
    System.out.println(clearBit(5, 0));
    System.out.println(countBit(5));
  }

  // check if kth bit is set or not
  private static boolean isSet(int num, int k) {    
    return (num & (1 << k)) != 0;
  } 

  // set kth bit
  private static int setBit(int num, int k) {
    return (num | (1 << k));
  }

  // clear kth bit
  private static int clearBit(int num, int k) {
    return (num ^ (1 << k));
  }

  // count set bit
  private static int countBit(int num) {
    int cnt = 0;
    while(num != 0) {
      cnt += (num & 1) != 0 ? 1 : 0;
      num = num >> 1;
    }

    return cnt;
  }

  // single number 
}
