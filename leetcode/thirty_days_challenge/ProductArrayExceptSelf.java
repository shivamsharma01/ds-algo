package leetcode.thirty_days_challenge;

import java.util.Arrays;

public class ProductArrayExceptSelf {
	public int[] productExceptSelf(int[] nums) {
		int[] product = new int[nums.length];
		Arrays.fill(product, 1);
		int temp = nums[0];
		for (int i = 1; i < nums.length; i++) {
			product[i] = temp;
			temp = temp * nums[i];
		}
		temp = 1;
		for (int i = nums.length - 1; i >= 0; i--) {
			product[i] = product[i] * temp;
			temp = temp * nums[i];
		}
		return product;
	}
}
