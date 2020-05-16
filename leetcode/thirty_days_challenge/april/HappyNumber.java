package leetcode.thirty_days_challenge.april;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {
	
	public boolean isHappy(int n) {
		Set<Integer> set = new HashSet<Integer>();
		while (true) {
			if (n == 1) {
				return true;
			}
			if (!set.add(n)) {
				break;
			}
			n = returnSumOfSquareOfDigits(n);
		}
		return false;
	}

	private int returnSumOfSquareOfDigits(int n) {
		char[] cArr = new String("" + n).toCharArray();
		int sum = 0;
		for (char c : cArr) {
			int a = Character.getNumericValue(c);
			sum += a * a;
		}
		return sum;
	}

	public static void main(String[] args) {
		System.out.println(new HappyNumber().isHappy(1000090000));
	}

}
