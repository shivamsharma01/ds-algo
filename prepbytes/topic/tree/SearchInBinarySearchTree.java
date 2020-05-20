package prepbytes.topic.tree;

import java.util.Scanner;

public class SearchInBinarySearchTree extends BinaryTree {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		SearchInBinarySearchTree bt = new SearchInBinarySearchTree();
		bt.root = bt.createTreeByLevelTree(sc);
		bt.root = bt.replaceNegativeOne(bt.root);
		int key = sc.nextInt();
		if (bt.searchInBST(bt.root, key) == null)
			System.out.println("No");
		else
			System.out.println("Yes");
		bt.deleteTree(bt.root);
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
