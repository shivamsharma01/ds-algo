package prepbytes.topic.tree;

public class PostorderTraversal extends BinaryTree {

	void postOrderTraversal(Node node) {
		if (node == null)
			return;
		postOrderTraversal(node.left);
		postOrderTraversal(node.right);
		System.out.print(node.value + " ");
	}

	public static void main(String[] args) {
		PostorderTraversal bt = new PostorderTraversal();
		bt.root = bt.createTreeByLevelTree();
		bt.root = bt.replaceNegativeOne(bt.root);
		bt.postOrderTraversal(bt.root);
		bt.deleteTree(bt.root);
	}

}
