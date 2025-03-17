// 想象成两个stack实现一个不被击穿的deque更便于理解
public class Solution {
  public List<Integer> zigZag(TreeNode root) {
    // Write your solution here
    List<Integer> res = new ArrayList<>();
    if (root == null) return res;

    Deque<TreeNode> deque = new ArrayDeque<>();

    int layer = 0;
    deque.offerLast(root);

    while (!deque.isEmpty()) {
      int size = deque.size();
      while (size > 0) {
        if (layer == 0) {
          TreeNode cur = deque.pollLast();
          res.add(cur.key);
          if (cur.right != null) {
            deque.offerFirst(cur.right);
          }
          if (cur.left != null) {
            deque.offerFirst(cur.left);
          }
        }
        if (layer == 1) {
          TreeNode cur = deque.pollFirst();
          res.add(cur.key);
          if (cur.left != null) {
            deque.offerLast(cur.left);
          }
          if (cur.right != null) {
            deque.offerLast(cur.right);
          }
        }
        size--;
      }
      layer = 1 - layer;
    }
    return res;
  }
}
