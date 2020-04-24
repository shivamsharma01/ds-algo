package general.sort;

/*
 * O(n^2) worst case
 * O(n) best case - inner while executed once every time and condition fails
 * online algo - (not all input elements required at the start)
 */
public class InsertionSort {
	public static void main(String[] args) {
		int[] arr = new int[] { 5, 4, 3, 2, 1, 9, 8, 7, 6 };
		insertionSort(arr);
		for (int i : arr) {
			System.out.print(i + "\t");
		}
	}

	private static void insertionSort(int[] arr) {
		int element, j;
		for (int i = 1; i < arr.length; i++) {
			element = arr[i];
			j = i;
			while (j > 0 && arr[j - 1] > element)
				arr[j] = arr[--j];
			arr[j] = element;
		}
	}

}
