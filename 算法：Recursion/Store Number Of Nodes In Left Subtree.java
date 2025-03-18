/**
 * public class TreeNodeLeft {
 *   public int key;
 *   public TreeNodeLeft left;
 *   public TreeNodeLeft right;
 *   public int numNodesLeft;
 *   public TreeNodeLeft(int key) {
 *     this.key = key;
 *   }
 * }
 */
public class Solution {
  public void numNodesLeft(TreeNodeLeft root) {
    // Write your solution here
    numNode(root);
  }

  private int numNode(TreeNodeLeft root) {
    if (root == null) {
      return 0;
    }
    int left = numNode(root.left);
    int right = numNode(root.right);
    root.numNodesLeft = left;
    return left + right + 1;
  }
}
