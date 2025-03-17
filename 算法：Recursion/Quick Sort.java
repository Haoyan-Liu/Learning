public class Solution {
  public int[] quickSort(int[] array) {
    // Write your solution here
    if (array == null || array.length == 1) {
      return array;
    }
    quickSort(array, 0, array.length - 1);
    return array;
  }

  private void swap(int[] array, int i, int j) {
    int temp = array[i];
    array[i] = array[j];
    array[j] = temp;
  }

  private int getPivotIndex(int left, int right) {
    return left + (int)(Math.random() * (right - left + 1));
  }

  private int partition(int[] array, int left, int right) {
    int pivot = getPivotIndex(left, right);
    int pivotNum = array[pivot];
    swap(array, pivot, right);
    int i = left;
    int j = right - 1;
    while (i <= j) {
      if (array[i] < pivotNum) {
        i++;
      }
      else {
        swap(array,i,j);
        j--;
      }
    }
    swap(array,i,right);
    return i;
  }

  private void quickSort(int[] array, int left, int right) {
    if (left >= right) {
      return;
    }
    int pivotIndex = partition(array, left, right);
    quickSort(array,left, pivotIndex - 1);
    quickSort(array,pivotIndex + 1, right);
  }
}
