package leetcode.problems.easy;

import java.util.Arrays;

// https://leetcode.com/problems/create-target-array-in-the-given-order/
public class CreateTargetArrayInTheGivenOrder {

	public static void main(String[] args) {
		System.out.println(new CreateTargetArrayInTheGivenOrder().createTargetArray(new int[] { 0, 1, 2, 3, 4 },
				new int[] { 0, 1, 2, 2, 1 })); // 0, 4, 1, 3, 2
	}

	public int[] createTargetArray(int[] nums, int[] index) {
		int[] tArray = new int[nums.length];
		Arrays.fill(tArray, -1);
		for (int i = 0, j, t1, t2; i < nums.length; i++) {
			j = index[i];
			if (tArray[j] == -1) {
				tArray[j] = nums[i];
			} else {
				t1 = tArray[j];
				tArray[j] = nums[i];
				while (++j < nums.length && tArray[j] != -1) {
					t2 = tArray[j];
					tArray[j] = t1;
					t1 = t2;
				}
				tArray[j] = t1;
			}
		}
		return tArray;
	}

}
