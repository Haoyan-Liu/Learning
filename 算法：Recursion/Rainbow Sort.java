// 三个挡板四个区域
// i：[0, i)是-1
// j：[i, j)是0，[j, k]是未探索区间
// k：(k, length - 1]是1

public class Solution {
  public int[] rainbowSort(int[] array) {
    // Write your solution here
    if (array == null || array.length == 0) {
      return array;
    }
    int i = 0;
    int j = 0;
    int k = array.length - 1;
    while(j <= k) {
      if (array[j] == -1) {
        swap(array,j,i);
        i++;
        j++;
      }
      else if (array[j] == 0) {
        j++;
      }
      else if (array[j] == 1) {
        swap(array,j,k);
        k--;
      }
    }
    return array;  
  }
  private void swap(int [] array ,int i, int j) {
    int temp = array[i];
    array[i] = array[j];
    array[j] = temp;
  }
}
