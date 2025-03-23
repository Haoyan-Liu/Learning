public class Solution {
  public int longest(int[] array) {
    // Write your solution here
    if (array.length == 0) return 0;
    int curLongest = 1;
    int longest = 1;
    for (int i = 1; i < array.length; i++) {
      if (array[i] > array[i - 1]) {
        curLongest++;
        longest = Math.max(longest, curLongest);
      }
      else {
        curLongest = 1;
      }
    }
    return longest;
  }
}
