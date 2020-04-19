package leetcode.thirty_days_challenge;

public class RotatedSortedArray {
	public int search(int[] nums, int target) {
		return binarySearch(nums, 0, nums.length - 1, target);
	}

	private int binarySearch(int[] arr, int left, int right, int target) {
		if (left > right) {
			return -1;
		}
		int middle = (right + left) / 2;
		if (arr[middle] == target)
			return middle;
		else if (arr[middle] <= arr[right]) {
			if (target > arr[middle] && target <= arr[right]) {
				return binarySearch(arr, middle + 1, right, target);
			} else {
				return binarySearch(arr, left, middle - 1, target);
			}
		} else {
			if (target < arr[middle] && target >= arr[left]) {
				return binarySearch(arr, left, middle - 1, target);
			} else {
				return binarySearch(arr, middle + 1, right, target);
			}
		}
	}

}
