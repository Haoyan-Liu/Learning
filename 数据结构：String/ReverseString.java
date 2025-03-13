public class Solution {
  public String reverse(String input) {
    // Write your solution here
    char[] array = input.toCharArray();
    int i = 0;
    int j = array.length - 1;
    while(i < j) {
      char tmp = array[i];
      array[i] = array[j];
      array[j] = tmp;
      i++;
      j--;
    }
    return new String(array);
  }
}
