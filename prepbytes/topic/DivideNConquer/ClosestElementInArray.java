package prepbytes.topic.DivideNConquer;

/*
 * O(logn)
 */
public class ClosestElementInArray {
	public static void main(String[] args) {
		int[] arr = new int[] { 1, 3, 5, 7, 9 };
		System.out.println(findClosest(arr, 3));
	}

	private static int findClosest(int[] arr, int target) {
		int left = 0, right = arr.length - 1;
		if (target < arr[left])
			return arr[left];
		if (target > arr[right])
			return arr[right];
		int middle = left + (right - left) / 2;
		while (left < right) {
			if (arr[middle] == target)
				return arr[middle];
			else if (target < arr[middle]) {
				if (middle > 0 && target >= arr[middle - 1]) {
					if (arr[middle] - target < target - arr[middle - 1])
						return arr[middle];
					else
						return arr[middle - 1];
				}
				right = middle - 1;
			} else {
				if (middle < arr.length - 1 && target <= arr[middle + 1]) {
					if (target - arr[middle] < arr[middle + 1] - target)
						return arr[middle];
					else
						return arr[middle + 1];
				}
				left = middle + 1;
			}
			middle = left + (right - left) / 2;
		}
		return middle;
	}

}
