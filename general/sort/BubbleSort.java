package general.sort;

/*
 * O(n^2)
 * best case also O(n^2)
 */
		
public class BubbleSort {
	public static void main(String[] args) {
		int[] arr = new int[] { 5, 4, 3, 2, 1, 9, 8, 7, 6 };
		bubbleSort(arr);
		for (int i : arr) {
			System.out.print(i + "\t");
		}
	}

	private static void bubbleSort(int[] arr) {
		int temp;
		for (int i = arr.length - 1; i >= 1; i--) {
			for (int j = 0; j < i; j++) {
				if (arr[j] > arr[j + 1]) {
					temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}
	}

}
