package codechef.cookoff.year2020.may;

import java.util.Scanner;
// https://www.codechef.com/problems/CHEFSHIP
// https://www.youtube.com/watch?v=hYzUnf3LJWU (explanation)

public class ChefChefinaAndTheirFriendship {
	static int[] hash, p;
	static int mod = 1000000000 + 7, prime = 31;

	public static void main(String[] args) {
		try {
			Scanner scan = new Scanner(System.in);
			short t = scan.nextShort();
			while (t-- > 0) {
				System.out.println(getNumberOfPossibleNames(scan.next()));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	private static int getNumberOfPossibleNames(String string) {
		int n = string.length(), count = 0, firstcut, secondcut;
		generateHash(string.toCharArray());
		for (int i = 1; i < n - 1; i += 2) {
			firstcut = i / 2;
			secondcut = (i + n) / 2;
			boolean t1 = ((long) getHash(0, firstcut) * p[firstcut + 1]) % mod == getHash(firstcut + 1, i), t2 = false;
			if (t1)
				t2 = (getHash(i + 1, secondcut) * (long) p[secondcut - i]) % mod == getHash(secondcut + 1, n - 1);
			if (t2)
				count++;
		}
		return count;
	}

	private static void generateHash(char[] input) {
		hash = new int[input.length];
		p = new int[input.length];
		hash[0] = input[0] - 'a' + 1;
		p[0] = 1;
		for (int i = 1; i < input.length; i++) {
			p[i] = (int) ((p[i - 1] * (long) prime) % mod);
			hash[i] = (int) ((hash[i - 1] + ((input[i] - 'a' + 1) * (long) p[i]) % mod) % mod);
		}
	}

	private static int getHash(int l, int r) {
		if (l == 0)
			return hash[r];
		else
			return (hash[r] - hash[l - 1] + mod) % mod;
	}

}
