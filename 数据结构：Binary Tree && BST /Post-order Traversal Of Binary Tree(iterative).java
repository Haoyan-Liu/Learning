// method 1：先pre-order再reverse result（offline解法，必须等pre-order结束再一次性反转）
// method 2：沿着左子树一直入栈，遇到null开始判断栈顶节点状态，如果该节点无右子树或者右子树已被完全访问，则访问该节点弹栈并更新访问指针pre，否则进入右子树（online解法，可以边走边打印）
public class Solution {
  public List<Integer> postOrder(TreeNode root) {
    // Write your solution here
    List<Integer> res = new ArrayList<Integer>();
    if (root ==null) {
      return res;
    }

    Deque<TreeNode> stack = new ArrayDeque<>();
    TreeNode pre = null; // 指向上一个已访问的节点
    TreeNode cur = root;

    while(cur != null || !stack.isEmpty()) {
      // 向左压栈直到叶子结点
      while(cur != null) {
        stack.offerFirst(cur);
        cur = cur.left;
      }

      // 先看一下栈顶，不弹栈
      cur = stack.peekFirst();

      // 判断栈顶状态，如果右子树为空 或者 右子树已访问，则访问（加入结果集并弹栈）该节点，并更新pre
      if (cur.right == null || cur.right == pre) {
        res.add(cur.key); // 访问该节点加入结果集
        stack.pollFirst(); // 弹栈
        pre = cur; // 更新访问指针
        cur = null; //避免重复访问
      }
      // 否则 进入右子树
      else {
        cur = cur.right;
      }
    }
    return res;
  }
}
