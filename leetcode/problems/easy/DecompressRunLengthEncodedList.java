package leetcode.problems.easy;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/decompress-run-length-encoded-list
public class DecompressRunLengthEncodedList {

	public static void main(String[] args) {
		int[] arr = new DecompressRunLengthEncodedList().decompressRLElist(new int[] { 42, 39 });
		for (int i = 0; i < arr.length; i++)
			System.out.print(arr[i]);
	}

	public int[] decompressRLElist(int[] nums) {
		List<Integer> list = new ArrayList<>();
		int i = 0;
		while (i < nums.length) {
			while (nums[i]-- > 0)
				list.add(nums[i + 1]);
			i += 2;
		}
		return list.stream().mapToInt(e -> e.intValue()).toArray();
	}

}
