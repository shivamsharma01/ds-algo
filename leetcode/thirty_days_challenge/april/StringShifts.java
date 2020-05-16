package leetcode.thirty_days_challenge.april;

public class StringShifts {
	public static void main(String[] args) {
		StringShifts s = new StringShifts();
		System.out.println(s.stringShift("12345678", new int[][] { { 1, 2 }, { 1, 2 }, { 1, 2 }, { 1, 2 }, { 1, 2 } }));
		System.out.println(s.stringShift("12345678", new int[][] { { 0, 2 }, { 0, 2 }, { 0, 2 }, { 0, 2 }, { 0, 2 } }));
	}

	public String stringShift(String s, int[][] shift) {
		int left = 0;
		int right = 0;
		int len = s.length();
		for (int[] ar : shift) {
			if (ar[0] == 0) {
				left += ar[1];
			} else {
				right += ar[1];
			}
		}
		left = left - right;
		if (left > 0) {
			left = left % len;
			return s.substring(left) + s.substring(0, left);
		} else {
			right = Math.abs(left);
			right = right % len;
			return s.substring(len - right) + s.substring(0, len - right);
		}
	}
}
