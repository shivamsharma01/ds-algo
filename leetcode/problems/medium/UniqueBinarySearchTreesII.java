package leetcode.problems.medium;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/unique-binary-search-trees-ii/
public class UniqueBinarySearchTreesII {

	public static void main(String[] args) {
		UniqueBinarySearchTreesII o = new UniqueBinarySearchTreesII();
		o.generateTrees(3);
	}

	public List<TreeNode> generateTrees(int n) {
		List<TreeNode> list = new ArrayList<>();
		List<Integer> nums = new ArrayList<>();
		for (int i = 1; i <= n; i++) {
			nums.add(new Integer(i));
			generate(list, nums, new TreeNode(i), n);
			nums.remove(new Integer(i));
		}
		for (TreeNode t : list) {
			print(t);
			System.out.println();
		}
		System.out.println(list.size());
		return list;
	}

	public static void print(TreeNode t) {
		if (t == null)
			return;
		System.out.print(t.val + "  ");
		print(t.left);
		print(t.right);
	}

	private void generate(List<TreeNode> list, List<Integer> done, TreeNode t, int n) {
		if (done.size() == n) {
			list.add(t);
			return;
		}
		TreeNode cur;
		for (int i = t.val + 1; i <= n; i++) {
			if (done.contains(i))
				continue;
			done.add(new Integer(i));
			cur = new TreeNode(i);
			cur.left = t;
			generate(list, done, cur, n);
			done.remove(new Integer(i));
		}
		for (int i = 1; i <= t.val - 1; i++) {
			if (done.contains(i))
				continue;
			done.add(new Integer(i));
			cur = new TreeNode(i);
			cur.right = t;
			generate(list, done, cur, n);
			done.remove(new Integer(i));
		}
	}
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}
