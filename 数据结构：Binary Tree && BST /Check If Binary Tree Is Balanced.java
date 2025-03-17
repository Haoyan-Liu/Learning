// base
// balanced
// TC：每一层O(n)一共log(n)层
// SC：log(n)
// not balanced（糖葫芦）
// TC：O(n)
// SC：O(n)
public class Solution {
  public boolean isBalanced(TreeNode root) {
    // Write your solution here
    if (root == null) {
      return true;
    }
    int leftHeight = getHeight(root.left);
    int rightHeight = getHeight(root.right);
    if (Math.abs(leftHeight - rightHeight) > 1) {
      return false;
    }
    return isBalanced(root.left) && isBalanced(root.right);
  }

  private int getHeight(TreeNode root) {
    if (root == null) {
      return 0;
    }
    return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
  }
}

// Advanced
// TC：O(n)
// SC：O(h)
public class Solution {
  public boolean isBalanced(TreeNode root) {
    return checkHeight(root) != -1;
  }

  private int checkHeight(TreeNode root) {
    if (root == null) {
      return 0;
    }
    int leftHeight = checkHeight(root.left);
    if (leftHeight == -1) {
      return -1;
    } 
    int rightHeight = checkHeight(root.right);
    if (rightHeight == -1) {
      return -1;
    }
    if (Math.abs(leftHeight - rightHeight) > 1) {
      return -1;
    }
    return Math.max(leftHeight, rightHeight) + 1;
  }
}
