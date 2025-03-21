public class Solution {
  public long kth(int k) {
    // Write your solution here
    PriorityQueue<Long> min = new PriorityQueue<>();
    Set<Long> visited = new HashSet<>();

    min.offer(3 * 5 * 7L);
    visited.add(3 * 5 * 7L);
    while (k > 1) {
      long cur = min.poll();
      k--;
      if (!visited.contains(cur * 3)) {
        min.offer(cur * 3);
        visited.add(cur * 3);
      }
      if (!visited.contains(cur * 5)) {
        min.offer(cur * 5);
        visited.add(cur * 5);
      }
      if (!visited.contains(cur * 7)) {
        min.offer(cur * 7);
        visited.add(cur * 7);
      }
    }
    return min.poll(); 
  }
}
