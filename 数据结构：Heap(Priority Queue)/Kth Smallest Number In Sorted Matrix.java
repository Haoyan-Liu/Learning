public class Solution {
  public int kthSmallest(int[][] matrix, int k) {
    // Write your solution here
    int rowLength = matrix.length;
    int colLength = matrix[0].length;
    PriorityQueue<Cell> min = new PriorityQueue<>();
    boolean[][] visited = new boolean[rowLength][colLength];

    min.offer(new Cell(0, 0, matrix[0][0]));
    visited[0][0] = true;
    while (k > 1) {
      Cell cur = min.poll();
      k--;
      if (cur.row + 1 < rowLength && !visited[cur.row + 1][cur.col]) {
        min.offer(new Cell(cur.row + 1, cur.col, matrix[cur.row + 1][cur.col]));
        visited[cur.row + 1][cur.col] = true;
      }
      if (cur.col + 1 < colLength && !visited[cur.row][cur.col + 1]) {
        min.offer(new Cell(cur.row, cur.col + 1, matrix[cur.row][cur.col + 1]));
        visited[cur.row][cur.col + 1] = true;
      }
    }
    return min.poll().value;
  }

  class Cell implements Comparable<Cell> {
    int row, col, value;
    public Cell(int row, int col, int value) {
      this.row = row; this.col = col; this.value = value;
    }
    @Override
    public int compareTo(Cell other) {
      return Integer.compare(this.value, other.value);
    }
  }
}
