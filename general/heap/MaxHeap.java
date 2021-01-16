package general.heap;

public class MaxHeap implements Heap {
	public final int[] heap;
	public final int maxSize;
	public int size;

	MaxHeap(int maxSize) {
		this.maxSize = maxSize;
		this.heap = new int[maxSize + 1];
		heap[0] = Integer.MAX_VALUE;
	}

	@Override
	public void printHeap() {
		for (int i = 1; i <= size; i++)
			System.out.print(heap[i] + " ");
		System.out.println();
	}

	@Override
	public void insert(int element) {
		heap[++size] = element;
		heapifyHeight(size);
	}

	private void heapifyHeight(int index) {
		while (index > 1 && heap[index] > heap[index >> 1]) {
			swap(index, index >> 1);
			index >>= 1;
		}
	}

	/*
	 * O(n)
	 */
	@Override
	public void buildHeap() {
		int lastIndexWithChild = size / 2;
		for (; lastIndexWithChild >= 0; lastIndexWithChild--)
			maxHeapify(lastIndexWithChild);
	}

	boolean isLeaf(int i) {
		return i > size / 2 && i <= size;
	}

	/*
	 * O(logn)
	 */
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

	private int extractMax() throws Exception {
		if (size == 0)
			throw new Exception("Underflow");
		int max = heap[1];
		heap[1] = heap[size];
		size--;
		maxHeapify(1);
		return max;
	}

	@Override
	public void insertKey(int key, int index) {
		if (key < heap[index]) {
			System.out.println("Key cannot be less than " + heap[index]);
			return;
		}
		heap[index] = key;
		heapifyHeight(index);
	}

	@Override
	public int extract() throws Exception {
		return extractMax();
	}

	public void heapSort() {
		buildHeap();
		int originalSize = size;
		for (int i = originalSize; i >= 2; i--) {
			swap(i, 1);
			size--;
			maxHeapify(1);
		}
		size = originalSize;
	}

}
