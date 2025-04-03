public class Solution {
  public boolean match(String input, String pattern) {
    // Write your solution here
    int one = 0;
    int two = 0;
    int count = 0;
    while (one < input.length() && two < pattern.length()) {
      if (Character.isDigit(pattern.charAt(two))) {
        count = 0;
        while (two < pattern.length() && Character.isDigit(pattern.charAt(two))) { // 因为要循环所以还是要check two的合法性
          count = count * 10 + (pattern.charAt(two) - '0'); // pattern.charAt(two) - '0'的结果才是int 不然是char
          two++;
        }
        one += count; 
      }
      else if (one >= input.length() || input.charAt(one) != pattern.charAt(two)) {
        return false;
      }
      else { // 排除所有情况才能++ 不然会影响最后return
        one++;
        two++;
      }
    }
    return one == input.length() && two == pattern.length();
  }
}
