package general.sort;

/*
 * Choose a pivot - usually first or last element 
 * after each iteration pivot element is at the right index
 * best case - O(nlogn) when pivotIndex is always the middle of subarray
 * worst case - O(n^2) when array elements in ascending or descending order or duplicates
 */
public class QuickSort {
	public static void main(String[] args) {
		int[] arr = new int[] { 5, 4, 3, 2, 1, 9, 8, 7, 6 };
		quickSort(arr, 0, arr.length - 1);
		for (int i : arr) {
			System.out.print(i + "\t");
		}
	}

	private static void quickSort(int[] arr, int low, int high) {
		if (low < high) {
			int pivotIndex = partition(arr, low, high);
			quickSort(arr, low, pivotIndex - 1);
			quickSort(arr, pivotIndex + 1, high);
		}
	}

	// taking pivot the last element
	private static int partition(int[] arr, int low, int high) {
		int pivot = arr[high], i = low - 1, j;
		for (j = low; j < high; j++) {
			if (arr[j] <= pivot) {
				i++;
				swap(arr, i, j);
			}
		}
		swap(arr, i + 1, j);
		return i + 1;
	}

	private static void swap(int[] arr, int index1, int index2) {
		int temp;
		temp = arr[index1];
		arr[index1] = arr[index2];
		arr[index2] = temp;
	}
}
