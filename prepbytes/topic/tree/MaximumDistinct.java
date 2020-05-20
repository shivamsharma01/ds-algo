package prepbytes.topic.tree;

public class MaximumDistinct extends BinaryTree {

	public static void main(String[] args) {
		MaximumDistinct bt = new MaximumDistinct();
		bt.root = bt.createTreeByLevelTree();
		bt.root = bt.replaceNegativeOne(bt.root);
		System.out.println(bt.findDistinctCount(bt.root));
		bt.deleteTree(bt.root);
	}

	int findDistinctCount(Node node) {
		long[] arr = new long[65];
		return findDistinctCount(node, arr, 0, 0);
	}

	int findDistinctCount(Node node, long[] arr, int i, int count) {
		if (node == null)
			return count;
		count++;
		arr[i] = node.value;
		for (int index = i - 1; index >= 0; index--) {
			if (arr[index] == node.value) {
				count--;
				break;
			}
		}
		int left = findDistinctCount(node.left, arr, i + 1, count);
		int right = findDistinctCount(node.right, arr, i + 1, count);
		return Math.max(left, right);
	}

}
