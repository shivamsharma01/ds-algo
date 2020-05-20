package prepbytes.topic.tree;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversal extends BinaryTree {

	void levelOrderTraversal(Node node) {
		if (node == null)
			return;
		Queue<Node> queue = new LinkedList<>();
		queue.add(node);
		while (!queue.isEmpty()) {
			Node n = queue.remove();
			if (n == null)
				continue;
			System.out.print(n.value + " ");
			queue.add(n.left);
			queue.add(n.right);
		}
	}

	public static void main(String[] args) {
		LevelOrderTraversal bt = new LevelOrderTraversal();
		bt.root = bt.createTreeByLevelTree();
		bt.root = bt.replaceNegativeOne(bt.root);
		bt.levelOrderTraversal(bt.root);
		bt.deleteTree(bt.root);
	}

}
