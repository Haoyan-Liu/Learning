// 更新值，根据与原值的关系 percolate up / down
public class Solution {
  public int[] updateHeap(int[] array, int index, int ele) {
    // Write your solution here
    int n = array.length;
    int before = array[index];
    array[index] = ele;
    if (ele < before) {
      percolateUp(array, index);
    }
    if (ele > before) {
      percolateDown(array, index);
    }
    return array;
  }

  private void percolateUp(int[] array, int i) {
    while (i >= 0) {
      int parent = (i - 1) / 2;
      if (parent >= 0 && array[i] < array[parent]) {
        swap(array, i, parent);
        i = parent;
      } else {
        break;
      }
    }
  }

  private void percolateDown(int[] array, int i) {
    int n = array.length;
    while (i <= n / 2 - 1) {
      int left = 2 * i + 1;
      int right = 2 * i + 2;
      int swapCandidate = left;
      if (right <= n - 1 && array[right] < array[left]) {
        swapCandidate = right;
      }
      if (array[i] > array[swapCandidate]) {
        swap(array, i, swapCandidate);
        i = swapCandidate;
      }
      else {
        break;
      }
    }

  }

  private void swap(int[] array, int i, int j) {
    int tmp = array[i];
    array[i] = array[j];
    array[j] = tmp;
  }
}
