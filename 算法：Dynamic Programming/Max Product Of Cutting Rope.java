public class Solution {
  public int maxProduct(int length) {
    // Write your solution here
    if (length == 2) {return 1;}
    int[] dp = new int[length + 1];
    dp[0] = 0;
    dp[1] = 0;
    dp[2] = 1;
    for (int i = 3; i <= length; i++) {
      int max = 0;
      for (int j = 1; j < i; j++) {
        max = Math.max(max, Math.max(dp[j] * (i - j), j * (i - j))); // !!!
      }
      dp[i] = max;
    }
    return dp[length];
  }
}
