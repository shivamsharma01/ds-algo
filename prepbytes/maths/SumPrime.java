package prepbytes.maths;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SumPrime {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		byte t = scan.nextByte();
		while (t-- > 0) {
			int n = scan.nextInt();
			System.out.println(nthPrimeSum(0, 1000, n));
		}
	}

	private static long nthPrimeSum(int lower, int upper, int n) {
		boolean[] sieve = new boolean[upper - lower + 1];
		Integer[] primes = primes((int) Math.sqrt(upper));
		if (lower < 1) {
			sieve[1] = true;
		}
		long sum = 0;
		for (int i = 0; i < primes.length; i++) {
			for (int j = lower - (lower % primes[i]) + primes[i]; j <= upper; j += primes[i]) {
				if (primes[i] == j)
					continue;
				sieve[j - lower] = true;
			}
		}
		for (int i = 1; i < sieve.length && n != 0; i++) {
			if (!sieve[i] && isOddPrime(i + lower)) {
				sum += (i + lower);
				n--;
			}
		}
		return n != 0 ? sum + nthPrimeSum(upper, upper * 2, n) : sum;
	}

	private static Integer[] primes(int sqrt) {
		boolean[] sieve = new boolean[sqrt + 1];
		sieve[1] = true;
		int i = 4;
		while (i <= sqrt) {
			sieve[i] = true;
			i += 2;
		}
		for (i = 3; i * i <= sqrt; i += 2) {
			if (!sieve[i]) {
				for (int j = i * i; j <= sqrt; j += i) {
					sieve[j] = true;
				}
			}
		}
		List<Integer> primes = new ArrayList<Integer>();
		primes.add(2);
		for (i = 3; i <= sqrt; i += 2) {
			if (!sieve[i])
				primes.add(i);
		}
		return primes.toArray(new Integer[primes.size()]);
	}

	private static boolean isOddPrime(int n) {
		while (n != 0) {
			int digit = n % 10;
			if (digit == 3 || digit == 5 || digit == 7) {
				return false;
			}
			n = n / 10;
		}
		return true;
	}

}
