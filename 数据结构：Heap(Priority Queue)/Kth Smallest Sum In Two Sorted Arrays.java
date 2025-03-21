public class Solution {
  public int kthSum(int[] a, int[] b, int k) {
    // Write your solution here
    PriorityQueue<Node> minHeap = new PriorityQueue<>(new Comparator<Node>(){
      @Override
      public int compare(Node one, Node two) {
        if (one.value == two.value) {
          return 0;
        }
        return one.value < two.value ? -1 : 1;
      }
    });
    boolean[][] visited = new boolean[a.length][b.length];
    minHeap.offer(new Node(0, 0, a[0] + b[0]));
    visited[0][0] = true;
    while(k-- > 1) {
      Node cur = minHeap.poll();
      int i = cur.i;
      int j = cur.j;
      if (i < a.length - 1 && !visited[i + 1][j]) {
        minHeap.offer(new Node(i + 1, j, a[i + 1] + b[j]));
        visited[i + 1][j] = true;

      }
      if (j < b.length - 1 && !visited[i][j + 1]) {
        minHeap.offer(new Node(i, j + 1, a[i] + b[j + 1]));
        visited[i][j + 1] = true;
      }
    }
    return minHeap.poll().value;
  }

  class Node {
    int i;
    int j;
    int value;

    public Node(int i, int j, int value) {
      this.i = i;
      this.j = j;
      this.value = value;
    }
  }
}

//     1   3   5  Ai
// 4   5   7   9
// 8   9  11  13
// Bj
