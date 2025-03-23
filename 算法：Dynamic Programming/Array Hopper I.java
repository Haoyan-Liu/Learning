// Method 1 DP front
public class Solution {
  public boolean canJump(int[] array) {
    // Write your solution here
    boolean[] reachable = new boolean[array.length];
    reachable[0] = true;
    int length = reachable.length;
    for (int i = 1; i < length; i++) {
      for (int j = 0; j < i; j++) {
        if (reachable[j] == true && j + array[j] >= i) {
          reachable[i] = true;
        }
      }
    }
    return reachable[length - 1];
  }
}

// Method 2 DP back
public class Solution {
  public boolean canJump(int[] array) {
    // Write your solution here
    boolean[] reachable = new boolean[array.length];
    int length = reachable.length;
    reachable[length - 1] = true;
    for (int i = length - 2; i >= 0; i--) {
      for (int j = 0; j<= array[i]; j++) {
        if (i + j < array.length && reachable[i + j] == true) {
          reachable[i] = true;
          break;
          }
      }
    }
    return reachable[0];
  }
}

// Method 3 从前往后填可达，一旦到达就停止
public class Solution {
  public boolean canJump(int[] array) {
    // Write your solution here
    boolean[] reachable = new boolean[array.length];
    reachable[0] = true;
    int length = reachable.length;
    for (int i = 0; i < length; i++) {
      if (reachable[i] == true) {
        if (i + array[i] >= length - 1) {
          return true;
          }
        for (int j = 0; j <= array[i]; j++) {
          reachable[i + j] = true;
        }
      }
    }
    return reachable[length - 1];
  }
}
