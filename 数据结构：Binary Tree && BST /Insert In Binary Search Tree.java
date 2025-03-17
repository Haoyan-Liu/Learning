public class Solution {
  public TreeNode insert(TreeNode root, int key) {
    // Write your solution here
    if (root == null) return new TreeNode(key);
    if (root.key > key) {
      root.left = insert(root.left, key);
    }
    if (root.key < key) {
      root.right = insert(root.right, key);
    }
    return root;
  }
}

public class Solution {
  public TreeNode insert(TreeNode root, int key) {
    // If the tree is empty, return a new node
    if (root == null) {
      return new TreeNode(key);
    }

    TreeNode cur = root;
    while (root != null) {
      if (cur.key == key) {
        return root;  // Key already exists, no insertion
      } else if (cur.key > key) {
        if (cur.left == null) {
          cur.left = new TreeNode(key);
          return root;  // Inserted, return root
        } else {
          cur = cur.left;
        }
      } else {
        if (cur.right == null) {
          cur.right = new TreeNode(key);
          return root;  // Inserted, return root
        } else {
          cur = cur.right;
        }
      }
    }
    return root;
  }
}
