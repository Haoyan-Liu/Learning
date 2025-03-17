public class Solution {
  public TreeNode search(TreeNode root, int key) {
    // Write your solution here
    if (root == null || root.key == key) {
      return root;
    }
    return root.key > key ? search(root.left, key) : search(root.right, key);
  }
}

public class Solution {
  public TreeNode search(TreeNode root, int key) {
    // Write your solution here
    while (root != null) {
      if (root.key == key) {
        return root;
      } 
      else if (root.key > key) {
        root = root.left;
      } else {
        root = root.right;
      }
    }
    return null;
  }
}
