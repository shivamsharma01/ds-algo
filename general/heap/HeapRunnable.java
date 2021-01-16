package general.heap;

import java.util.Scanner;

public class HeapRunnable {
	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		Heap maxHeap = new MaxHeap(n), minHeap = new MinHeap(n);
		MaxHeap heapSortAsc = new MaxHeap(n);
		MinHeap heapSortDesc = new MinHeap(n);
		// 10
		// 1 17 10 13 8 15 9 2 4 6
		for (int i = 1; i <= n; i++) {
			int elem = scan.nextInt();
			maxHeap.insert(elem);
			minHeap.insert(elem);
			heapSortAsc.insert(elem);
			heapSortDesc.insert(elem);
		}
		maxHeap(maxHeap, n);
		minHeap(minHeap, n);
		sortAsc(heapSortAsc, n);
		sortDesc(heapSortDesc, n);
	}

	private static void maxHeap(Heap maxHeap, int n) throws Exception {
		System.out.println("==============maxHeap================");
		maxHeap.buildHeap();
		System.out.println("Printing Max Heap");
		maxHeap.printHeap();
		System.out.println("After updating key = 3 at index 4 to 20 in maxHeap");
		maxHeap.insertKey(20, 4);
		System.out.println("Printing Max Heap");
		maxHeap.printHeap();
		System.out.println("Extract Max and print max heap");
		for (int i = 1; i < n; i++) {
			System.out.println("extracted max is -> " + maxHeap.extract());
			System.out.println("Printing Max Heap after removing max");
			maxHeap.printHeap();
		}
	}

	private static void minHeap(Heap minHeap, int n) throws Exception {
		System.out.println("=============minHeap=================");
		minHeap.buildHeap();
		System.out.println("Printing Min Heap");
		minHeap.printHeap();
		System.out.println("After updating key = 3 at index 4 to 20 in minHeap");
		minHeap.insertKey(3, 4);
		System.out.println("Printing Min Heap");
		minHeap.printHeap();
		System.out.println("Extract Min and print min heap");
		for (int i = 1; i < n; i++) {
			System.out.println("extracted min is -> " + minHeap.extract());
			System.out.println("Printing Min Heap after removing min");
			minHeap.printHeap();
		}

	}

	private static void sortAsc(MaxHeap heapSortAsc, int n) {
		System.out.println("=============sortAsc=================");
		heapSortAsc.heapSort();
		heapSortAsc.printHeap();
	}

	private static void sortDesc(Heap heapSortDesc, int n) {
		System.out.println("==============sortDesc================");
		heapSortDesc.heapSort();
		heapSortDesc.printHeap();

	}
}
