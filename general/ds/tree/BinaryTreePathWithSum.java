package general.ds.tree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePathWithSum {
	static class Node {
		int val;
		Node left;
		Node right;

		Node(int val) {
			this.val = val;
		}
	}

	public static void main(String[] args) {
		Node root = new Node(5);
		root.left = new Node(3);
		root.left.right = new Node(4);
		root.right = new Node(8);
		root.right.left = new Node(6);
		root.right.right = new Node(10);
		List<Integer> list = new ArrayList<>();
		int sum = 19;
		if (isPathWithSum(root, list, sum)) {
			System.out.println("Path with sum " + sum + " is ");
			list.forEach(i -> System.out.print(i + " "));
		}

	}

	private static boolean isPathWithSum(Node root, List<Integer> list, int sum) {
		if (root == null)
			return false;
		if (root.left == null && root.right == null && root.val == sum) {
			list.add(root.val);
			return true;
		}
		list.add(root.val);
		if (isPathWithSum(root.left, list, sum - root.val))
			return true;
		else if (isPathWithSum(root.right, list, sum - root.val))
			return true;
		list.remove(new Integer(root.val));
		return false;
	}
}
