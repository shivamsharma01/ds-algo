package general.ds.tree;

public class BTAndBST {
	static class Node {
		int val;
		Node left;
		Node right;

		Node(int val) {
			this.val = val;
		}
	}

	public static void main(String[] args) {
		Node root = new Node(5);
		root.left = new Node(3);
		root.left.left = new Node(1);
		root.left.right = new Node(4);
		root.right = new Node(8);
		root.right.left = new Node(6);
		root.right.right = new Node(10);
		System.out.println(isBTBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE));
	}

	public static boolean isBTBST(Node root, int min, int max) {
		if (root == null)
			return true;
		if (root.val < min || root.val > max)
			return false;
		return isBTBST(root.left, min, root.val) && isBTBST(root.right, root.val, max);
	}

}
