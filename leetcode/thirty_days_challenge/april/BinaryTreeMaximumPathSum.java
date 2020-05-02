package leetcode.thirty_days_challenge;

public class BinaryTreeMaximumPathSum {
	int max = Integer.MIN_VALUE;

	/**
	 * Definition for a binary tree node.
	 */

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}

	public static void main(String[] args) {
		BinaryTreeMaximumPathSum o = new BinaryTreeMaximumPathSum();
		TreeNode root = new TreeNode(-10);
		root.left = new TreeNode(9);
		TreeNode twenty = new TreeNode(20);
		twenty.left = new TreeNode(15);
		twenty.right = new TreeNode(7);
		root.right = twenty;
		o.maxPathSum(root);
		System.out.println(o.max);

		o.max = Integer.MIN_VALUE;
		root = new TreeNode(5);
		root.left = new TreeNode(4);
		root.right = new TreeNode(8);
		root.left.left = new TreeNode(11);
		root.left.left.left = new TreeNode(7);
		root.left.left.right = new TreeNode(2);
		root.right.left = new TreeNode(13);
		root.right.right = new TreeNode(4);
		root.right.right.right = new TreeNode(1);
		o.max = o.maxPathSum(root);
		System.out.println(o.max);

		o.max = Integer.MIN_VALUE;
		root = new TreeNode(9);
		root.left = new TreeNode(6);
		root.right = new TreeNode(-3);
		root.right.left = new TreeNode(-6);
		root.right.right = new TreeNode(2);
		root.right.right.left = new TreeNode(2);
		root.right.right.left.left = new TreeNode(-6);
		root.right.right.left.left.left = new TreeNode(-6);
		root.right.right.left.right = new TreeNode(-6);
		o.max = o.maxPathSum(root);
		System.out.println(o.max);

	}

	public int maxPathSum(TreeNode root) {
		maxPath(root);
		return max;
	}

	public Integer maxPath(TreeNode root) {
		if (root == null)
			return null;
		Integer left = maxPath(root.left);
		Integer right = maxPath(root.right);
		if (left == null && right == null) {
			max = Math.max(root.val, max);
			return root.val;
		} else if (left == null) {
			if (right < 0)
				right = 0;
			max = Math.max(root.val + right, max);
			return root.val + right;
		} else if (right == null) {
			if (left < 0)
				left = 0;
			max = Math.max(root.val + left, max);
			return root.val + left;
		} else {
			if (right < 0)
				right = 0;
			if (left < 0)
				left = 0;
			max = Math.max(root.val + left + right, max);
			if (left > right)
				return root.val + left;
			else
				return root.val + right;
		}
	}

}
