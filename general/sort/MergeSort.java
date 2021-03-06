package general.sort;

/*
 * O(nlogn)
 * divide and conquer algo
 * out-of-place algo - O(n) extra space
 */
public class MergeSort {
	public static void main(String[] args) {
		int[] arr = new int[] { 5, 4, 3, 2, 1, 9, 8, 7, 6 };
		mergeSort(arr, 0, arr.length - 1);
		for (int i : arr) {
			System.out.print(i + "\t");
		}
	}

	private static void mergeSort(int[] arr, int left, int right) {
		if (left < right) {
			int middle = left + (right - left) / 2;
			mergeSort(arr, left, middle);
			mergeSort(arr, middle + 1, right);
			merge(arr, left, middle, right);
		}
	}

	private static void merge(int[] arr, int left, int middle, int right) {
		int[] t1 = new int[middle - left + 2];
		int[] t2 = new int[right - middle + 1];
		for (int i = 0; i <= middle - left; i++)
			t1[i] = arr[left + i];
		for (int i = 0; i < right - middle; i++)
			t2[i] = arr[middle + i + 1];
		t1[t1.length - 1] = Integer.MAX_VALUE;
		t2[t2.length - 1] = Integer.MAX_VALUE;
		int i1 = 0, i2 = 0;
		for (int i = left; i <= right; i++) {
			if (t1[i1] < t2[i2])
				arr[i] = t1[i1++];
			else
				arr[i] = t2[i2++];
		}
	}

}
