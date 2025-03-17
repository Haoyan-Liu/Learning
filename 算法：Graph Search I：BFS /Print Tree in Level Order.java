public class Solution {
  public List<Integer> bfs(TreeNode root) {
    // Write your solution here
    List<Integer> res = new ArrayList<>();
    if (root == null) {
      return res;
    }

    Queue<TreeNode> queue = new ArrayDeque<>();
    queue.offer(root);
    while (!queue.isEmpty()) {
      TreeNode cur = queue.poll();
      res.add(cur.key);
      if (cur.left != null) {
        queue.offer(cur.left);
      }
      if (cur.right != null) {
        queue.offer(cur.right);
      }
    }
    return res;
  }
}
