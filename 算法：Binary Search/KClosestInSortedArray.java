public class Solution {
  public int[] kClosest(int[] array, int target, int k) {
    // Write your solution here
    int[] res = new int[k];
    int left = closest(array, target);
    int right = left + 1;
    for (int i = 0; i < k; i++){
      if (right > array.length - 1) {
        res[i] = array[left];
        left--;
      }
      else if (left < 0) {
        res[i] = array[right];
        right++;
      }
      else if (Math.abs(target - array[left]) <= Math.abs(target - array[right])) {
        res[i] = array[left];
        left--;
      }
      else {
        res[i] = array[right];
        right++;
      }
    }
    return res;
  }

  private int closest(int[] array, int target) {
    int left = 0;
    int right = array.length - 1;
    while (left < right - 1) {
      int mid = left + (right - left) / 2;
      if (array[mid] == target) {
        return mid;
      }
      if (array[mid] < target) {
        left = mid;
      }
      else {
        right = mid;
      }
    }
    if (Math.abs(target - array[left]) < Math.abs(array[right] - target)) {
      return left;
    }
    else {
      return right;
    }
  }
}
