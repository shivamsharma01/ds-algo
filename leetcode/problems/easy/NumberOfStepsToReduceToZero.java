package leetcode.problems.easy;

// https://leetcode.com/problems/number-of-steps-to-reduce-a-number-to-zero/
public class NumberOfStepsToReduceToZero {
	public static void main(String[] args) {
		System.out.println(new NumberOfStepsToReduceToZero().numberOfSteps(14));
	}

	public int numberOfSteps(int num) {
		int count = 0;
		while (num != 0) {
			count++;
			if (num % 2 == 0)
				num /= 2;
			else
				num -= 1;
		}
		return count;
	}
}
