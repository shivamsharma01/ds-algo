package prepbytes.topic.tree;

import java.util.LinkedList;
import java.util.Queue;

public class StudentMarks extends BinaryTree {

	void findAverageLevel(Node node) {
		int n = 1, elements = 0, count = 0;
		double average = 0;
		Queue<Node> queue = new LinkedList<>();
		queue.add(node);
		while (!queue.isEmpty()) {
			Node r = queue.remove();
			count++;
			if (r == null) {
				if (count == n && elements > 0) {
					average /= elements;
					System.out.print(String.format("%.2f", average) + " ");
					n = elements * 2;
					count = 0;
					elements = 0;
					average = 0;
				}
				continue;
			}
			average += r.value;
			elements++;
			if (count == n && elements > 0) {
				average /= elements;
				System.out.print(String.format("%.2f", average) + " ");
				n = elements * 2;
				count = 0;
				elements = 0;
				average = 0;
			}
			queue.add(r.left);
			queue.add(r.right);
		}
	}

	public static void main(String[] args) {
		StudentMarks bt = new StudentMarks();
		bt.root = bt.createTreeByLevelTree();
		bt.root = bt.replaceNegativeOne(bt.root);
		bt.findAverageLevel(bt.root);
		bt.deleteTree(bt.root);
	}

}
