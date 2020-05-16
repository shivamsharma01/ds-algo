package leetcode.thirty_days_challenge.april;

public class CheckIfAStringIsAValidSequence {
	/**
	 * Definition for a binary tree node.
	 **/
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

	public boolean isValidSequence(TreeNode root, int[] arr) {
		return isValidSequence(root, arr, 0);
	}

	private boolean isValidSequence(TreeNode root, int[] arr, int index) {
		if (index == arr.length - 1) {
			if (root != null && root.val == arr[index] && root.left == null && root.right == null)
				return true;
			return false;
		}
		if (root == null || arr[index] != root.val)
			return false;
		if (isValidSequence(root.left, arr, index + 1))
			return true;
		else
			return isValidSequence(root.right, arr, index + 1);
	}
}
