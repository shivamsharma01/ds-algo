package leetcode.thirty_days_challenge.may;

public class CousinsInBinaryTree {
 // Definition for a binary tree node.
   static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
    public boolean isCousins(TreeNode root, int x, int y) {
        TreeNode parentX = new TreeNode(), parentY = new TreeNode();
        int heightX = getHeight(root, x, parentX);
        // System.out.println(heightX+" "+)
        int heightY = getHeight(root, y, parentY);
        if(heightX == heightY && parentX.val != parentY.val)
            return true;
        return false;
    }
    
    private int getHeight(TreeNode root, int val, TreeNode parent) {
        if(root == null)
            return -1;
        if(root.val == val)
            return 0;
        int left = getHeight(root.left, val, parent);
        if(left == 0){
            parent.val = root.val;
            return 1;
        } else if(left > 0) {
            return 1 + left;
        } else {
            int right = getHeight(root.right, val, parent);
            if(right == 0){
                parent.val = root.val;
                return 1;
            } else if(right > 0) {
                return 1 + right;
            }
        }
        return -1;
    }
    
}