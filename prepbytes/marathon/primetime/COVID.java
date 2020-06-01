package prepbytes.marathon.primetime;

import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

// https://mycode.prepbytes.com/contest/PRIMETIME/problems/COVID
public class COVID {
	public static void main(String args[]) throws IOException {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(), m = sc.nextInt(), ans = 0, mod = 1000000000 + 7;
		Set<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < m; i++)
			set.add(sc.nextInt());
		int max = Math.min(n, 200000);
		for (int i = 1; i <= max; i++) {
			if (set.contains(i))
				continue;
			ans = (ans + (int) (nCr(n, i) % mod)) % mod;
		}
		System.out.println(ans);
	}

	static long nCr(int n, int r) {
		return fact(n) / (fact(r) * fact(n - r));
	}

	static long fact(int n) {
		long res = 1;
		for (int i = 2; i <= n; i++)
			res = res * i;
		return res;
	}
}
