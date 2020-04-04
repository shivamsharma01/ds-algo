package prepbytes.array;

import java.util.Scanner;

public class ArrayZigzag {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int[] nums = new int[n];
		long sumEven = 0;
		long sumOdd = 0;
		nums[0] = scan.nextInt();
		nums[1] = scan.nextInt();
		if (nums[0] >= nums[1]) {
			sumEven = nums[0] - nums[1] + 1;
		}
		int minAdjacent;
		int i;
		for (i = 2; i < nums.length; i++) {
			nums[i] = scan.nextInt();
			minAdjacent = Math.min(nums[i - 2], nums[i]);
			if (i % 2 == 0) {
				if (nums[i - 1] >= minAdjacent)
					sumOdd += nums[i - 1] - minAdjacent + 1;
			} else {
				if (nums[i - 1] >= minAdjacent)
					sumEven += nums[i - 1] - minAdjacent + 1;
			}
		}
		i = nums.length - 1;
		if (nums[i - 1] < nums[i]) {
			if (i % 2 == 0) {
				sumEven += nums[i] - nums[i - 1] + 1;
			} else {
				sumOdd += nums[i] - nums[i - 1] + 1;
			}
		}
		System.out.println(Math.min(sumEven, sumOdd));
	}

}
