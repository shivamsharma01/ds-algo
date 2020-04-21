package general.search;

public class BinarySearch {

	public static void main(String[] args) {
		int[] arr = new int[] { 1, 2, 3, 4, 5 };
		System.out.println(binarySearchIteration(arr, 2));
		System.out.println(binarySearchRecursion(arr, 0, arr.length - 1, 4));
	}

	private static int binarySearchRecursion(int[] arr, int left, int right, int target) {
		if (left > right) {
			return -1;
		}
		int middle = (right + left) / 2;
		if (arr[middle] == target)
			return middle;
		else if (arr[middle] > target)
			return binarySearchRecursion(arr, left, middle - 1, target);
		else
			return binarySearchRecursion(arr, middle + 1, right, target);
	}

	private static int binarySearchIteration(int[] arr, int target) {
		int left = 0, middle = 0, right = arr.length - 1;
		while (left <= right) {
			middle = (right + left) / 2;
			if (arr[middle] == target)
				return middle;
			else if (target > arr[middle])
				left = middle + 1;
			else
				right = middle - 1;
		}
		return middle;
	}

}
