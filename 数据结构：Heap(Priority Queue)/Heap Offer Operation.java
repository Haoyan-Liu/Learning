// 放尾部，然后 percolate up
public class Solution {
  public int[] offerHeap(int[] array, int ele) {
    // Write your solution here
    int n = array.length;
    array[n - 1] = ele;
    percolateUp(array, n - 1);
    return array;
  }

  private void percolateUp(int[] array, int i) {
    while (i >= 0) {
      int parent = (i - 1) / 2;
      if (parent >= 0 && array[parent] > array[i]) {
        swap(array, i, parent);
        i = parent;
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
