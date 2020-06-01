package leetcode.thirty_days_challenge.may;

import java.util.HashMap;
import java.util.Map;

public class UncrossedLines {

	static Map<String, Integer> map = new HashMap<>();

	public int maxUncrossedLines(int[] A, int[] B) {
		return maxUncrossedLines(A, B, 0, 0);
	}

	public int maxUncrossedLines(int[] A, int[] B, int i, int j) {
		if (i == A.length || j == B.length)
			return 0;
		String pair = i + ":" + j;
		if (map.containsKey(pair))
			return map.get(pair);
		int ans = 0;
		if (A[i] == B[j])
			ans = 1 + maxUncrossedLines(A, B, i + 1, j + 1);
		else
			ans = Math.max(maxUncrossedLines(A, B, i + 1, j), maxUncrossedLines(A, B, i, j + 1));
		map.put(pair, ans);
		return ans;
	}

	public static void main(String args[]) {
		System.out.println(new UncrossedLines().maxUncrossedLines(new int[] { 1, 4, 2 }, new int[] { 1, 2, 4 })); // 2
		map.clear();
		System.out.println(
				new UncrossedLines().maxUncrossedLines(new int[] { 2, 5, 1, 2, 5 }, new int[] { 10, 5, 2, 1, 5, 2 })); // 3
		map.clear();
		System.out.println(
				new UncrossedLines().maxUncrossedLines(new int[] { 1, 3, 7, 1, 7, 5 }, new int[] { 1, 9, 2, 5, 1 })); // 2
	}

}
