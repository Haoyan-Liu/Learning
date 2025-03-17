public class Solution {
  public int[][] wallsAndGates(int[][] rooms) {
    // Write your solution here
    if (rooms.length == 0 || rooms[0].length == 0) {
      return rooms; // not a 2D array
    }
    int rowLen = rooms.length - 1;
    int colLen = rooms[0].length - 1;
    Queue<int[]> queue = new ArrayDeque<>();
    // 先把所有的gate放进queue
    for (int i = 0; i <= rowLen; i++) {
      for (int j = 0; j <= colLen; j++) {
        if (rooms[i][j] == 0) {
          queue.offer(new int[]{i, j});
        }
      }
    }
    while(!queue.isEmpty()) {
      int[] cur = queue.poll();
      int curRow = cur[0];
      int curCol = cur[1];
      
      if (curRow - 1 >= 0 && rooms[curRow - 1][curCol] == Integer.MAX_VALUE) {
        rooms[curRow - 1][curCol] = rooms[curRow][curCol] + 1;
        queue.offer(new int[]{curRow - 1, curCol});
      }

      if (curRow + 1 <= rowLen && rooms[curRow + 1][curCol] == Integer.MAX_VALUE) {
        rooms[curRow + 1][curCol] = rooms[curRow][curCol] + 1;
        queue.offer(new int[]{curRow + 1, curCol});
      }

      if (curCol - 1 >= 0 && rooms[curRow][curCol - 1] == Integer.MAX_VALUE) {
        rooms[curRow][curCol - 1] = rooms[curRow][curCol] + 1;
        queue.offer(new int[]{curRow, curCol - 1});
      }

      if (curCol + 1 <= colLen && rooms[curRow][curCol + 1] == Integer.MAX_VALUE) {
        rooms[curRow][curCol + 1] = rooms[curRow][curCol] + 1;
        queue.offer(new int[]{curRow, curCol + 1});
      }
    }
    return rooms;
  }
}
