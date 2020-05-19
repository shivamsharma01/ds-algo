package prepbytes.topic.tree;

import java.util.LinkedList;
import java.util.Scanner;

public class SearchInBinarySearchTree {

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

		public static void main(String[] args) {
			// write your code here
			Scanner sc = new Scanner(System.in);
			BinaryTree bt = new BinaryTree();
			bt.root = bt.createTreeByLevelTree(sc);
			bt.root = bt.replaceNegativeOne(bt.root);
			int key = sc.nextInt();
			if (bt.searchInBST(bt.root, key) == null)
				System.out.println("No");
			else
				System.out.println("Yes");
			bt.deleteTree(bt.root);
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

		Node searchInBST(Node node, int key) {
			if (node == null)
				return null;
			else if (key == node.value)
				return node;
			else if (key < node.value)
				return searchInBST(node.left, key);
			else
				return searchInBST(node.right, key);
		}

	}

}
