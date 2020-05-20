package leetcode.thirty_days_challenge.may;

//  Definition for a binary tree node.
class TreeNode {
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

public class KthSmallestElementBST {
	int val;

	public static void main(String[] args) {
		System.out.println(Integer.parseInt("null"));
	}

	public int kthSmallest(TreeNode root, int k) {
		kthSmallest(root, k, 0);
		return val;
	}

	public int kthSmallest(TreeNode root, int k, int count) {
		if (root.left != null) {
			count = kthSmallest(root.left, k, count);
			if (k == count) {
				return count;
			}
		}
		count++;
		if (k == count) {
			this.val = root.val;
			return count;
		}
		if (root.right != null) {
			count = kthSmallest(root.right, k, count);
			if (count == k) {
				return count;
			}
		}
		return count;
	}

}
