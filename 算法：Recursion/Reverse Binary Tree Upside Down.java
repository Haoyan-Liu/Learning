public class Solution {
  public TreeNode reverse(TreeNode root) {
    // Write your solution here
    if (root == null || root.left == null) {
      return root;
    }
    TreeNode newRoot = reverse(root.left);
    root.left.right = root.right;
    root.left.left = root;
    root.left = null;
    root.right = null;
    return newRoot;
  }
}
