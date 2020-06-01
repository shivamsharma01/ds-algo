package leetcode.Array101;

public class MergeSortedArrays {

	public static void main(String args[]) {
		int[] arr = new int[] { 1, 2, 3, 0, 0, 0 };
		new MergeSortedArrays().merge(arr, 6, new int[] { 2, 5, 6 }, 3);
		for (int i : arr)
			System.out.print(i + " "); // 1, 2, 2, 3, 5, 6,
	}

	public void merge(int[] nums1, int m, int[] nums2, int n) {
		int index = n + m;
		m--;
		n--;
		while (index-- > 0 && m >= 0 && n >= 0) {
			if (nums1[m] <= nums2[n])
				nums1[index] = nums2[n--];
			else
				nums1[index] = nums1[m--];
		}
		while (n >= 0)
			nums1[index--] = nums2[n--];
	}

}