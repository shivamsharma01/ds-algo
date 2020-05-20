package prepbytes.topic.tree;

public class HeightOfTree extends BinaryTree {

	int calculateHeight(Node node) {
		if (node == null)
			return 0;
		else
			return 1 + Math.max(calculateHeight(node.left), calculateHeight(node.right));
	}

	public static void main(String[] args) {
		HeightOfTree bt = new HeightOfTree();
		bt.root = bt.createTreeByLevelTree();
		bt.root = bt.replaceNegativeOne(bt.root);
		System.out.println(bt.calculateHeight(bt.root));
		bt.deleteTree(bt.root);
	}

}
