// 沿着左子树一直入栈，遇到null开始弹栈访问栈顶node，尝试继续从node右节点继续沿左子树入栈
public class Solution {
  public List<Integer> inOrder(TreeNode root) {
    // Write your solution here
    List<Integer> res = new ArrayList<>();
    Deque<TreeNode> stack = new ArrayDeque<>();
    TreeNode cur = root;

    while(cur != null || !stack.isEmpty()) {
      while(cur != null) {
        stack.offerFirst(cur);
        cur = cur.left;
      }
      cur = stack.pollFirst();
      res.add(cur.key);
      cur = cur.right;
    }
    return res;
  }
}
