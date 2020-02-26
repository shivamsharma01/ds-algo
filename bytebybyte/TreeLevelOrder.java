package bytebybyte;

import java.util.LinkedList;
import java.util.Queue;

public class TreeLevelOrder {
	public static void main(String[] args) {
		Node tree = new Node();
		tree.value = 4;
		tree.left = new Node();
		tree.left.value = 2;
		tree.left.left = new Node();
		tree.left.left.value = 1;
		tree.left.right = new Node();
		tree.left.right.value = 3;
		tree.right = new Node();
		tree.right.value = 5;
		printLevelOrderTraversal(tree);

	}

	private static void printLevelOrderTraversal(Node tree) {
		if (tree == null) {
			return;
		}
		Queue<Node> toVisit = new LinkedList();
		toVisit.add(tree);
		
		while (!toVisit.isEmpty()) {
			Node current = toVisit.remove();
			System.out.println(current.value);
			if (current.left != null) {
				toVisit.add(current.left);
			}
			if (current.right != null) {
				toVisit.add(current.right);
			}
		}
	}

	static class Node {
		private int value;
		private Node left;
		private Node right;
	}
}
