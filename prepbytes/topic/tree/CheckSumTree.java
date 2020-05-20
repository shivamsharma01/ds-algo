package prepbytes.topic.tree;

public class CheckSumTree extends BinaryTree {

	boolean checkSumTree(Node node) {
		if (node == null)
			return true;
		int sum = 0;
		if (checkSumTree(node.left) && checkSumTree(node.right)) {
			if (node.left != null)
				sum += node.left.value;
			if (node.right != null)
				sum += node.right.value;
			if (node.value == sum || sum == 0) {
				node.value = node.value + sum;
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		CheckSumTree bt = new CheckSumTree();
		bt.root = bt.createTreeByLevelTree();
		bt.root = bt.replaceNegativeOne(bt.root);
		if (bt.checkSumTree(bt.root) == true)
			System.out.println("true");
		else
			System.out.println("false");
		bt.deleteTree(bt.root);
	}

}
