// minHeap方法
public class Solution {
  public int[] kSmallest(int[] array, int k) {
    // Write your solution here
    if (array.length == 0 || k == 0) {
      return new int[0];
    }
      
    int[] res = new int[k];
    List<Integer> list = new ArrayList<>();
    for (int ele : array) {
      list.add(ele);
    }

    PriorityQueue<Integer> minHeap = new PriorityQueue<>(list); // heapify
    for (int i = 0; i < k; i++) {
      res[i] = minHeap.poll();
    }

    return res;
  }
}

// maxHeap方法
public class Solution {
  public int[] kSmallest(int[] array, int k) {
    // Write your solution here
    if (array.length == 0 || k == 0) {
      return new int[0];
    }
      
    int[] res = new int[k];

    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    // 先放前k个进去
    for (int i = 0; i < k; i++) {
      maxHeap.offer(array[i]);
    }
    // 新来的大无事发生，新来的小poll顶出最大，放入当前值
    for (int i = k; i < array.length; i++) {
      if (array[i] < maxHeap.peek()) {
        maxHeap.poll();
        maxHeap.offer(array[i]);
      }
    }
    for (int i = k - 1; i >= 0; i--) {
      res[i] = maxHeap.poll();
    }

    return res;
  }
}
