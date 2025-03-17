public class Solution {
  public boolean isCousin(TreeNode root, int a, int b) {
    // Write your solution here
    if (root == null) return false;
    Queue<TreeNode> queue = new ArrayDeque<>();
    boolean flagA = false;
    boolean flagB = false;
    queue.offer(root);
    while (!queue.isEmpty()) {
      int size = queue.size();
      while (size > 0) {
        TreeNode cur = queue.poll();
        if (cur.left != null && cur.right != null) {
          if (cur.left.key == a && cur.right.key == b) {
            return false;
          }
          if (cur.left.key == b && cur.right.key == a) {
            return false;
          }
        }
        if (cur.key == a) {
          flagA = true;
        }
        if (cur.key == b) {
          flagB = true;
        }
        if (cur.left != null) {
          queue.offer(cur.left);
        }
        if (cur.right != null) {
          queue.offer(cur.right);
        }
        size--;
      }
      if (flagA && flagB) {
        return true;
      }
      if (flagA || flagB) {
        return false;
      }
    }
    return false;
  }
}
