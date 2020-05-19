package prepbytes.marathon.linkedlist;

import java.util.Scanner;

public class Third {
	static class SinglyLinkedList {
		char value;
		SinglyLinkedList next;

		SinglyLinkedList(char nodeData) {
			this.value = nodeData;
			this.next = null;
		}
	}

	static SinglyLinkedList ListDestruction(SinglyLinkedList list) {
		if (list == null || list.next == null)
			return list;
		SinglyLinkedList head = list, temp = list, prev = null;
		boolean isFound = true;
		while (isFound) {
			temp = head;
			prev = null;
			isFound = false;
			while (temp != null && temp.next != null) {
				if (temp.value == temp.next.value) {
					isFound = true;
					if (temp.next.next != null) {
						if (temp.next.next.value == temp.value) {
							temp.next = temp.next.next;
						} else {
							if (head == temp) {
								head = temp.next.next;
								temp = temp.next.next;
							} else {
								temp = temp.next.next;
							}
						}
					} else {
						if (prev != null)
							prev.next = null;
						temp = temp.next.next;
					}
				} else {
					if (prev != null) {
						prev.next = temp;
						temp = temp.next;
						prev = prev.next;
					} else {
						prev = temp;
						temp = temp.next;
					}
				}
			}
		}
		return head;
	}

	public static void main(String[] args) throws InterruptedException {
		Scanner sc = new Scanner(System.in);
		SinglyLinkedList s = new SinglyLinkedList('b');
		s.next = new SinglyLinkedList('d');
		s.next.next = new SinglyLinkedList('d');
		s.next.next.next = new SinglyLinkedList('b');
		s.next.next.next.next = new SinglyLinkedList('c');
		s.next.next.next.next.next = new SinglyLinkedList('g');
		s.next.next.next.next.next.next = new SinglyLinkedList('d');
		s.next.next.next.next.next.next.next = new SinglyLinkedList('g');
		s.next.next.next.next.next.next.next.next = new SinglyLinkedList('h');
		s.next.next.next.next.next.next.next.next.next = new SinglyLinkedList('g');
		s.next.next.next.next.next.next.next.next.next.next = new SinglyLinkedList('i');
		s.next.next.next.next.next.next.next.next.next.next.next = new SinglyLinkedList('i');
		s = ListDestruction(s);
		while (s != null) {
			System.out.print(s.value + " ");
			s = s.next;
		}

	}
}
