public class Solution {
  public String reverseWords(String input) {
    // Write your solution here
    if (input == null || input.length() <= 1) return input;
    char[] array = input.toCharArray();
    reverse(array, 0, array.length - 1);
    int start = 0;
    int end = 0;
    while (end < array.length) {
      if (array[end] == ' ') {
        reverse(array, start, end - 1);
        end++;
        start = end;
      }
      else {
        end++;
      }
    }
    reverse(array, start, end - 1);
    return new String(array);
  }

  private void reverse(char[] array, int i, int j) {
    while(i < j) {
      char temp = array[i];
      array[i] = array[j];
      array[j] = temp; 
      i++;
      j--;
    }
  }
}
