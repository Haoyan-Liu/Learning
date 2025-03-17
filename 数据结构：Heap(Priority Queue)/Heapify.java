// 当一个node左右子树都是heap的时候，对本身做percolate down会使得以它为root的整棵子树成为heap 自下而上
public class Solution {
  public int[] heapify(int[] array) {
    // Write your solution here
    if (array == null) {
      return null;
    }
    int n = array.length;
    for (int i = n / 2 - 1; i >= 0; i--) {
      percolateDown(array, i, n);
    }
    return array;
  }

  private void percolateDown(int[] array, int i, int n) {
    // i = n / 2 - 1时，已经站在了最后一个root节点，最后做一次比较就不用再往后走了
    while (i <= n / 2 - 1) {
      int left = 2 * i + 1; // n -1 不可能超界
      int right = 2 * i + 2; // n 可能超界
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
