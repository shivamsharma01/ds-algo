package general.ds;

public class QueueLinkedList {
	private Node queue, rear;

	static class Node {
		int val;
		Node next;

		Node(int val) {
			this.val = val;
		}
	}

	public void enqueue(int item) {
		Node n = new Node(item);
		if (rear != null) {
			rear.next = n;
			rear = rear.next;
		} else {
			queue = rear = n;
		}
	}

	public int dequeue() {
		int val = -1;
		if (queue == null) {
			System.out.println("Queue is empty");
		} else {
			val = queue.val;
			queue = queue.next;
			if (queue == null)
				rear = null;
		}
		return val;
	}

	public static void main(String[] args) {
		QueueLinkedList q = new QueueLinkedList();
		System.out.println("q.enqueue(1)");
		q.enqueue(1);
		System.out.println("q.enqueue(2)");
		q.enqueue(2);
		System.out.println("q.enqueue(3)");
		q.enqueue(3);
		System.out.println("q.enqueue(4)");
		q.enqueue(4);
		System.out.println("q.enqueue(5)");
		q.enqueue(5);
		System.out.println("q.enqueue(6)");
		q.enqueue(6);
		System.out.println("q.dequeue() 1");
		System.out.println(q.dequeue());
		System.out.println("q.dequeue() 2");
		System.out.println(q.dequeue());
		System.out.println("q.dequeue() 3");
		System.out.println(q.dequeue());
		System.out.println("q.dequeue() 4");
		System.out.println(q.dequeue());
		System.out.println("q.dequeue() 5");
		System.out.println(q.dequeue());
		System.out.println("q.dequeue() 6");
		System.out.println(q.dequeue());
		System.out.println("q.dequeue() 7");
		System.out.println(q.dequeue());
		System.out.println("q.enqueue(7)");
		q.enqueue(7);
		System.out.println("q.dequeue() 8");
		System.out.println(q.dequeue());
	}

}
