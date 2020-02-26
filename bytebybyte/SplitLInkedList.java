package bytebybyte;

public class SplitLInkedList {
	public static void main(String[] args) {
		Node root = new Node();
		root.value = 1;
		root.next = new Node();
		root.next.value = 2;
		root.next.next = new Node();
		root.next.next.value = 3;
		root.next.next.next = new Node();
		root.next.next.next.value = 4;
		root.next.next.next.next = new Node();
		root.next.next.next.next.value = 5;
		root.next.next.next.next.next = new Node();
		root.next.next.next.next.next.value = 6;
		root.next.next.next.next.next.next = new Node();
		root.next.next.next.next.next.next.value = 7;
		root.next.next.next.next.next.next.next = new Node();
		root.next.next.next.next.next.next.next.value = 8;
		System.out.println("printing full list");
		printLinkedList(root);
		Node next = divide(root);
		System.out.println("\nprinting first split");
		printLinkedList(root);
		System.out.println("\nrinting second split");
		printLinkedList(next);
	}

	private static void printLinkedList(Node root) {
		while (root != null) {
			System.out.print(root.value + "\t");
			root = root.next;
		}
	}

	private static Node divide(Node list) {
		if (list == null) {
			return null;
		}
		Node runner = list.next;
		while (runner != null) {
			runner = runner.next;
			if (runner == null)
				break;
				runner = runner.next;
			list = list.next;
		}
		Node nextList = list.next;
		list.next = null;
		return nextList;

	}

	static class Node {
		private int value;
		private Node next;
	}

}
