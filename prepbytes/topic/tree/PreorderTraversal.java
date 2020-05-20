package prepbytes.topic.tree;

public class PreorderTraversal extends BinaryTree {

	void preOrderTraversal(Node node) {
		if (node == null)
			return;
		System.out.print(node.value + " ");
		preOrderTraversal(node.left);
		preOrderTraversal(node.right);
	}

	public static void main(String[] args) {
		PreorderTraversal bt = new PreorderTraversal();
		bt.root = bt.createTreeByLevelTree();
		bt.root = bt.replaceNegativeOne(bt.root);
		bt.preOrderTraversal(bt.root);
		bt.deleteTree(bt.root);
	}

}
