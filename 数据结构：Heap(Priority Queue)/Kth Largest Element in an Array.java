public class Solution {
  public int findKthLargest(int[] nums, int k) {
    // Can use Collections.reverseOrder() to create maxHeap
    // PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, new Comparator<Integer>(){
      @Override
      public int compare(Integer o1, Integer o2) {
        if (o1 == o2) return 0;
        return o1 < o2 ? 1 : -1;
      }
    });

    for (int i = 0; i < nums.length; i++) {
      maxHeap.offer(nums[i]);
    }

    for (int i = 0; i < k - 1; i++) {
      maxHeap.poll();
    }

    return maxHeap.poll();
  }
}

// Method 2
public class Solution {
  public int findKthLargest(int[] nums, int k) {
    // Write your solution here
    PriorityQueue<Integer> minHeap = new PriorityQueue<>(k);

    for (int i = 0; i < k; i++) {
      minHeap.offer(nums[i]);
    }

    for (int i = k; i < nums.length; i++) {
      if (nums[i] > minHeap.peek()) {
        minHeap.poll();
        minHeap.offer(nums[i]);
      }
    }

    return minHeap.poll();
  }
}
