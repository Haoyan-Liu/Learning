// corner case：没找到就是丢了最后一个
public class Solution {
  public int missing(int[] array) {
    // Write your solution here
    if (array.length == 0) {
      return 1;
    }
    int left = 0;
    int right = array.length - 1;
    while (left < right - 1) {
      int mid = left + (right - left) / 2;
      if (array[left] - left == 1) {
        left = mid + 1;
      }
      else {
        right = mid;
      }
    }
    if (array[left] - left == 2) {
      return left + 1;
    }
    else if (array[right] - right == 2) {
      return right + 1;
    }
    else {
      return right + 2;
    }
  }
}
