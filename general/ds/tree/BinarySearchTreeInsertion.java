package general.ds.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BinarySearchTreeInsertion {
	static class Node {
		int val;
		Node left;
		Node right;

		Node(int val) {
			this.val = val;
		}
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String[] input = scan.nextLine().split(" ");
		Node root = createBST(input);
		levelOrderTraversal(root);
		System.out.println();
		preOrderTraversal(root);
	}

	private static Node createBST(String[] object) {
		if (object == null || object.length == 0)
			return null;
		Node root = null;
		for (int i = 0; i < object.length; i++)
			root = insertNode(root, Integer.parseInt(object[i]));
		return root;
	}

	private static Node insertNode(Node root, int key) {
		Node node = new Node(key);
		if (root == null)
			return node;
		Node parent = null, cur = root;
		while (cur != null) {
			parent = cur;
			if (cur.val >= key)
				cur = cur.left;
			else
				cur = cur.right;
		}
		if (key <= parent.val)
			parent.left = node;
		else
			parent.right = node;
		return root;
	}

	private static void preOrderTraversal(Node node) {
		if (node == null)
			return;
		System.out.print(node.val + " ");
		preOrderTraversal(node.left);
		preOrderTraversal(node.right);
	}

	private static void levelOrderTraversal(Node node) {
		if (node == null)
			return;
		Queue<Node> queue = new LinkedList<>();
		queue.add(node);
		while (!queue.isEmpty()) {
			Node n = queue.remove();
			if (n == null)
				continue;
			System.out.print(n.val + " ");
			queue.add(n.left);
			queue.add(n.right);
		}
	}

}
