package prepbytes.topic.tree;

import java.util.Scanner;

public class Ancestors extends BinaryTree {

	Node findLowestAncestor(Node node, int v1, int v2) {
		if (v2 < v1)
			return findLowestAncestor(node, v2, v1);
		if (node == null)
			return null;
		if (node.value > v1 && node.value < v2)
			return node;
		else if (node.value < v1)
			return findLowestAncestor(node.right, v1, v2);
		else if (node.value > v2)
			return findLowestAncestor(node.left, v1, v2);
		else
			return node;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Ancestors bt = new Ancestors();
		bt.root = bt.createTreeByLevelTree(sc);
		bt.root = bt.replaceNegativeOne(bt.root);
		int n1 = sc.nextInt();
		int n2 = sc.nextInt();
		Node val = bt.findLowestAncestor(bt.root, n1, n2);
		System.out.println(val.value);
		bt.deleteTree(bt.root);
	}

}
