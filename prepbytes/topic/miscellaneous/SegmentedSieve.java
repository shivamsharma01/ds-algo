package prepbytes.topic.miscellaneous;

import java.util.ArrayList;
import java.util.List;

public class SegmentedSieve {
	public static void main(String[] args) {
		getPrimesBetween(10000000000l, 10000001000l);
	}

	private static void getPrimesBetween(long lowerBound, long upperBound) {
		boolean[] sieve = new boolean[(int) (upperBound - lowerBound + 1)];
		sieve[1] = true;
		Integer[] primes = squareRootPrimes((int) Math.sqrt(upperBound));
		for (int i = 0; i < primes.length; i++) {
			for (long j = lowerBound; j <= upperBound; j++) {
				if (j == primes[i])
					continue;
				if (j % primes[i] == 0) {
					sieve[(int) (j - lowerBound)] = true;
				}
			}
		}
	}

	private static Integer[] squareRootPrimes(int sqrt) {
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
		List<Integer> primes = new ArrayList<>();
		primes.add(2);
		for (i = 3; i < sqrt; i += 2) {
			if (!sieve[i])
				primes.add(i);
		}
		return primes.toArray(new Integer[primes.size()]);
	}

}
