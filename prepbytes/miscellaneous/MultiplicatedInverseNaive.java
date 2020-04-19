package prepbytes.miscellaneous;

public class MultiplicatedInverseNaive {
	public static void main(String[] args) {
		findMultiplicativeInverse(19, 13);
	}

	private static void findMultiplicativeInverse(int val, int m) {
		val = val % m;
		boolean isInverse = false;
		for (int i = 1; i < m; i++) {
			if (((val % m) * (i % m)) % m == 1) {
				isInverse = true;
				System.out.println("Multiplicative inverse of " + val + "%" + m + "==1 is " + i);
				break;
			}
		}
		if (!isInverse)
			System.out.println("Multiplicative inverse of " + val + "%" + m + "==1 does not exists");
	}
}
