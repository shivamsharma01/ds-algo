package general.heap;

import java.util.Scanner;

public class Heap {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		MaxHeap maxHeap = new MaxHeap(n);
		// 10
		// 1 17 10 13 8 15 9 2 3 6
		for (int i = 1; i <= n; i++)
			maxHeap.insert(scan.nextInt());
		maxHeap.buildHeap();
		maxHeap.printHeap();
	}

}

class MaxHeap {
	int[] heap;
	int maxSize;
	int size;

	MaxHeap(int maxSize) {
		this.maxSize = maxSize;
		heap = new int[maxSize + 1];
		heap[size] = Integer.MAX_VALUE;
	}

	public void printHeap() {
		for (int i = 1; i <= size; i++)
			System.out.print(heap[i] + " ");
		System.out.println();
	}

	void insert(int element) {
		heap[++size] = element;
	}

	void buildHeap() {
		int lastIndexWithChild = size / 2;
		for (; lastIndexWithChild >= 0; lastIndexWithChild--)
			maxHeapify(lastIndexWithChild);
	}

	boolean isLeaf(int i) {
		return i > size / 2 && i <= size;
	}

	private void maxHeapify(int i) {
		if (isLeaf(i))
			return;
		int leftChild = i << 1, rightChild = leftChild + 1;
		if (rightChild <= size) {
			if (heap[i] >= heap[leftChild] && heap[i] >= heap[rightChild])
				return;
		} else {
			if (heap[i] > heap[leftChild])
				return;
		}
		int largest = i;
		if (heap[leftChild] > heap[largest])
			largest = leftChild;
		if (rightChild <= size && heap[rightChild] > heap[largest])
			largest = rightChild;
		if (largest != i)
			swap(largest, i);
		maxHeapify(largest);
	}

	private void swap(int largest, int i) {
		int temp = heap[largest];
		heap[largest] = heap[i];
		heap[i] = temp;
	}

}