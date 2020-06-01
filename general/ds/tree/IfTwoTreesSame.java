package general.ds.tree;

public class IfTwoTreesSame {
	static class Node {
		int val;
		Node left;
		Node right;

		Node(int val) {
			this.val = val;
		}
	}

	public static void main(String[] args) {
		Node root1 = new Node(2);
		Node root2 = new Node(2);
		root1.left = new Node(1);
		root2.left = new Node(1);
		root1.right = new Node(3);
		root2.right = new Node(3);
		if (isSame(root1, root2))
			System.out.println("Both the binary trees are same");
		else
			System.out.println("Both the binary trees are different");
		root2.right.val = 4;
		if (isSame(root1, root2))
			System.out.println("Both the binary trees are same");
		else
			System.out.println("Both the binary trees are different");

	}

	public static boolean isSame(Node root1, Node root2) {
		if (root1 == null && root2 == null)
			return true;
		if (root1 == null || root2 == null)
			return false;
		return root1.val == root2.val && isSame(root1.left, root2.left) && isSame(root1.right, root2.right);
	}

}
