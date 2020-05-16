package prepbytes.topic.linkedlist;

import java.io.IOException;
import java.util.Scanner;

public class AddOneToTheNumber {

	static class Node {
		int val;
		Node next;

		public Node(int val) {
			this.val = val;
		}
	}

	public static void main(String args[]) throws IOException {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			char[] input = sc.next().toCharArray();
			Node root = new Node(input[0] - '0'), head = root;
			for (int i = 1; i < input.length; i++) {
				root.next = new Node(input[i] - '0');
				root = root.next;
			}
			System.out.println(Integer.parseInt(getNumber(head)) + 1);
		}
	}

	private static String getNumber(Node head) {
		String output = "";
		while (head != null) {
			output += head.val;
			head = head.next;
		}
		return output;
	}

}
