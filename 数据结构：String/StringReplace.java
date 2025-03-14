public class Solution {
  public String replace(String input, String source, String target) {
    // Write your solution here
    if (input == null || source == null || target == null) {
      return null;
    }
    if (source.length() >= target.length()) {
      return replaceShorter(input, source, target);
    } else {
      return replaceLonger(input, source, target);
    }
  }

  private String replaceShorter(String input, String source, String target) {
    char[] array = input.toCharArray();
    int slow = 0;
    int fast = 0;
    while (fast + source.length() <= array.length) {
      if (array[fast] != source.charAt(0) || !isMatch(array, source, fast)) {
        array[slow++] = array[fast++];
      }
      else {
        replace(array, target, slow);
        slow = slow + target.length();
        fast = fast + source.length();
      }
    }
    // Copy remaining characters (Added to ensure no data loss)
    while(fast < array.length) {
      array[slow++] = array[fast++];
    }
    return new String(array, 0, slow);
  }

  private boolean isMatch(char[] array, String source, int fast) {
    for (int i = 0; i < source.length(); i++) {
      if (array[fast + i] != source.charAt(i)) return false;
    }
    return true;
  }

  private void replace(char[] array, String target, int slow) {
    for (int i = 0; i < target.length(); i++) {
      array[slow + i] = target.charAt(i); 
    }
  }

  private String replaceLonger(String input, String source, String target) {
    char[] array = input.toCharArray();
    Set<Integer> tailIndex= getAllMatch(array, source);
    char[] newArray = new char[array.length + tailIndex.size() * (target.length() - source.length())];
    int slow = newArray.length - 1;
    int fast = array.length - 1;
    while (fast >= 0) {
      if (!tailIndex.contains(fast)) { // Check if fast is an ending index
        newArray[slow--] = array[fast--];
      } else {
        replaceRight(newArray, target, slow); // Replace from right to left
        slow -= target.length();
        fast -= source.length();
      }
    }
    return new String(newArray);
  }

  private Set<Integer> getAllMatch(char[] array, String source) {
    Set<Integer> tailIndex = new HashSet<>();
    for (int i = 0; i + source.length()<= array.length; i++) {
      if (array[i] == source.charAt(0) && isMatch(array, source, i)) {
        tailIndex.add(i + source.length() - 1);
        i = i + source.length() - 1;
      }
    }
    return tailIndex;
  }

  private void replaceRight(char[] array, String target, int slow) {
    for (int i = target.length() - 1; i >= 0; i--) {
      array[slow--] = target.charAt(i); 
    }
  }
}
