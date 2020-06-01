package leetcode.problems.easy;

// https://leetcode.com/problems/subtract-the-product-and-sum-of-digits-of-an-integer
public class SubtractProductAndSumOfDigitsOfInteger {

	public static void main(String[] args) {
		System.out.println(new SubtractProductAndSumOfDigitsOfInteger().subtractProductAndSum(243));
	}

	public int subtractProductAndSum(int n) {
		int sum = 0, product = 1, digit;
		while (n != 0) {
			digit = n % 10;
			sum += digit;
			product *= digit;
			n /= 10;
		}
		return product - sum;
	}
}
