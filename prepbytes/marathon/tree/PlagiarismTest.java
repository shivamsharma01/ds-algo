package prepbytes.marathon.tree;

import java.util.LinkedList;
import java.util.Scanner;

public class PlagiarismTest {
	public static void main(String[] args) {
		// write your code here
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		BinaryTree bt = new BinaryTree();
		bt.root = bt.createTreeByLevelTree(sc);
		bt.root = bt.replaceNegativeOne(bt.root);

		int ans = bt.PlagiarismTest(bt.root, x);
		System.out.println(ans);

		bt.deleteTree(bt.root);
	}

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

		Node createTreeByLevelTree(Scanner sc) {

			int n, m;
			LinkedList<Node> queue = new LinkedList<>();
			Node t;
			root = null;
			while (sc.hasNext()) {
				n = sc.nextInt();
				if (queue.isEmpty()) {
					root = createNode(n);
					queue.add(root);
					continue;
				}
				m = sc.nextInt();
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

		static void inOrderTraversal(Node node) {

			// write your code here
			if (node == null)
				return;
			inOrderTraversal(node.left);
			System.out.print(node.value + " ");
			inOrderTraversal(node.right);
		}

		/*
		 * implementation
		 */
		int PlagiarismTest(Node root, int x) {
			if (root == null || root.value == x)
				return 0;
			return root.value + PlagiarismTest(root.left, x) + PlagiarismTest(root.right, x);
		}

	}
}
