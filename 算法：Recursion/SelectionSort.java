// 找到最小的元素，将其放到数组的起始位置。
// 在剩余的元素中 继续寻找最小值，放到已排序部分的下一个位置。
// 重复该过程，直到所有元素都被放置到正确位置。
  
public class Solution {
  public int[] solve(int[] array) {
    // Write your solution here
    for ( int i = 0; i < array.length - 1; i++) {
      int globalMin = i;
      for (int j = i + 1; j < array.length; j++) {
        if (array[j] < array[globalMin]) {
          globalMin = j;
        }
      }
      // swap
      int temp = array[i];
      array[i] = array[globalMin];
      array[globalMin] = temp;
    }
    return array;
  }
}
