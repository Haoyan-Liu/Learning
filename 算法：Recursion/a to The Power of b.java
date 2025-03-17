// recursion tree
//          power(2,4)
//          /        \\
//     2 * power(2,3)
//          /        \\
//     2 * power(2,2)
//          /        \\
//     2 * power(2,1)
//          /        \\
//     2 * power(2,0)
//                |
//                1

public class Solution {
  public long power(int a, int b) {
    // Write your solution here
    if (b == 0 || a == 1) {
      return 1;
    }
    if (a == 0) {
      return a;
    }
    if (b == 1) {
      return a;
    }
    if (a == -1) {
      if (b % 2 == 0) {
        return 1;
      }
      else return -1;
    }
    long sub = power(a, b - 1);
    sub *= a;
    return sub;
  }
}

// recursion tree
// power(2,4)
// ├── power(2,2)
// │    ├── power(2,1)
// │    │    ├── power(2,0) = 1
// │    │    └── return 2
// │    └── return 4 (2 * 2)
// └── return 16 (4 * 4)

public class Solution {
  public long power(int a, int b) {
    if (b == 0) return 1;
    if (a == 0) return 0;
    
    long half = power(a, b / 2);
    
    if (b % 2 == 0) {
      return half * half;
    } else {
      return half * half * a;
    }
  }
}
