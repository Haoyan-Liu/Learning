public class Solution {
  public long fibonacci(int K) {
    // Write your solution here
    if (K <= 0) {
      return 0L;
    }
    if (K == 1) {
      return 1L;
    }

    long small = 0;
    long large = 1;
    int cur = 1;
    while (cur < K) {
      long next = small + large;
      small = large;
      large = next;
      cur++;
    }
    return large;
  }
}
