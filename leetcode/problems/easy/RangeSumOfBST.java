package leetcode.problems.easy;

// https://leetcode.com/problems/range-sum-of-bst/
public class RangeSumOfBST {
	// Definition for a binary tree node.
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
		// System.out.println(new RangeSumOfBST().rangeSumBST([10,5,15,3,7,null,18], 7,
		// 15)); // 32
	}

	public int rangeSumBST(TreeNode root, int L, int R) {
		if (root == null)
			return 0;
		if (root.val < L)
			return rangeSumBST(root.right, L, R);
		else if (root.val > R)
			return rangeSumBST(root.left, L, R);
		else
			return root.val + rangeSumBST(root.left, L, R) + rangeSumBST(root.right, L, R);
	}

}
