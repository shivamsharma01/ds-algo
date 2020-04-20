package prepbytes.topic.maths;

import java.math.BigInteger;
import java.util.Scanner;

public class RamboNumbers {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		byte t = scan.nextByte();
		while (t-- > 0) {
			System.out.println(getRamboNumbers(scan.nextLong(), scan.nextLong(), scan.nextLong()));
		}
	}

	private static BigInteger getRamboNumbers(long r, long p, long q) {
		long temp;
		if (q < p && q > 0 || p < q && q < 0 || q < 0 && p > 0) {
			temp = p;
			p = q;
			q = temp;
		}
		BigInteger c = BigInteger.valueOf(r);
		BigInteger n1 = BigInteger.valueOf(p).abs().divide(c);
		BigInteger n2 = BigInteger.valueOf(q).abs().divide(c);
		if (q < 0 && p < 0 || p > 0 && q > 0)
			return n2.subtract(n1).add(p % r == 0 ? BigInteger.ONE : BigInteger.ZERO);
		return n2.add(n1).add(BigInteger.ONE);
	}

}