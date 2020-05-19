package general.ds;

public class QueueArray {
	static class Queue {
		int[] arr;
		int size = 5, front = -1, rear = -1;

		Queue() {
			arr = new int[this.size];
		}

		Queue(int size) {
			this.size = size;
			arr = new int[this.size];
		}

		public void enqueue(int item) {
			rear = ++rear % size;
			if (front == rear) {
				System.out.println("Queue is full");
				rear = (rear + size - 1) % size;
			} else {
				this.arr[rear] = item;
				front = front == -1 ? 0 : front;
			}
		}

		public int dequeue() {
			int val = -1;
			if (front == -1) {
				System.out.println("Queue is Empty");
			} else {
				val = arr[front];
				if (front == rear) {
					front = -1;
					rear = -1;
				} else {
					front = ++front % size;
				}
			}
			return val;
		}

	}

	public static void main(String[] args) {
		Queue q = new Queue();
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
		System.out.println("q.dequeue()");
		System.out.println(q.dequeue());
		System.out.println("q.dequeue()");
		System.out.println(q.dequeue());
		System.out.println("q.dequeue()");
		System.out.println(q.dequeue());
		System.out.println("q.dequeue()");
		System.out.println(q.dequeue());
		System.out.println("q.dequeue()");
		System.out.println(q.dequeue());
	}

}
