public class Solution {
  public int longest(String input) {
    // Write your solution here
    int maxLen = 0;
    // int curLen = 0;
    int slow = 0;
    int fast = 0;
    Set<Character> exist = new HashSet<>();
    while (fast < input.length()) {
      if (exist.contains(input.charAt(fast))) {
        while(input.charAt(slow) != input.charAt(fast)) {
          exist.remove(input.charAt(slow));
          slow++;
          // curLen--;
        }
        slow++;
        fast++;
        maxLen = Math.max(maxLen, fast - slow);
      } else {
        exist.add(input.charAt(fast));
        // curLen++;
        fast++;
        maxLen = Math.max(maxLen, fast - slow);
      }
    }
    return maxLen;
  }
}
