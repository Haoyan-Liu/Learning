public class Solution {
  public int search(int[] array, int target) {
    // Write your solution here
    if (array.length == 0) {
      return -1;
    }
    int peak = findPeak(array);
    if (searchAsc(array, target, 0, peak) != -1) {
      return searchAsc(array, target, 0, peak);
    }
    else {
      return searchDesc(array,target, peak + 1, array.length - 1);
    }
  }
  
  private int findPeak(int[] array) {
    int left = 0;
    int right = array.length - 1;
    while (left < right - 1) {
      int mid = left + (right - left) / 2;
      if (array[mid] < array[mid + 1]) {
        left = mid;
      }
      else {
        right = mid;
      }
    }
    if (array[left] > array[right]) {
      return left;
    }
    else {
      return right;
    }
  }

  private int searchAsc(int[] array, int target, int left, int right) {
    while (left <= right) {
      int mid = left + (right - left) / 2;
      if (array[mid] == target) {
        return mid;
      }
      else if (array[mid] < target) {
        left = mid + 1;
      }
      else {
        right = mid - 1;
      }
    }
    return -1;
  }

  private int searchDesc(int[] array, int target, int left, int right) {
    while (left <= right) {
      int mid = left + (right - left) / 2;
      if (array[mid] == target) {
        return mid;
      }
      else if (array[mid] > target) {
        left = mid + 1;
      }
      else {
        right = mid - 1;
      }
    }
    return -1;
  }
}
