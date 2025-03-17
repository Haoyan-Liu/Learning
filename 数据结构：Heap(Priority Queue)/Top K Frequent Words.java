public class Solution {
  public String[] topKFrequent(String[] combo, int k) {
    if (combo.length == 0) {
      return new String[0];
    }
    Map<String, Integer> freqMap = getFrequencyMap(combo);
    PriorityQueue<Map.Entry<String, Integer>> minHeap = new PriorityQueue<>(k, new Comparator<Map.Entry<String, Integer>>() {
      @Override
      public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
        // if (o1.getValue().equals(o2.getValue())) return 0;
        // return o1.getValue() < o2.getValue() ? -1 : 1;
        return Integer.compare(o1.getValue(), o2.getValue()); // 按值升序排序（最小堆）
        }
        });
    for (Map.Entry<String, Integer> entry : freqMap.entrySet()) {
      if (minHeap.size() < k) {
        minHeap.offer(entry);
      }
      else if (entry.getValue() > minHeap.peek().getValue()) {
        minHeap.poll();
        minHeap.offer(entry);
      }
    }

    int len = minHeap.size();
    String[] res = new String[len];
    for (int i = len - 1; i >= 0; i--) {
      res[i] = minHeap.poll().getKey();
    }
    return res;
  }

  private Map<String, Integer> getFrequencyMap(String[] str) {
    Map<String, Integer> map = new HashMap<>();
    for (String s: str) {
      map.put(s, map.getOrDefault(s, 0) + 1);
    }
    return map;
  }
}
