package prepbytes.topic.tree;

public class InorderTraversal extends BinaryTree {

	void inOrderTraversal(Node t) {
		if (t == null)
			return;
		inOrderTraversal(t.left);
		System.out.print(t.value + " ");
		inOrderTraversal(t.right);
	}

	public static void main(String[] args) {
		InorderTraversal bt = new InorderTraversal();
		bt.root = bt.createTreeByLevelTree();
		bt.root = bt.replaceNegativeOne(bt.root);
		bt.inOrderTraversal(bt.root);
		bt.deleteTree(bt.root);
	}

}
