package prepbytes.marathon.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// incomplete
public class PrepbytesContest {

	static class Node {
		int value;
		Node left, right;

		public Node(int item) {
			value = item;
			left = right = null;
		}
	}

	static class BinaryTree {
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

		void inOrderTraversal(Node node) {

			// write your code here
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

		/*
		 * Complete the function SecondMin() given below. For your reference: class Node
		 * { int value; Node left, right; public Node(int item) { value = item; left =
		 * right = null; } }
		 */
		int[] arr = new int[500000 + 1];

		void SecondMin(Node root) {
			int min = -1;
			// update each parent with min children score
			min(root);
			// to find second min
			for (int i = 1; i < arr.length; i++) {
				if (arr[i] == 0)
					continue;
				else {
					if (min == -1)
						min = i;
					else {
						min = i;
						break;
					}
				}
			}
			System.out.println(min);
			// get the height of tree for level order
			int height = height(root);
			// print in level order
			for (int i = 1; i <= height; i++) {
				printLevel(root, i);
				System.out.print("$ ");
			}
		}

		void printLevel(Node root, int height) {
			if (root == null)
				return;
			else if (height == 1)
				System.out.print(root.value + " ");
			else if (height > 1) {
				printLevel(root.left, height - 1);
				printLevel(root.right, height - 1);
			}
		}

		void min(Node root) {
			if (root == null)
				return;
			if (root.left == null && root.right == null) {
				arr[root.value]++;
				return;
			}
			min(root.left);
			min(root.right);
			int left = root.left != null ? root.left.value : Integer.MAX_VALUE,
					right = root.right != null ? root.right.value : Integer.MAX_VALUE;
			root.value = Math.min(root.value, Math.min(left, right));
			arr[root.value]++;
		}

		int height(Node root) {
			if (root == null)
				return 0;
			return 1 + Math.max(height(root.left), height(root.right));
		}
	}

	public static void main(String[] args) {
		// write your code here

		BinaryTree bt = new BinaryTree();
		bt.root = bt.createTreeByLevelTree();
		bt.root = bt.replaceNegativeOne(bt.root);
		bt.SecondMin(bt.root);

	}
}
