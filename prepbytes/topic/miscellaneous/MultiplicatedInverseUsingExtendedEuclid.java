package prepbytes.topic.miscellaneous;

public class MultiplicatedInverseUsingExtendedEuclid {
	static ExtendedEuclideanAlgo e = new ExtendedEuclideanAlgo();

	public static void main(String[] args) {
		int a = -2;
		int b = 3;
		int m = 1000000007;
		multiplicativeInverse(a, b, m);
//		a = 15;
//		b = 3;
//		m = 7;
//		multiplicativeInverse(a, b, m);
//		a = 1;
//		b = 2;
//		m = 1000000007;
//		multiplicativeInverse(a, b, m);
//		a = -2;
//		b = 3;
//		m = 1000000007;
//		multiplicativeInverse(a, b, m);
	}

	// (a/b)%m = (a%m * b^-1%m)%m
	private static void multiplicativeInverse(int a, int b, int m) {
		b = b % m;
		// returns gcd
		int result = e.extendedEuclidean(b, m);
		if (result != 1) {
			System.out.println(a + " and " + b + " are not co-primes");
		} else {
			// x contains the multiplicative inverse
			// x can be negative, we therefore use the formula (A%m +m)%m
			int inverseB = ((e.x1 % m) + m) % m;
			System.out.println("Multiplicative inverse of " + b + " w.r.t to mod(" + m + ") is " + inverseB);
			System.out.println("Modular Multiplicative inverse of (" + a + "/" + b + ")mod" + m + " is "
					+ ((((a % m) + m) % m) * (inverseB % m)) % m);
			System.out.println();
		}
	}
}
