public class Solution {
  public int smallestElementLargerThanTarget(int[] array, int target) {
    // Write your solution here
    if (array == null || array.length == 0) {
      return -1;
    }
    int left = 0;
    int right = array.length - 1;
    while (left < right - 1) {
      int mid = left + (right - left) / 2;
      if (array[mid] <= target) {
        left = mid;
      }
      else {
        right = mid;
      }
    }
    if (array[left] > target) {
      return left;
    }
    if (array[right] > target) {
      return right;
    }
    else {
      return -1;
    }
  }
}
