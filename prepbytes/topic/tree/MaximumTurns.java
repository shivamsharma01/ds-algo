package prepbytes.topic.tree;

public class MaximumTurns extends BinaryTree {

	int findTurnCount(Node node) {
		return findTurnCount(node, 0, 'C');
	}

	int findTurnCount(Node node, int count, char previousTurn) {
		int left = count, right = count;
		if (node.left != null)
			left = findTurnCount(node.left, previousTurn == 'R' ? count + 1 : count, 'L');
		if (node.right != null)
			right = findTurnCount(node.right, previousTurn == 'L' ? count + 1 : count, 'R');
		return Math.max(left, right);
	}

	public static void main(String[] args) {
		MaximumTurns bt = new MaximumTurns();
		bt.root = bt.createTreeByLevelTree();
		bt.root = bt.replaceNegativeOne(bt.root);
		System.out.println(bt.findTurnCount(bt.root));
		bt.deleteTree(bt.root);
	}

}
