package general.string;

import java.util.Scanner;

/*
 * The average and best case running time of the Rabin-Karp algorithm is O(n+m), but its worst-case time is O(nm). 
 * Worst case of Rabin-Karp algorithm occurs when all characters of pattern and text are same as the hash values of all the substrings of text
 * match with hash value of pattern. 
 * For example pattern = “AAA” and text = “AAAAAAA”.
 */
public class RobinKarpStringMatching {

	// mod the hash
	public final static int MOD = 1000000000 + 7;
	// d is the number of characters in the input alphabet
	public final static int d = 256;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		/*
		 * input = 'Geeks For Geeks'; Pattern = 'Geeks'
		 */
		String input = scan.nextLine(), pattern = scan.nextLine();
		searchPattern(input, pattern);
	}

	private static void searchPattern(String text, String pattern) {
		int M = pattern.length(), N = text.length(), pHash = 0, tHash = 0, i, j, h = 1;
		for (i = 0; i < M - 1; i++)
			h = (h * d) % MOD;

		for (i = 0; i < M; i++) {
			pHash = ((d * pHash) % MOD + pattern.charAt(i)) % MOD;
			tHash = ((d * tHash) % MOD + text.charAt(i)) % MOD;
		}
		System.out.println("pHash -> " + pHash);
		for (i = 0; i <= N - M; i++) {
			System.out.println("tHash -> " + tHash + " cur start ->" + text.charAt(i));
			if (pHash == tHash) {
				for (j = 0; j < M; j++) {
					if (pattern.charAt(j) != text.charAt(i + j))
						break;
				}
				if (j == M)
					System.out.println("Match found at index " + i);
			}
			if (i < N - M) {
				tHash = ((d * (((tHash - (text.charAt(i) * h) % MOD + MOD) % MOD)) % MOD) + text.charAt(i + M)) % MOD;
				if (tHash < 0)
					tHash += MOD;
			}
		}
	}

}
