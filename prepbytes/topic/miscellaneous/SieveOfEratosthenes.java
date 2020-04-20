package prepbytes.topic.miscellaneous;

/* 
 * Program to Calculate all primes less than N
 */
public class SieveOfEratosthenes {
	public static void main(String[] args) {
		getPrimes(50);
	}

	private static void getPrimes(int n) {
		boolean[] sieve = new boolean[n + 1];
		sieve[1] = true;
		int i = 4;
		while (i <= n) {
			sieve[i] = true;
			i += 2;
		}
		for (i = 3; i * i <= n; i += 2) {
			if (!sieve[i]) {
				for (int j = i * i; j <= n; j += i) {
					sieve[j] = true;
				}
			}
		}
		if (n > 2) {
			System.out.print(2 + "\t");
		}
		for (i = 3; i <= n; i += 2) {
			if (!sieve[i])
				System.out.print(i + "\t");
		}

	}

}
