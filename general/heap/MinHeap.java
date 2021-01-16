package general.heap;

public class MinHeap implements Heap {
	final int[] heap;
	final int maxSize;
	int size;

	MinHeap(int maxSize) {
		this.maxSize = maxSize;
		this.heap = new int[maxSize + 1];
		this.heap[0] = Integer.MIN_VALUE;
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

	private void heapifyHeight(int size) {
		while (size > 1 && heap[size] < heap[size >> 1]) {
			swap(size, size >> 1);
			size >>= 1;
		}
	}

	private void swap(int min, int i) {
		int temp = heap[min];
		heap[min] = heap[i];
		heap[i] = temp;
	}

	@Override
	public void buildHeap() {
		int lastIndexWithChild = size / 2;
		for (; lastIndexWithChild >= 1; lastIndexWithChild--) {
			minHeapify(lastIndexWithChild);
		}
	}

	@Override
	public int extract() throws Exception {
		return extractMin();
	}

	private int extractMin() throws Exception {
		if (size == 0)
			throw new Exception("Underflow");
		int min = heap[1];
		heap[1] = heap[size];
		size--;
		minHeapify(1);
		return min;
	}

	private void minHeapify(int i) {
		if (isLeaf(i))
			return;
		int leftChild = i * 2, rightChild = leftChild + 1;
		if (rightChild <= size) {
			if (heap[i] < heap[leftChild] && heap[i] < heap[rightChild])
				return;
		} else {
			if (heap[i] < heap[leftChild])
				return;
		}
		int min = i;
		if (heap[min] > heap[leftChild])
			min = leftChild;
		if (rightChild <= size && heap[min] > heap[rightChild])
			min = rightChild;
		swap(min, i);
		minHeapify(min);
	}

	private boolean isLeaf(int i) {
		return i > size / 2 && i <= size;
	}

	@Override
	public void insertKey(int key, int index) throws Exception {
		if (key > heap[index])
			throw new Exception("Key must be smaller than " + heap[index]);
		heap[index] = key;
		heapifyHeight(index);
	}

	public void heapSort() {
		buildHeap();
		int originalSize = size;
		for (int i = originalSize; i >= 2; i--) {
			swap(1, size);
			size--;
			minHeapify(1);
		}
		size = originalSize;
	}

}
