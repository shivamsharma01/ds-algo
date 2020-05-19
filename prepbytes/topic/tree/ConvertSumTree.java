package prepbytes.topic.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ConvertSumTree {
	static class Node {
		long value;
		Node left, right;

		public Node(long item) {
			value = item;
			left = right = null;
		}
	}

	static class BinaryTree {
		Node root;

		BinaryTree() {
			root = null;
		}

		Node createNode(long value) {
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

		public void printLevelOrder(Node root) {
			if (root == null) {
				return;
			}
			Queue<Node> nodes = new LinkedList<>();
			nodes.add(root);
			while (!nodes.isEmpty()) {
				Node node = nodes.remove();
				System.out.print(node.value + " ");
				if (node.left != null) {
					nodes.add(node.left);
				}
				if (node.right != null) {
					nodes.add(node.right);
				}
			}
		}

		Node createTreeByLevelTree() {
			Scanner sc = new Scanner(System.in);
			long n, m;
			Queue<Node> queue = new LinkedList<>();
			Node t;
			root = null;
			while (sc.hasNext()) {
				n = sc.nextLong();
				if (queue.isEmpty()) {
					root = createNode(n);
					((LinkedList<Node>) queue).add(root);
					continue;
				}
				m = sc.nextLong();
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

		/*
		 * Complete the function convertToSumTree given below For your reference class
		 * Node { long value; Node left, right; public Node(long item) { value = item;
		 * left = right = null; } }
		 */

		long convertToSumTree(Node node) {
			if (node == null)
				return 0;
			long val = node.value, left = 0, right = 0;
			if (node.left != null)
				left = convertToSumTree(node.left);
			if (node.right != null)
				right = convertToSumTree(node.right);
			node.value = left + right;
			return node.value + val;
		}

	}

	public static void main(String[] args) {
		// write your code here
		BinaryTree bt = new BinaryTree();
		bt.root = bt.createTreeByLevelTree();
		bt.root = bt.replaceNegativeOne(bt.root);
		bt.convertToSumTree(bt.root);
		bt.printLevelOrder(bt.root);
		bt.deleteTree(bt.root);
	}
}
