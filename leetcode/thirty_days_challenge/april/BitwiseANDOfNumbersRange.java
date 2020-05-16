package leetcode.thirty_days_challenge.april;

public class BitwiseANDOfNumbersRange {
	public static void main(String[] args) {
		System.out.println(rangeBitwiseAnd(2, 3));
	}

	public static int rangeBitwiseAnd(int m, int n) {
		if (m == 0 || n == 0)
			return 0;
		if (m == n)
			return m;
		int pow = (int) (Math.log10(Math.abs(m - n)) / Math.log10(2));
		StringBuilder sb = new StringBuilder(Integer.toBinaryString(m & n)).reverse();
		for (int i = 0; i <= pow; i++) {
			sb.replace(i, i + 1, "0");
		}
		return Integer.parseInt(sb.reverse().toString(), 2);
	}
}
