package general.search;

public class BinarySearch {

	public static void main(String[] args) {
		int[] arr = new int[] { 1, 2, 3, 4, 5 };
		System.out.println(binarySearch(arr, 0, arr.length - 1, 4));
		System.out.println(binarySearch(arr, 0, arr.length - 1, 6));
	}

	private static int binarySearch(int[] arr, int left, int right, int target) {
		if (left > right) {
			return -1;
		}
		int middle = (right + left) / 2;
		if (arr[middle] == target)
			return middle;
		else if (arr[middle] > target)
			return binarySearch(arr, left, middle - 1, target);
		else
			return binarySearch(arr, middle + 1, right, target);
	}

}
