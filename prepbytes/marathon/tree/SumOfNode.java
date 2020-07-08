package prepbytes.marathon.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SumOfNode {

	public static void main(String[] args) {
		// write your code here
		BinaryTree bt = new BinaryTree();
		bt.root = bt.createTreeByLevelTree();
		bt.root = bt.replaceNegativeOne(bt.root);
		int ans = bt.MaxSum(bt.root);
		System.out.print(ans);
	}

}

class Node {
	int value;
	Node left, right;

	public Node(int item) {
		value = item;
		left = right = null;
	}
}

class BinaryTree {
	Node root;

	BinaryTree() {
		root = null;
	}

	Node createNode(int value) {
		Node t = new Node(value);
		return t;
	}

	Node replaceNegativeOne(Node root) {
		if (root == null || (root.value == -1 && root.left == null && root.right == null)) {
			return null;
		}
		root.left = replaceNegativeOne(root.left);
		root.right = replaceNegativeOne(root.right);
		return root;
	}

	static void inOrderTraversal(Node node) {

		if (node == null)
			return;
		inOrderTraversal(node.left);
		System.out.print(node.value + " ");
		inOrderTraversal(node.right);

	}

	Node createTreeByLevelTree() {
		Scanner sc = new Scanner(System.in);
		int n, m;
		Queue<Node> queue = new LinkedList<>();
		Node t;
		root = null;
		while (sc.hasNext()) {
			n = sc.nextInt();
			if (queue.isEmpty()) {
				root = createNode(n);
				((LinkedList<Node>) queue).add(root);
				continue;
			}
			m = sc.nextInt();
			t = ((LinkedList<Node>) queue).peekFirst();
			((LinkedList<Node>) queue).pop();
			t.left = createNode(n);
			t.right = createNode(m);
			if (t.left.value != -1)
				((LinkedList<Node>) queue).add(t.left);
			if (t.right.value != -1)
				((LinkedList<Node>) queue).add(t.right);
			if (queue.isEmpty())
				break;
		}
		return root;
	}

	void deleteTree(Node node) {
		node = null;
	}

	// implement here
	int max = 0;

	int MaxSum(Node root) {
		MaxSum(root, 0);
		return max;
	}

	int MaxSum(Node root, int parent) {
		if (root == null)
			return parent;
		parent += root.value;
		int left = MaxSum(root.left, parent);
		int right = MaxSum(root.right, parent);
		max = Math.max(max, left + right - parent);
		return Math.max(left, right);
	}

}
