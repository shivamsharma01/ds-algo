package leetcode.thirty_days_challenge;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}

public class DiameterOfBinaryTree {
	public int max = 0;

	public int diameterOfBinaryTree(TreeNode root) {
		getMax(root);
		return max;
	}

	private int getMax(TreeNode node) {
		if (node == null)
			return 0;
		int left = getMax(node.left);
		int right = getMax(node.right);
		if (max < (left + right)) {
			max = left + right;
		}
		return 1 + Math.max(left, right);
	}
}
