package leetcode.thirty_days_challenge;

public class LastStone {
	public int lastStoneWeight(int[] stones) {
		buildHeap(stones);
		return lastStone(stones);
	}

	private static int lastStone(int[] arr) {
		if (arr.length == 1)
			return arr[0];
		else if (arr.length == 2)
			return Math.abs(arr[0] - arr[1]);
		int n = arr.length - 1;
		while (arr[1] != 0 || arr[2] != 0) {
			int max = extractMax(arr, n);
			int other = extractMax(arr, --n);
			insertInHeap(arr, max - other, n);
		}
		return arr[0];
	}

	private static int extractMax(int[] arr, int length) {
		int max = arr[0];
		arr[0] = arr[length];
		arr[length] = 0;
		heapify(arr, 0);
		return max;
	}

	private static void insertInHeap(int[] arr, int elem, int index) {
		arr[index] = elem;
		buildHeap(arr);
	}

	private static void buildHeap(int[] arr) {
		for (int i = (int) Math.floor(arr.length / 2) - 1; i > -1; i--) {
			heapify(arr, i);
		}
	}

	private static void heapify(int[] arr, int i) {
		int largest = i;
		int l = i * 2 + 1;
		int r = i * 2 + 2;
		if (l < arr.length && arr[l] > arr[largest]) {
			largest = l;
		}
		if (r < arr.length && arr[r] > arr[largest]) {
			largest = r;
		}
		if (largest != i) {
			int temp = arr[i];
			arr[i] = arr[largest];
			arr[largest] = temp;
			heapify(arr, largest);
		}
	}

}
