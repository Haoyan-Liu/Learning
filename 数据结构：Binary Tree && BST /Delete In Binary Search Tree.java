public class Solution {
  public TreeNode deleteTree(TreeNode root, int key) {
    // Write your solution here
    if (root == null) {
      return root;
    }
    if (root.key > key) {
      root.left = deleteTree(root.left, key);
    }
    else if (root.key < key) {
      root.right = deleteTree(root.right, key);
    }
    else { // 找到了
      // case 1: 被删除的node没有左右子树
      // case 2: 被删除的node没有左子树，只有右子树
      if (root.left == null) {
        return root.right;
      }
      // case 3: 被删除的node没有右子树，只有左子树
      else if (root.right == null) {
        return root.left;
      }
      // case 4: 被删除的node左右都有子树
      // 左子树最右下角的node或者右子树最左下角的node
      // laicode只接受右子树最小值
      else {
        // 使用右子树的最小节点替换当前节点
        root.key = findMin(root.right).key;
        // 递归删除该最小节点
        root.right = deleteTree(root.right, root.key);
      }
    }
    return root;
  }
  // 找到右子树中最小的节点（即右子树的最左节点）
  private TreeNode findMin(TreeNode root) {
    while (root.left != null) {
      root = root.left;
    }
    return root;
  }
}
