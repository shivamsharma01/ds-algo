package prepbytes.topic.tree;

import java.util.LinkedList;
import java.util.Queue;

public class ConvertSumTree extends BinaryTree {

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

	public static void main(String[] args) {
		ConvertSumTree bt = new ConvertSumTree();
		bt.root = bt.createTreeByLevelTree();
		bt.root = bt.replaceNegativeOne(bt.root);
		bt.convertToSumTree(bt.root);
		bt.printLevelOrder(bt.root);
		bt.deleteTree(bt.root);
	}

}
