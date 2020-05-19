package prepbytes.topic.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class CheckSumTree {
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
		 * Complete the function checkSumTree given below For your reference
		 * 
		 * class Node { long value; Node left, right; public Node(long item) { value =
		 * item; left = right = null; } }
		 */

		boolean checkSumTree(Node node) {
			if (node == null)
				return true;
			int sum = 0;
			if (checkSumTree(node.left) && checkSumTree(node.right)) {
				if (node.left != null)
					sum += node.left.value;
				if (node.right != null)
					sum += node.right.value;
				if (node.value == sum || sum == 0) {
					node.value = node.value + sum;
					return true;
				}
			}
			return false;
		}

	}

	public static void main(String[] args) {
		// write your code here
		BinaryTree bt = new BinaryTree();
		bt.root = bt.createTreeByLevelTree();
		bt.root = bt.replaceNegativeOne(bt.root);
		if (bt.checkSumTree(bt.root) == true)
			System.out.println("true");
		else
			System.out.println("false");
		bt.deleteTree(bt.root);
	}
}
