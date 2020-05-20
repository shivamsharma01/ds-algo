package prepbytes.topic.tree;

public class SizeOfTree extends BinaryTree {

	int calculateSize(Node node) {
		if (node == null)
			return 0;
		return 1 + calculateSize(node.left) + calculateSize(node.right);
	}

	public static void main(String[] args) {
		SizeOfTree bt = new SizeOfTree();
		bt.root = bt.createTreeByLevelTree();
		bt.root = bt.replaceNegativeOne(bt.root);
		System.out.println(bt.calculateSize(bt.root));
		bt.deleteTree(bt.root);
	}

}
