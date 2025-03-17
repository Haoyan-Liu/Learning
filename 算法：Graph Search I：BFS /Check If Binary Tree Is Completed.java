public class Solution {
  public boolean isCompleted(TreeNode root) {
    // Write your solution here
    Queue<TreeNode> queue = new ArrayDeque<>();
    if (root == null) return true;
    boolean flag = false;
    queue.offer(root);
    while (!queue.isEmpty()) {
      TreeNode cur = queue.poll();
      if (cur.left == null) {
        flag = true;
        }
      else if (flag == true) {
        return false;
      } else {
        queue.offer(cur.left);
      }
      if (cur.right == null) {
        flag = true;
        }
      else if (flag == true) {
        return false;
      } else {
        queue.offer(cur.right);
      }
    }
    return true;
  }
}
