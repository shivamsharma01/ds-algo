package leetcode.problems.easy;

// https://leetcode.com/problems/create-target-array-in-the-given-order/
public class SplitAStringInBalancedStrings {

	public static void main(String[] args) {
		System.out.println(new SplitAStringInBalancedStrings().balancedStringSplit("RLRRLLRLRL")); // 4 - {"RL", "RRLL",
																									// "RL", "RL"}
		System.out.println(new SplitAStringInBalancedStrings().balancedStringSplit("RLLLLRRRLR")); // 3 - {RLLLLRRRLR}
		System.out.println(new SplitAStringInBalancedStrings().balancedStringSplit("LLLLRRRR")); // 1 - {"LLLLRRRR"}
		System.out.println(new SplitAStringInBalancedStrings().balancedStringSplit("RLRRRLLRLL")); // 1 - {"RL",
																									// "RRRLLRLL"}
	}

	public int balancedStringSplit(String s) {
		char[] arr = s.toCharArray();
		short L = 0, R = 0, count = 0;
		for (char c : arr) {
			if (c == 'L')
				L++;
			else
				R++;
			if (L == R) {
				count++;
			}
		}
		return count;
	}

}
