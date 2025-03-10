// 两个挡板三个区域
// left左边 看过的不是0的

// right右边看过的是0的

// left right之间，未探索区间
  
public class Solution {
  public int[] moveZero(int[] array) {
    // Write your solution here
    if (array == null || array.length <= 1) {
      return array;
    }
    int i = 0;
    int j = array.length - 1;
    while (i <= j) {
      if (array[i] == 0) {
        swap(array,i,j);
        j--;
      }
      else {
        i++;
      }
    }
    return array;
  }
  private int[] swap(int[] array, int i, int j) {
    int temp = array[i];
    array[i] = array[j];
    array[j] = temp;
    return array;
  }
}
