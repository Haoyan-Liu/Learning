// recursion tree
//             fib(4)
//            /      \
//       fib(3)      fib(2)
//      /     \      /     \
//  fib(2)  fib(1) fib(1) fib(0)
//  /     \
// fib(1) fib(0)

public class Solution {
  public int fibonacci(int k) {
    // Write your solution here
    if (k <= 0) {
      return 0;
    }
    if (k == 1) {
      return 1;
    }
    return (fibonacci(k - 1) + fibonacci(k - 2));
  }
}
