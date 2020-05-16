package leetcode.thirty_days_challenge.may;

public class SingleElementInSortedArray {
	public static void main(String[] args) {
		System.out.println(singleNonDuplicate(new int[] { 1, 1, 2, 3, 3, 4, 4, 8, 8 }));
		System.out.println(singleNonDuplicate(new int[] { 3, 3, 7, 7, 10, 11, 11 }));
		System.out.println(singleNonDuplicate(new int[] { 1, 1, 2, 3, 3, 4, 4, 8, 8, 9, 9 }));
		System.out.println(singleNonDuplicate(new int[] { 3, 3, 7, 7, 10, 10, 11, 11, 12 }));
		System.out.println(singleNonDuplicate(new int[] { 1, 3, 3, 7, 7, 10, 10, 11, 11 }));
	}

	public static int singleNonDuplicate(int[] nums) {
		int left = 0, right = nums.length, mid = 0;
		if (nums.length == 1)
			return nums[0];
		else if (nums[0] != nums[1])
			return nums[0];
		else if (nums[nums.length - 1] != nums[nums.length - 2])
			return nums[nums.length - 1];
		while (left <= right) {
			mid = left + (right - left) / 2;
			if (mid % 2 == 0) { // odd elements
				if (nums[mid] == nums[mid - 1])
					right = mid - 1;
				else {
					if (nums[mid] == nums[mid + 1])
						left = mid + 1;
					else
						return nums[mid];
				}
			} else { // even elements
				if (nums[mid] == nums[mid - 1])
					left = mid + 1;
				else {
					if (nums[mid] == nums[mid + 1])
						right = mid - 1;
					else
						return nums[mid];
				}
			}
		}
		return nums[mid];
	}

}
