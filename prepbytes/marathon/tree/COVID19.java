package prepbytes.marathon.tree;

import java.util.LinkedList;
import java.util.Scanner;

public class COVID19 {
	public static void main(String[] args) {
		// write your code here
		Scanner sc = new Scanner(System.in);
		BinaryTree bt = new BinaryTree();
		int key = sc.nextInt();
		bt.root = bt.createTreeByLevelTree(sc);
		bt.root = bt.replaceNegativeOne(bt.root);
		Node infected = bt.ifNodeExists(bt.root, key);
		System.out.println(bt.CovidTree(bt.root, infected));
		bt.deleteTree(bt.root);
	}

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

		Node createTreeByLevelTree(Scanner sc) {

			long n, m;
			LinkedList<Node> queue = new LinkedList<>();
			Node t;
			root = null;
			while (sc.hasNext()) {
				n = sc.nextLong();
				if (queue.isEmpty()) {
					root = createNode(n);
					queue.add(root);
					continue;
				}
				m = sc.nextLong();
				t = queue.peekFirst();
				queue.pop();
				t.left = createNode(n);
				t.right = createNode(m);
				if (t.left.value != -1)
					queue.add(t.left);
				if (t.right.value != -1)
					queue.add(t.right);
				if (queue.isEmpty()) {
					break;
				}

			}

			return root;
		}

		void deleteTree(Node node) {
			node = null;
		}

		Node ifNodeExists(Node node, int key) {
			if (node == null)
				return node;
			if (node.value == key)
				return node;

			Node temp = ifNodeExists(node.left, key);
			if (temp == null) {
				temp = ifNodeExists(node.right, key);
			}
			return temp;
		}

		/*
		 * Complete the function CovidTree given below For your reference
		 * 
		 * class Node { long value; Node left, right; public Node(long item) { value =
		 * item; left = right = null; } }
		 */
		boolean found = false;

		int CovidTree(Node root, Node infectedNode) {
			return CovidTree(root, infectedNode, 0);
		}

		int CovidTree(Node root, Node infectedNode, int parent) {
			found = false;
			if (root == null)
				return parent;
			if (root == infectedNode) {
				int height = Math.max(height(root.left), height(root.right));
				return Math.max(parent, height);
			}
			int left = height(root.left, infectedNode);
			if (found)
				return CovidTree(root.left, infectedNode, 1 + Math.max(parent, height(root.right)));
			else
				return CovidTree(root.right, infectedNode, 1 + Math.max(parent, left));
		}

		int height(Node root, Node infectedNode) {
			if (root == null)
				return 0;
			if (root == infectedNode)
				found = true;
			return 1 + Math.max(height(root.left, infectedNode), height(root.right, infectedNode));
		}

		int height(Node root) {
			if (root == null)
				return 0;
			return 1 + Math.max(height(root.left), height(root.right));
		}

	}
}
