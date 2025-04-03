public class Solution {
  public int longestConsecutiveOnes(int[] nums, int k) {
    // Write your solution here
    int slow = 0;
    int fast = 0;
    int max = 0;
    Queue<Integer> zeros = new LinkedList<>();
    while (fast < nums.length) {
      if (nums[fast] == 0) {
        zeros.offer(fast);
      }
      if (zeros.size() > k) {
        slow = zeros.poll() + 1;
      }
      max = Math.max(max, fast - slow + 1);
      fast++;
    }
    return max;
  }
}
