package leetcode.thirty_days_challenge.april;

public class BSTFromPreorder {
	// Definition for a binary tree node.
	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public TreeNode bstFromPreorder(int[] preorder) {
		TreeNode node = null;
		for (int i = 0; i < preorder.length; i++) {
			node = addNode(node, preorder[i]);
		}
		return node;
	}

	public TreeNode addNode(TreeNode root, int value) {
		if (root == null)
			return new TreeNode(value);
		else if (root.val > value)
			root.left = addNode(root.left, value);
		else
			root.right = addNode(root.right, value);
		return root;
	}
}
