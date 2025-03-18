public class Solution {
  public List<List<Integer>> nqueens(int n) {
    // Write your solution here

    List<List<Integer>> result = new ArrayList<>();
    List<Integer> cur = new ArrayList<>();
    // dfs
    dfs(result, cur, n);
    return result;
  }

  private void dfs(List<List<Integer>> result, List<Integer> cur, int n) {
    if (cur.size() == n) {
      result.add(new ArrayList<>(cur));
      return;
    }
    for (int row = 0; row < n; row++) {
      if (isValid(cur, row)) {
        cur.add(row);
        dfs(result, cur, n);
        cur.remove(cur.size() - 1);
      }
    }
    return;
  }
  private boolean isValid(List<Integer> cur, int row) {
    for (int i = 0; i < cur.size(); i++) {
      if (cur.get(i) == row || Math.abs(row - cur.get(i)) == Math.abs(cur.size() - i)) {
        return false;
      }
    }
    return true;
  }
}
