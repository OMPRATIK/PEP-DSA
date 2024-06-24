

class Stack {
  int idx = -1;
  int[] arr;

  Stack(int maxSize) {
    this.arr = new int[maxSize]; 
  }

  public boolean isEmpty() {
    return idx == -1;
  }

  public boolean isFull() {
    return idx == arr.length - 1;
  }

  public void push(int data) {
    if(isFull()) {
      System.out.println("Stack overFlow");
      return;
    }
    arr[++idx] = data;
  }

  public int pop() {
    if(isEmpty()) {
      System.out.println("Stack is empty");
      return -1;
    }

    int data = arr[idx--];

    return data;
  }

  public int peek() {
    return arr[idx];
  }

  public int size() {
    return idx + 1;
  }
}

// implement 2 stack i 1 array
class Stacks2withArray {
  int idx1 = -1;
  int idx2;
  int[] arr;

  Stacks2withArray(int maxSize) {
    this.arr = new int[maxSize];
    this.idx2 = maxSize;
  }

  public boolean isEmpty1() {
    return idx1 == -1;
  }

  public boolean isEmpty2() {
    return idx2 == arr.length;
  }

  public boolean isFull1() {
    return idx1 + 1 == idx2;
  }

  public boolean isFull2() {
    return idx1 + 1 == idx2;
  }

  void push1(int val) {
    if(isFull1()) {
      System.out.println("Stack 1 is full");
      return;
    }

    arr[++idx1] = val;
  }

  void push2(int val) {
    if(isFull2()) {
      System.out.println("Stack 2 is full");
      return;
    }

    arr[--idx2] = val;
  }

  int peek1() {
    return arr[idx1];
  }

  int peek2() {
    return arr[idx2];
  }

  public int pop1() {
    if(isEmpty1()) {
      System.out.println("Stack 1 is empty");
      return -1;
    }
    int data = arr[idx1--];
    return data;
  }

  public int pop2() {
    if(isEmpty2()) {
      System.out.println("Stack 2 is empty");
      return -1;
    }

    int data = arr[idx2++];
    return data;
  }

  public int size1() {
    return idx1 + 1;
  }

  public int size2() {
    return arr.length - idx1 - 1;
  }
}
public class Day7 {
  public static void main(String[] args) {
    // Stack stack = new Stack(19);
    // stack.push(10);
    // System.out.println(stack.pop());
    
    // stack.pop(); 

    // Stacks2withArray s = new Stacks2withArray(5);

    // System.out.println(s.pop2());
    // s.push1(10);
    // s.push1(20);
    // System.out.println(s.pop1());
    // s.push2(30);
    // s.push2(40);
    // s.push2(50);
    // s.push2(60);
    // System.out.println(s.pop1());
    // s.push1(70);
    // System.out.println(s.isEmpty1());
    // System.out.println(s.isFull2());
    // System.out.println(s.peek1());
    // System.out.println(s.peek2());
    // System.out.println(s.size2());

   String a = "a";
   String b = "a";

    System.out.println(a == b);
  }
}
