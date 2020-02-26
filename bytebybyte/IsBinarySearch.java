package bytebybyte;

public class IsBinarySearch {
	public static void main(String[] args) {
//						1
//				2				3
//			4		5		6	

		Node root = new IsBinarySearch().new Node(5);
		Node one = new IsBinarySearch().new Node(1);
		Node two = new IsBinarySearch().new Node(2);
		Node three = new IsBinarySearch().new Node(3);
		Node four = new IsBinarySearch().new Node(4);
		Node six = new IsBinarySearch().new Node(6);
		root.left = three;
		root.right = six;
		three.left = one;
		three.right = four;
		boolean isBinary = isBinarySearchTree(root, Integer.MAX_VALUE, Integer.MIN_VALUE);
		System.out.println(isBinary ?"Is a binary Search Tree" : "Not a Binary Search Tree");
	}
	
	
	
	private static boolean isBinarySearchTree(Node root, int max, int min) {
		if (root == null) {
			return true;
		}
		if (!(root.value <= max && root.value > min)) {
			return false;
		}
		boolean isLeftBinarySearch = isBinarySearchTree(root.left, root.value, Integer.MIN_VALUE);
		boolean isRightBinarySearch = isBinarySearchTree(root.right, Integer.MAX_VALUE, root.value);
		return isLeftBinarySearch && isRightBinarySearch;
	}

	private class Node {
		private int value;
		private Node left;
		private Node right;

		Node(int val) {
			this.value = val;
		}
	}

}
