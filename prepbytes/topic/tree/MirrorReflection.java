package prepbytes.topic.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class MirrorReflection extends BinaryTree {

	boolean checkMirrorTree(Node node1, Node node2) {
		Queue<Long> q1 = new LinkedList<Long>();
		Queue<Long> q2 = new LinkedList<Long>();
		addNodes1(node1, q1);
		addNodes2(node2, q2);
		if (q1.size() != q2.size())
			return false;
		while (!q1.isEmpty()) {
			if (q1.remove() != q2.remove())
				return false;
		}
		return true;
	}

	void addNodes1(Node n, Queue<Long> q) {
		if (n == null)
			return;
		if (n.left != null)
			addNodes1(n.left, q);
		else
			q.add(n.value);
		addNodes1(n.right, q);
	}

	void addNodes2(Node n, Queue<Long> q) {
		if (n == null)
			return;
		if (n.right != null)
			addNodes2(n.right, q);
		else
			q.add(n.value);
		addNodes2(n.left, q);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		MirrorReflection bt = new MirrorReflection();
		bt.root = bt.createTreeByLevelTree(sc);
		bt.root = bt.replaceNegativeOne(bt.root);
		BinaryTree bt1 = new BinaryTree();
		bt1.root = bt1.createTreeByLevelTree(sc);
		bt1.root = bt1.replaceNegativeOne(bt1.root);
		if (bt.checkMirrorTree(bt.root, bt1.root))
			System.out.println("true");
		else
			System.out.println("false");
		bt.deleteTree(bt.root);
	}

}
