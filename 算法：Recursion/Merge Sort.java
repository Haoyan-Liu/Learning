// Step 1: 分割数组
// [5, 2, 9, 1, 6, 3]  →  [5, 2, 9]  |  [1, 6, 3]
//                        /      \
//                   [5] [2,9]  [1] [6,3]
//                      /    \    /    \
//                    [2] [9]  [6] [3]

// Step 2: 合并排序后的子数组
// [2,9] → [2,9]
// [5,2,9] → [2,5,9]
// [1,6,3] → [1,3,6]
// [2,5,9] 和 [1,3,6] 合并 → [1,2,3,5,6,9]（最终排序完成）

public class Solution {
  public int[] mergeSort(int[] array) {
    // Write your solution here
    if (array == null || array.length == 0) {
      return array;
    } else;
    return mergeSort(array,0,array.length - 1);
  }

  private int[] mergeSort(int[] array, int left, int right) {
    if (left == right) {
      return new int[]{array[left]};
    }
    int mid = left + (right - left) / 2;
    int[] leftArray = mergeSort(array, left, mid);
    int[] rightArray = mergeSort(array, mid + 1, right);
    return mergeTwoArray(leftArray, rightArray);
  }

  private int[] mergeTwoArray(int[] one, int[]two) {
    int i = 0;
    int j = 0;
    int k = 0;
    int[] res = new int[one.length + two.length];
    while(i < one.length && j < two.length) {
      if(one[i] <= two[j]) {
        res[k] = one[i];
        i++;
      } else {
        res[k] = two[j];
        j++;
      }
      k++;
    }
    while (i < one.length) {
      res[k] = one[i];
      i++;
      k++;
    }
    while (j < two.length) {
      res[k] = two[j];
      j++;
      k++;
    }
    return res;
  }
}
