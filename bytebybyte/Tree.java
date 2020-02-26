package bytebybyte;

public class Tree {
	Node root;

	static class Node {
		private int data;
		private Node left;
		private Node right;
		Node(int val) {
			this.data = val;
		}
	}
	public static void main(String[] args) {
		Tree tree = new Tree();
		int[] arr = { 1, 2, 3, 4 };
		tree.root = insertNodes(arr, tree.root, 0);
		printTree(tree.root);
	}

	public static Node insertNodes(int array[], Node root, int i) {
		if(i < array.length) {
		root = new Node(array[i]);
		root.left = insertNodes(array, root.left,i*2+1);
		root.right = insertNodes(array, root.right,i*2+2);
		}
		return root;
	}
	
	public static void printTree(Node n) {
		if(n == null) {
			return;
		}
		System.out.print(n.data+"\t");
		printTree(n.left);
		printTree(n.right);
	}
}
