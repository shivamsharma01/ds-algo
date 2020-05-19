package prepbytes.topic.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class MirrorReflection {
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

		boolean checkMirrorTree(Node node1, Node node2) {
			Queue<Long> q1 = new LinkedList<Long>();
			Queue<Long> q2 = new LinkedList<Long>();
			addNodes1(node1, q1);
			addNodes2(node2, q2);
			if (q1.size() != q2.size())
				return false;
			while (!q1.isEmpty()) {
				if (q1.remove() != q2.remove())
					return false;
			}
			return true;
		}

		void addNodes1(Node n, Queue<Long> q) {
			if (n == null)
				return;
			if (n.left != null)
				addNodes1(n.left, q);
			else
				q.add(n.value);
			addNodes1(n.right, q);
		}

		void addNodes2(Node n, Queue<Long> q) {
			if (n == null)
				return;
			if (n.right != null)
				addNodes2(n.right, q);
			else
				q.add(n.value);
			addNodes2(n.left, q);
		}

	}

	public static void main(String[] args) {
		// write your code here
		Scanner sc = new Scanner(System.in);
		BinaryTree bt = new BinaryTree();
		bt.root = bt.createTreeByLevelTree(sc);
		bt.root = bt.replaceNegativeOne(bt.root);
		BinaryTree bt1 = new BinaryTree();
		bt1.root = bt1.createTreeByLevelTree(sc);
		bt1.root = bt1.replaceNegativeOne(bt1.root);
		if (bt.checkMirrorTree(bt.root, bt1.root))
			System.out.println("true");
		else
			System.out.println("false");
		bt.deleteTree(bt.root);
	}
}
