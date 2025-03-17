// TC：O(4^h) —> O(4 ^(logn)) —> O(2^(2logn)) —> O(2^(log(n^2))) —> O(n^2)
// SC：O(h)
public class Solution {
  public boolean isTweakedIdentical(TreeNode left, TreeNode right) {
    // Write your solution here
    if (left == null && right == null) {
      return true;
    } else if (left == null || right == null) {
      return false;
    } else if (left.key != right.key) {
      return false;
    }
    return isTweakedIdentical(left.left, right.left) && isTweakedIdentical(left.right, right.right)
    ||
    isTweakedIdentical(left.left, right.right) && isTweakedIdentical(left.right, right.left);
  }
}
