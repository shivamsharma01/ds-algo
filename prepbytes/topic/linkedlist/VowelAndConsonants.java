package prepbytes.topic.linkedlist;

import java.io.IOException;
import java.util.Scanner;

public class VowelAndConsonants {

	static class Node {
		char val;
		Node next;

		public Node(char val) {
			this.val = val;
		}
	}

	public static void main(String args[]) throws IOException {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			int n = sc.nextInt();
			Node root = new Node(sc.next().charAt(0)), head = root;
			for (int i = 1; i < n; i++) {
				root.next = new Node(sc.next().charAt(0));
				root = root.next;
			}
			head = getInOrder(head);
			while (head != null) {
				System.out.print(head.val + " ");
				head = head.next;
			}
			System.out.println();
		}
	}

	private static Node getInOrder(Node head) {
		Node vowel = null, vHead = null;
		Node consonent = null, vConsonent = null;
		while (head != null) {
			if (isChar(head.val)) {
				if (vowel != null) {
					vowel.next = new Node(head.val);
					vowel = vowel.next;
				} else {
					vHead = new Node(head.val);
					vowel = vHead;
				}
			} else {
				if (consonent != null) {
					consonent.next = new Node(head.val);
					consonent = consonent.next;
				} else {
					vConsonent = new Node(head.val);
					consonent = vConsonent;
				}
			}
			head = head.next;
		}
		if (vowel != null)
			vowel.next = vConsonent;
		return vHead != null ? vHead : vConsonent;
	}

	private static boolean isChar(char c) {
		if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')
			return true;
		return false;
	}

}
