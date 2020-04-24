package prepbytes.topic.search;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MaximumDivisorInRange {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int a = scan.nextInt(), b = scan.nextInt(), q = scan.nextInt(), low, high, gcd = gcd(a, b), greatestDivisor;
		List<Integer> factors = getFactors(gcd).stream().sorted().collect(Collectors.toList());
		while (q-- > 0) {
			greatestDivisor = -1;
			low = scan.nextInt();
			high = scan.nextInt();
			Iterator<Integer> e = factors.stream().collect(Collectors.toCollection(LinkedList::new))
					.descendingIterator();
			while (e.hasNext()) {
				int divisor = e.next();
				if (divisor >= low && divisor <= high) {
					greatestDivisor = divisor;
					break;
				}
			}
			int g2 = maxdiv(a, b, low, high);
			System.out.println(g2);
			System.out.println(g2 == greatestDivisor);
			System.out.println(greatestDivisor);
		}
	}

	private static int gcd(int a, int b) {
		if (b == 0)
			return a;
		return gcd(b, a % b);
	}

	private static List<Integer> getFactors(int gcd) {
		List<Integer> factors = new ArrayList<>();
		for (int i = 1; i * i <= gcd; i++) {
			if (gcd % i == 0) {
				factors.add(gcd / i);
				factors.add(i);
			}
		}
		return factors;
	}

	private static int maxdiv(int a, int b, int low, int high) {

		int g = gcd(a, b);
		// System.out.println(g);

		int res = -1;
		if (low == 0)
			low = low + 1;
		for (int i = low; i <= g && i <= high; i++)
			if (g % i == 0)
				res = Math.max(res, Math.max(i, g / i));

		return res;
	}

}
