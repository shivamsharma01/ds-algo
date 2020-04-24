package general.sort;

/*
 * O(n^2) even in best case
 * swaps are very less
 * after each iteration rightmost element in the range is sorted
 */
public class SelectionSort {
	public static void main(String[] args) {
		int[] arr = new int[] { 5, 4, 3, 2, 1, 9, 8, 7, 6 };
		selectionSort(arr);
		for (int i : arr) {
			System.out.print(i + "\t");
		}
	}

	private static void selectionSort(int[] arr) {
		int temp, minIndex;
		for (int i = 0; i < arr.length - 1; i++) {
			minIndex = i;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] < arr[minIndex]) {
					minIndex = j;
				}
			}
			temp = arr[i];
			arr[i] = arr[minIndex];
			arr[minIndex] = temp;
		}
	}

}
